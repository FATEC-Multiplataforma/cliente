package br.com.fatec.pokemon.controller.dto.response;

import java.util.List;

public record PokemonResponse(
        String nome,
        Integer altura,
        List<String> tipos
) {
}
