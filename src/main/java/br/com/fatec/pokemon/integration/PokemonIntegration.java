package br.com.fatec.pokemon.integration;

import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.integration.adapter.PokemonIntegrationAdapter;
import org.springframework.stereotype.Component;

@Component
public class PokemonIntegration {

    private PokemonIntegrationWithFeign integration;

    public PokemonIntegration(PokemonIntegrationWithFeign integration) {
        this.integration = integration;
    }

    public User getPokemon(final String pokemonName) {
        return PokemonIntegrationAdapter.cast(integration.getPokemon(pokemonName));
    }
}