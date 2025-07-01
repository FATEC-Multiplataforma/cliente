package br.com.fatec.pokemon.integration.client;

import br.com.fatec.pokemon.integration.dto.PokemonApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PokemonIntegrationImpl",
        url = "${pokemon.url}")
public interface PokemonIntegrationWithFeign {
    @GetMapping("/pokemon/{pokemonName}")
    PokemonApiResponse getPokemon(@PathVariable("pokemonName") String pokemonName);
}