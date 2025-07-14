package br.com.fatec.pokemon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableCaching
@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.fatec.pokemon.integration.client")
public class PokemonApplication implements CommandLineRunner {
    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    String port;

    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Connecting to Redis at Host: " + host + " Port:" + port);
    }
}