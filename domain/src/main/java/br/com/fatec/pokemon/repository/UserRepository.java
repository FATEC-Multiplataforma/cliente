package br.com.fatec.pokemon.repository;

import br.com.fatec.pokemon.entity.User;

public interface UserRepository {
    User save(User user);

    User findByName(String name);

    User findById(String id);

    void delete(String id);
}
