package br.com.fatec.pokemon.controller.dto.response;

public record UserResponse(
        String id,
        String nome,
        String endereco,
        String email,
        String cidade,
        PokemonResponse pokemon
) {
}
