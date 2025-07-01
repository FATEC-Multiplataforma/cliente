package br.com.fatec.pokemon.repository;

import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.exception.InternalServerException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User save(User user) {
        try {
            return null;
        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }

    @Override
    public User findById(String id) {
        try {
            return null;
        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }

    @Override
    public void delete(String id) {
        try {

        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }
}