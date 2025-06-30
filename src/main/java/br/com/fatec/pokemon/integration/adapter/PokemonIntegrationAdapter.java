package br.com.fatec.pokemon.integration.adapter;

import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.integration.dto.PokemonApiResponse;

public class PokemonIntegrationAdapter {
    private PokemonIntegrationAdapter() {
    }

    public static User cast(PokemonApiResponse response) {
        return new User(
                response.id(),
                response.name(),
                response.weight(),
                response.types()
                        .stream()
                        .map(v -> v.type().name())
                        .toList());
    }
}
