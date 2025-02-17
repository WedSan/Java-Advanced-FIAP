package br.com.fiap.service;



import br.com.fiap.controller.dto.PokemonResponseDTO;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.mapper.PokemonMapper;
import br.com.fiap.repository.PokemonRepository;
import br.com.fiap.service.client.PokemonRestClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PokemonRestClientService {

    private final PokemonRestClient pokemonClient;
    private final PokemonRepository pokemonRepository;

    public PokemonRestClientService(PokemonRestClient pokemonClient, PokemonRepository pokemonRepository) {
        this.pokemonClient = pokemonClient;
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonResponseDTO captureAndSavePokemon(String name) {
        Pokemon apiPokemon = pokemonClient.getPokemonByName(name);

        if (apiPokemon == null) {
            throw new RuntimeException("Failed to fetch pokemon: " + name);
        }

        apiPokemon.setId(null);
        Pokemon savedPokemon = pokemonRepository.save(apiPokemon);

        return PokemonMapper.convertToResponse(savedPokemon);
    }

    public PokemonResponseDTO getRandomPokemon() {
        Random generator = new Random();
        int randomPokemonId = generator.nextInt( 500);
        Pokemon pokemonFound = pokemonClient.getPokemonById(randomPokemonId);
        return PokemonMapper.convertToResponse(pokemonFound);
    }

    public List<PokemonResponseDTO> getAllCapturedPokemons() {
        return pokemonRepository.findAll().stream()
                .map(PokemonMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    public PokemonResponseDTO getPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokémon não encontrado com o ID: " + id));
        return PokemonMapper.convertToResponse(pokemon);
    }

}