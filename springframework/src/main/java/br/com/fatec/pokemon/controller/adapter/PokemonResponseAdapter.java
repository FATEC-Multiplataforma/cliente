package br.com.fatec.pokemon.controller.adapter;

import br.com.fatec.pokemon.controller.dto.request.UserRequest;
import br.com.fatec.pokemon.controller.dto.response.PokemonResponse;
import br.com.fatec.pokemon.controller.dto.response.UserResponse;
import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.PokemonTipo;
import br.com.fatec.pokemon.entity.User;

import java.util.UUID;

public class PokemonResponseAdapter {
    private PokemonResponseAdapter() {

    }

    public static UserResponse cast(User user) {
        return new UserResponse(
                user.id(),
                user.nome(),
                user.endereco(),
                user.email(),
                user.cidade(),
                new PokemonResponse(
                        user.pokemonPreferido().nome(),
                        user.pokemonPreferido().tamanho(),
                        user.pokemonPreferido().tipo()
                                .stream()
                                .map(PokemonTipo::tipo)
                                .toList()));
    }

    public static User cast(UserRequest request) {
        return new User(
                UUID.randomUUID().toString(),
                request.name(),
                request.address(),
                request.email(),
                request.city(),
                new Pokemon(
                        request.pokemon(),
                        null,
                        null));
    }
}
