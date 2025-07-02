package br.com.fatec.pokemon.entity;

import java.io.Serializable;
import java.util.List;

public record Pokemon(
        String name,
        Integer weight,
        List<PokemonType> types
) implements Serializable {
}
