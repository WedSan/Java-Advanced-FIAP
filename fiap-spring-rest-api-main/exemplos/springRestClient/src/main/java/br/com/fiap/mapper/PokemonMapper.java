package br.com.fiap.mapper;

import br.com.fiap.controller.dto.PokemonResponseDTO;
import br.com.fiap.entity.Pokemon;

import java.util.stream.Collectors;

public class PokemonMapper {

    public static PokemonResponseDTO convertToResponse(Pokemon pokemon) {
        return new PokemonResponseDTO(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getTypes().stream()
                        .map(type -> type.getType().getName())
                        .collect(Collectors.joining(", "))
        );
    }
}
