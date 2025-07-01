package br.com.fatec.pokemon.repository;

import br.com.fatec.pokemon.entity.User;

public interface UserRepository {
    User save(User user);

    User findById(String id);

    void delete(String id);
}
