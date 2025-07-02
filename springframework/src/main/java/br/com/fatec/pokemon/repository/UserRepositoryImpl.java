package br.com.fatec.pokemon.repository;

import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.exception.BadRequestException;
import br.com.fatec.pokemon.exception.InternalServerException;
import br.com.fatec.pokemon.repository.adapter.UserRepositoryAdapter;
import br.com.fatec.pokemon.repository.client.UserRepositoryWithFeign;
import br.com.fatec.pokemon.repository.orm.UserOrm;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserRepositoryWithFeign repository;

    public UserRepositoryImpl(UserRepositoryWithFeign repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        try {
            UserOrm orm = UserRepositoryAdapter.cast(user);
            return UserRepositoryAdapter.cast(repository.save(orm));
        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }

    @Override
    public User findByName(final String name) {
        try {
            Optional<UserOrm> optional = repository.findByName(name);
            if (optional.isEmpty()) {
                throw new BadRequestException("Pokemon não existe no mongo");
            }
            return UserRepositoryAdapter.cast(optional.get());
        } catch (BadRequestException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }

    @Override
    public User findById(final String id) {
        try {
            Optional<UserOrm> optional = repository.findById(id);
            if (optional.isEmpty()) {
                throw new BadRequestException("Pokemon não existe no mongo");
            }
            return UserRepositoryAdapter.cast(optional.get());
        } catch (BadRequestException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }

    @Override
    public void delete(final String id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }
}