package br.com.fatec.pokemon.controller.dto.response;

import java.util.List;

public record UserResponseV2(
        Integer pokemonId,
        String nome,
        Integer tamanho,
        List<String> tipos
) {
}
