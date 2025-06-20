package br.com.fatec.pokemon.entity;

import java.util.List;

public record Pokemon(
        String name,
        Integer weight,
        List<PokemonType> types
) {
}
