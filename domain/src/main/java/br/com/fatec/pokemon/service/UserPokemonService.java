package br.com.fatec.pokemon.service;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.integration.PokemonIntegration;
import br.com.fatec.pokemon.repository.UserRepository;

public class UserPokemonService {
    private final UserRepository repository;
    private final PokemonIntegration integration;

    public UserPokemonService(
            UserRepository repository,
            PokemonIntegration integration) {
        this.repository = repository;
        this.integration = integration;
    }

    public User registerUserWithPokemon(User user) {
        Pokemon pokemon = integration.getPokemon(user.pokemon().name());
        return repository.save(new User(
                user.id(),
                user.name(),
                user.address(),
                user.email(),
                user.city(),
                pokemon));
    }
}