package br.com.fatec.pokemon.controller.dto;

import java.util.List;

public record PokemonResponse(
        Integer pokemonId,
        String nome,
        Integer altura,
        List<String> tipos
) {
}
