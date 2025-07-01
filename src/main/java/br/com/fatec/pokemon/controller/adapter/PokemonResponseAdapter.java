package br.com.fatec.pokemon.controller.adapter;

import br.com.fatec.pokemon.controller.dto.UserResponseV1;
import br.com.fatec.pokemon.controller.dto.UserResponseV2;
import br.com.fatec.pokemon.entity.User;

public class PokemonResponseAdapter {
    private PokemonResponseAdapter() {

    }

    public static UserResponseV1 castV1(User api) {
        return new UserResponseV1(
                api.nome(),
                api.tamanho());
    }

    public static UserResponseV2 castV2(User api) {
        return new UserResponseV2(
                api.id(),
                api.nome(),
                api.tamanho(),
                api.tipos());
    }
}
