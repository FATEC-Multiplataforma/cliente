package br.com.fatec.pokemon.controller.dto;

public record UserRequest(
        String name,
        String address,
        String email
) {
}
