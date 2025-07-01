package br.com.fatec.pokemon.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
public record UserOrm(
        @Id
        String id,
        @Indexed
        String name,
        String address,
        String email,
        String city,
        PokemonOrm pokemon
) {
}
