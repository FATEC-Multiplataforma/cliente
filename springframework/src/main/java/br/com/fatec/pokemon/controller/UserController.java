package br.com.fatec.pokemon.controller;

import br.com.fatec.pokemon.controller.dto.request.UserRequest;
import br.com.fatec.pokemon.controller.dto.response.UserResponse;
import br.com.fatec.pokemon.entity.Pokemon;
import br.com.fatec.pokemon.integration.PokemonIntegration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final PokemonIntegration integration;

    public UserController(PokemonIntegration integration) {
        this.integration = integration;
    }

    @GetMapping
    public String getName() {
        return "Joao";
    }

    @PostMapping
    public UserResponse save(@RequestBody UserRequest request) {
        final Pokemon pokemon = integration.getPokemon(request.favoritePokemon());
        return new UserResponse("SUCCESS", pokemon);
    }

}
