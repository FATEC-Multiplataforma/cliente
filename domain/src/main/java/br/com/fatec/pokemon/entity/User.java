package br.com.fatec.pokemon.entity;

public record User(
        String id,
        String name,
        String address,
        String email,
        String city,
        Pokemon pokemon
) {
}
