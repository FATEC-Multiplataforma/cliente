package br.com.fatec.pokemon.controller;

import br.com.fatec.pokemon.controller.adapter.PokemonResponseAdapter;
import br.com.fatec.pokemon.controller.dto.UserRequest;
import br.com.fatec.pokemon.controller.dto.UserResponseV1;
import br.com.fatec.pokemon.controller.dto.UserResponseV2;
import br.com.fatec.pokemon.integration.PokemonIntegration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class UserController {

    private final PokemonIntegration integration;

    public UserController(PokemonIntegration integration) {
        this.integration = integration;
    }

    @GetMapping("/v1/{pokemonName}")
    public UserResponseV1 getNameV1(@PathVariable("pokemonName") String nome) {
        return PokemonResponseAdapter.castV1(integration.getPokemon(nome));
    }

    @GetMapping("/v2/{pokemonName}")
    public UserResponseV2 getNameV2(@PathVariable("pokemonName") String nome) {
        return PokemonResponseAdapter.castV2(integration.getPokemon(nome));
    }

    @PostMapping
    public UserResponseV1 save(@RequestBody UserRequest request) {
        System.out.println(request.name());
        return new UserResponseV1("SUCCESS", 10);
    }

}
