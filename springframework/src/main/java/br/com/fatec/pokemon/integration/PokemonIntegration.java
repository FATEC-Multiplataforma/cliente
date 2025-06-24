package br.com.fatec.pokemon.integration;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.PokemonType;
import br.com.fatec.pokemon.integration.adapter.PokemonIntegrationAdapter;
import br.com.fatec.pokemon.integration.client.PokemonIntegrationWithFeign;
import br.com.fatec.pokemon.integration.dto.PokemonApiResponse;
import feign.FeignException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonIntegration {
    public final PokemonIntegrationWithFeign integration;

    public PokemonIntegration(PokemonIntegrationWithFeign integration) {
        this.integration = integration;
    }

    @Retryable(
            maxAttempts = 4,
            backoff = @Backoff(delay = 1000))
    @Cacheable(value = "pokemon-cache", key = "#pokemon")
    public Pokemon getPokemon(final String pokemon) {
        System.out.println("Buscando pokemon: " + pokemon);
        PokemonApiResponse pokemonResponse = integration.getPokemon(pokemon);
        return PokemonIntegrationAdapter.cast(pokemonResponse);
    }

//    @Recover
//    @Cacheable(value = "pokemon-cache", key = "#pokemon")
//    public Pokemon recover(final FeignException ex, final String pokemon) {
//        System.out.println("Fallback: " + pokemon);
//        return new Pokemon("NO NAME", 0, List.of(new PokemonType("NO TYPE")));
//    }

}
