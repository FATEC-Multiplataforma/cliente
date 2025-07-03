package br.com.fatec.pokemon.service;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.exception.NotFoundException;
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

    public User register(User user) {
        try {
            User updateUser = repository.findByName(user.nome());
            return save(updateUser.id(), user);
        } catch (NotFoundException ex) {
            return save(user);
        }
    }

    private User save(User user) {
        return save(user.id(), user);
    }

    private User save(final String id, User user) {
        Pokemon pokemon = integration.getPokemon(user.pokemonPreferido().nome());
        return repository.save(new User(
                id,
                user.nome(),
                user.endereco(),
                user.email(),
                user.cidade(),
                pokemon));
    }


}
