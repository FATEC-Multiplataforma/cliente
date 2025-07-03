package br.com.fatec.pokemon.integration;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.PokemonTipo;
import br.com.fatec.pokemon.integration.client.PokemonIntegrationWithFeign;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonIntegrationImpl implements PokemonIntegration {

    private PokemonIntegrationWithFeign integration;

    public PokemonIntegrationImpl(PokemonIntegrationWithFeign integration) {
        this.integration = integration;
    }

    @Retryable(
            maxAttempts = 4,
            backoff = @Backoff(delay = 1000))
    @Cacheable(value = "pokemon-cache", key = "#pokemonName")
    public Pokemon getPokemon(final String pokemonName) {
        return new Pokemon(
                "Pikachu",
                80,
                List.of(new PokemonTipo("Eletrico")));

//        System.out.println("Buscando pokemon: " + pokemonName);
//        return PokemonIntegrationAdapter.cast(integration.getPokemon(pokemonName));
    }

//    @Recover
//    @Cacheable(value = "pokemon-cache", key = "#pokemonName")
//    public User recover(FeignException ex, String pokemonName) {
//        System.out.println("Fallback: " + pokemonName);
//        return new User(0, "NO NOME", 0, List.of());
//    }
}