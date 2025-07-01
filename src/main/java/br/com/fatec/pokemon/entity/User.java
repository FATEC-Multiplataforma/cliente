package br.com.fatec.pokemon.entity;

import java.util.List;

public record User(
        Integer id,
        String nome,
        Integer tamanho,
        List<String> tipos
) {
}