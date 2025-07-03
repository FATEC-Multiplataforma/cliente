package br.com.fatec.pokemon.integration.adapter;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.PokemonTipo;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.integration.dto.PokemonApiResponse;
import br.com.fatec.pokemon.integration.dto.PokemonTypesApiResponse;

public class PokemonIntegrationAdapter {
    private PokemonIntegrationAdapter() {
    }

    public static Pokemon cast(PokemonApiResponse response) {
        return new Pokemon(
                response.name(),
                response.weight(),
                response.types()
                        .stream()
                        .map(v -> new PokemonTipo(v.type().name()))
                        .toList());
    }
}
