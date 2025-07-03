package br.com.fatec.pokemon.service;

import br.com.fatec.pokemon.entity.Endereco;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.exception.NotFoundException;
import br.com.fatec.pokemon.integration.CepIntegration;
import br.com.fatec.pokemon.repository.UserRepository;

public class UserPokemonService {
    private final UserRepository repository;
    private final CepIntegration integration;

    public UserPokemonService(
            UserRepository repository,
            CepIntegration integration) {
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
        Endereco endereco = integration.getCep(user.endereco().cep());
        return repository.save(new User(
                id,
                user.nome(),
                user.email(),
                endereco));
    }


}
