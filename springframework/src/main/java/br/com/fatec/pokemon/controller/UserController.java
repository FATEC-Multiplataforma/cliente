package br.com.fatec.pokemon.controller;

import br.com.fatec.pokemon.controller.adapter.UserControllerAdapter;
import br.com.fatec.pokemon.controller.dto.request.UserRequest;
import br.com.fatec.pokemon.controller.dto.response.UserResponse;
import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.repository.UserRepository;
import br.com.fatec.pokemon.service.UserPokemonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon/v1")
public class UserController {
    private final UserRepository repository;
    private final UserPokemonService service;

    public UserController(UserRepository repository, UserPokemonService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public UserResponse save(@RequestBody UserRequest request) {
        User user = UserControllerAdapter.cast(request);
        return UserControllerAdapter.cast(service.registerUserWithPokemon(user));
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable(value = "id") String id) {
        return UserControllerAdapter.cast(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        repository.delete(id);
    }

}
