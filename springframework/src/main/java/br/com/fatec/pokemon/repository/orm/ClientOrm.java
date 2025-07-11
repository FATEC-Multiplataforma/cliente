package br.com.fatec.pokemon.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "client")
public record ClientOrm(
        @Id
        String id,
        @Indexed
        String nome,
        String email,
        EnderecoOrm endereco
) {
}
