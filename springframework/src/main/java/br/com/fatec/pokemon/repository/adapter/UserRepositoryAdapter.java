package br.com.fatec.pokemon.repository.adapter;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.PokemonTipo;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.repository.orm.PokemonOrm;
import br.com.fatec.pokemon.repository.orm.PokemonTipoOrm;
import br.com.fatec.pokemon.repository.orm.UserOrm;

public class UserRepositoryAdapter {
    private UserRepositoryAdapter() {
    }

    public static UserOrm cast(User user) {
        return new UserOrm(
                user.id(),
                user.nome(),
                user.endereco(),
                user.email(),
                user.cidade(),
                cast(user.pokemonPreferido())
        );
    }

    private static PokemonOrm cast(Pokemon pokemon) {
        return new PokemonOrm(
                pokemon.nome(),
                pokemon.tamanho(),
                pokemon.tipo()
                        .stream()
                        .map(v -> new PokemonTipoOrm(v.tipo()))
                        .toList());
    }

    public static User cast(UserOrm orm) {
        return new User(
                orm.id(),
                orm.nome(),
                orm.endereco(),
                orm.email(),
                orm.cidade(),
                cast(orm.pokemon()));
    }

    private static Pokemon cast(PokemonOrm pokemon) {
        return new Pokemon(
                pokemon.nome(),
                pokemon.tamanho(),
                pokemon.tipos()
                        .stream()
                        .map(v -> new PokemonTipo(v.tipo()))
                        .toList());
    }

}
