package br.com.fatec.pokemon.entity;

import java.util.List;

public record Pokemon(
        String nome,
        Integer tamanho,
        List<PokemonTipo> tipo
) {
}
