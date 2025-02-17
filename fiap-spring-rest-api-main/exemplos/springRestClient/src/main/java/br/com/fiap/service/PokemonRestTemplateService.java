package br.com.fiap.service;


import br.com.fiap.controller.dto.PokemonResponseDTO;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.mapper.PokemonMapper;
import br.com.fiap.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.hibernate.generator.Generator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PokemonRestTemplateService {

    private final RestTemplate restTemplate;
    private final PokemonRepository pokemonRepository;
    private static String defaultUrl = "https://pokeapi.co/api/v2/pokemon/";

    public PokemonRestTemplateService(RestTemplate restTemplate, PokemonRepository pokemonRepository) {
        this.restTemplate = restTemplate;
        this.pokemonRepository = pokemonRepository;
    }

    @Transactional
    public PokemonResponseDTO captureAndSavePokemon(String name) {
        String url = defaultUrl + name;
        Pokemon apiPokemon;

        try {
            apiPokemon = restTemplate.getForObject(url, Pokemon.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("Pokémon not found: " + name);
            }
            throw new RuntimeException("Failed to fetch pokemon: " + e.getMessage());
        }

        Pokemon existingPokemon = pokemonRepository.findByName(apiPokemon.getName())
                .orElse(null);

        if (existingPokemon != null) {
            existingPokemon.setHeight(apiPokemon.getHeight());
            existingPokemon.setWeight(apiPokemon.getWeight());
            existingPokemon.setTypes(apiPokemon.getTypes());

            pokemonRepository.save(existingPokemon);
            return PokemonMapper.convertToResponse(existingPokemon);
        }

        apiPokemon.setId(null);
        Pokemon savedPokemon = pokemonRepository.save(apiPokemon);
        return PokemonMapper.convertToResponse(savedPokemon);
    }

    public PokemonResponseDTO getRandomPokemon() {
        Random generator = new Random();
        int pokemonRandomId = generator.nextInt(500);
        String url = defaultUrl + pokemonRandomId;
        Pokemon pokemonFound = restTemplate.getForObject(url, Pokemon.class);
        return PokemonMapper.convertToResponse(pokemonFound);
    }

    public List<PokemonResponseDTO> getAllCapturedPokemons() {
        return pokemonRepository.findAll().stream()
                .map(PokemonMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    public PokemonResponseDTO getPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokémon not found with id: " + id));
        return PokemonMapper.convertToResponse(pokemon);
    }

}