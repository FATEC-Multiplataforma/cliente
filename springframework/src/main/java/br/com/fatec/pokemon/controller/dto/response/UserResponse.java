package br.com.fatec.pokemon.controller.dto.response;

import br.com.fatec.pokemon.entity.Pokemon;

public record UserResponse(
        String message,
        Pokemon pokemon
) {
}