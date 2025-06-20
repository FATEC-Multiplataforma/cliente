package br.com.fatec.pokemon.integration.dto;

import java.util.List;

public record PokemonApiResponse(
        Integer id,
        String name,
        Integer weight,
        List<PokemonTypesApiResponse> types
) {
}
