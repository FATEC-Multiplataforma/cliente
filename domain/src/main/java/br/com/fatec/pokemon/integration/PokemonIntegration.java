package br.com.fatec.pokemon.integration;

import br.com.fatec.pokemon.entity.Pokemon;

public interface PokemonIntegration {
    Pokemon getPokemon(String pokemonName);
}
