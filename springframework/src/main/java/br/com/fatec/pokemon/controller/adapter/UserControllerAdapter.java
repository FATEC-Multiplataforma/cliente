package br.com.fatec.pokemon.controller.adapter;

import br.com.fatec.pokemon.controller.dto.request.UserRequest;
import br.com.fatec.pokemon.controller.dto.response.UserResponse;
import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.User;

import java.util.UUID;

public class UserControllerAdapter {
    private UserControllerAdapter() {
    }

    public static User cast(UserRequest request) {
        return new User(
                UUID.randomUUID().toString(),
                request.name(),
                request.address(),
                request.email(),
                request.city(),
                new Pokemon(
                        request.favoritePokemon(),
                        null,
                        null));
    }

    public static UserResponse cast(User user) {
        return new UserResponse(
                user.id(),
                user.name(),
                user.pokemon());
    }
}