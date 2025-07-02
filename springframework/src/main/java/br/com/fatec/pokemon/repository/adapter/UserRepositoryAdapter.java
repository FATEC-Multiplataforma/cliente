package br.com.fatec.pokemon.repository.adapter;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.PokemonType;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.repository.orm.PokemonOrm;
import br.com.fatec.pokemon.repository.orm.PokemonTypeOrm;
import br.com.fatec.pokemon.repository.orm.UserOrm;

public class UserRepositoryAdapter {
    private UserRepositoryAdapter() {
    }

    public static User cast(UserOrm orm) {
        return new User(
                orm.id(),
                orm.name(),
                orm.address(),
                orm.email(),
                orm.city(),
                cast(orm.pokemon()));
    }

    private static Pokemon cast(PokemonOrm orm) {
        return new Pokemon(
                orm.name(),
                orm.weight(),
                orm.types()
                        .stream()
                        .map(v -> new PokemonType(v.type()))
                        .toList());
    }

    public static UserOrm cast(User user) {
        return new UserOrm(
                user.id(),
                user.name(),
                user.address(),
                user.email(),
                user.city(),
                cast(user.pokemon()));
    }

    private static PokemonOrm cast(Pokemon orm) {
        return new PokemonOrm(
                orm.name(),
                orm.weight(),
                orm.types()
                        .stream()
                        .map(v -> new PokemonTypeOrm(v.type()))
                        .toList());
    }

}
