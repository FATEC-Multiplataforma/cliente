package br.com.fatec.pokemon.integration;

import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.integration.adapter.PokemonIntegrationAdapter;
import br.com.fatec.pokemon.integration.client.PokemonIntegrationWithFeign;
import feign.FeignException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonIntegration {

    private PokemonIntegrationWithFeign integration;

    public PokemonIntegration(PokemonIntegrationWithFeign integration) {
        this.integration = integration;
    }

    @Retryable(
            maxAttempts = 4,
            backoff = @Backoff(delay = 1000))
    @Cacheable(value = "pokemon-cache", key = "#pokemonName")
    public User getPokemon(final String pokemonName) {
        System.out.println("Buscando pokemon: " + pokemonName);
        return PokemonIntegrationAdapter.cast(integration.getPokemon(pokemonName));
    }

    @Recover
    @Cacheable(value = "pokemon-cache", key = "#pokemonName")
    public User recover(FeignException ex, String pokemonName) {
        System.out.println("Fallback: " + pokemonName);
        return new User(0, "NO NOME", 0, List.of());
    }
}