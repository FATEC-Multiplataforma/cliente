package br.com.fatec.pokemon.repository.client;

import br.com.fatec.pokemon.repository.orm.ClientOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryWithMongo extends MongoRepository<ClientOrm, String> {
    Optional<ClientOrm> findByNome(String name);
}
