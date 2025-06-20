package br.com.fatec.pokemon.integration.adapter;

import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.entity.PokemonType;
import br.com.fatec.pokemon.integration.dto.PokemonApiResponse;
import br.com.fatec.pokemon.integration.dto.PokemonTypeApiResponse;
import br.com.fatec.pokemon.integration.dto.PokemonTypesApiResponse;

import java.util.List;
import java.util.Objects;

public class PokemonIntegrationAdapter {
    private PokemonIntegrationAdapter() {
    }

    public static Pokemon cast(PokemonApiResponse response) {
        return new Pokemon(
                response.name(),
                response.weight(),
                castTypes(response.types()));
    }

    private static List<PokemonType> castTypes(List<PokemonTypesApiResponse> types) {
        return types.stream()
                .map(PokemonTypesApiResponse::type)
                .filter(Objects::nonNull)
                .map(PokemonTypeApiResponse::name)
                .filter(Objects::nonNull)
                .map(PokemonType::new)
                .toList();
    }

}
