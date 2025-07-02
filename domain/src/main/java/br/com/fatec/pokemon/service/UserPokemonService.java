package br.com.fatec.pokemon.service;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.exception.BadRequestException;
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
        try {
            User updateUser = repository.findByName(user.name());
            return save(updateUser.id(), user);
        } catch (BadRequestException ex) {
            return save(user);
        }
    }

    private User save(User user) {
        return save(user.id(), user);
    }

    private User save(final String id, User user) {
        Pokemon pokemon = integration.getPokemon(user.pokemon().name());
        return repository.save(new User(
                id,
                user.name(),
                user.address(),
                user.email(),
                user.city(),
                pokemon));
    }

}