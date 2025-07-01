package br.com.fatec.pokemon.repository.orm;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public record PokemonOrm(
        @Indexed
        String name,
        Integer weight,
        List<PokemonTypeOrm> types
) {
}
