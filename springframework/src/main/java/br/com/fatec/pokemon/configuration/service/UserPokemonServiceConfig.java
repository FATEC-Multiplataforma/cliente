package br.com.fatec.pokemon.configuration.service;

import br.com.fatec.pokemon.integration.PokemonIntegration;
import br.com.fatec.pokemon.repository.UserRepository;
import br.com.fatec.pokemon.service.UserPokemonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserPokemonServiceConfig {

    @Bean
    public UserPokemonService userPokemonService(
            UserRepository repository, PokemonIntegration integration) {
        return new UserPokemonService(repository, integration);
    }

}
