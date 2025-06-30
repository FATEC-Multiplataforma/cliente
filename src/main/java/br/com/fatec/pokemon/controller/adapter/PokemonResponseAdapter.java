package br.com.fatec.pokemon.controller.adapter;

import br.com.fatec.pokemon.controller.dto.PokemonResponse;
import br.com.fatec.pokemon.entity.User;

public class PokemonResponseAdapter {
    private PokemonResponseAdapter() {

    }

    public static PokemonResponse cast(User api) {
        return new PokemonResponse(
                api.id(),
                api.nome(),
                api.tamanho(),
                api.tipos());
    }
}
