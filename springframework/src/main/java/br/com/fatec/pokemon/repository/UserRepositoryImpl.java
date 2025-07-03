package br.com.fatec.pokemon.repository;

import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.exception.InternalServerException;
import br.com.fatec.pokemon.exception.NotFoundException;
import br.com.fatec.pokemon.repository.adapter.UserRepositoryAdapter;
import br.com.fatec.pokemon.repository.client.UserRepositoryWithMongo;
import br.com.fatec.pokemon.repository.orm.UserOrm;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryWithMongo repository;

    public UserRepositoryImpl(UserRepositoryWithMongo repository) {
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
    public User findById(final String id) {
        try {
            Optional<UserOrm> optional = repository.findById(id);
            if (optional.isEmpty()) {
                throw new NotFoundException("Pokemon nao existe");
            }
            return UserRepositoryAdapter.cast(
                    repository.save(optional.get()));
        } catch (NotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalServerException(ex);
        }
    }

    @Override
    public User findByName(final String name) {
        try {
            Optional<UserOrm> optional = repository.findByNome(name);
            if (optional.isEmpty()) {
                throw new NotFoundException("Pokemon nao existe");
            }
            return UserRepositoryAdapter.cast(
                    repository.save(optional.get()));
        } catch (NotFoundException ex) {
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
