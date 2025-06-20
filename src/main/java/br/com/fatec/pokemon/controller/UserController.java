package br.com.fatec.pokemon.controller;

import br.com.fatec.pokemon.controller.dto.UserRequest;
import br.com.fatec.pokemon.controller.dto.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public String getName() {
        return "Joao";
    }

    @PostMapping
    public UserResponse save(@RequestBody UserRequest request) {
        System.out.println(request.name());
        return new UserResponse("SUCCESS");
    }

}
