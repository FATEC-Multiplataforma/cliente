package br.com.fatec.pokemon.repository.orm;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public record PokemonOrm(
        @Indexed
        String nome,
        Integer tamanho,
        List<PokemonTipoOrm> tipos
) {
}
