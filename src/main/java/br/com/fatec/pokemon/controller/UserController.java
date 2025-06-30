package br.com.fatec.pokemon.controller;

import br.com.fatec.pokemon.controller.adapter.PokemonResponseAdapter;
import br.com.fatec.pokemon.controller.dto.PokemonResponse;
import br.com.fatec.pokemon.controller.dto.UserRequest;
import br.com.fatec.pokemon.controller.dto.UserResponse;
import br.com.fatec.pokemon.integration.PokemonIntegration;
import br.com.fatec.pokemon.integration.PokemonIntegrationWithFeign;
import br.com.fatec.pokemon.integration.dto.PokemonApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final PokemonIntegration integration;

    public UserController(PokemonIntegration integration) {
        this.integration = integration;
    }

    @GetMapping("/{pokemonName}")
    public PokemonResponse getName(@PathVariable("pokemonName") String nome) {
        return PokemonResponseAdapter.cast(integration.getPokemon(nome));
    }

    @PostMapping
    public UserResponse save(@RequestBody UserRequest request) {
        System.out.println(request.name());
        return new UserResponse("SUCCESS");
    }

}
