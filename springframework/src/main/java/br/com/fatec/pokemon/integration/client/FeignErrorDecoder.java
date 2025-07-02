package br.com.fatec.pokemon.integration.client;

import br.com.fatec.pokemon.exception.BadRequestException;
import br.com.fatec.pokemon.exception.InternalServerException;
import br.com.fatec.pokemon.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 400:
                throw new BadRequestException("Integracao com PokemonAPI com Falha");
            case 404:
                throw new NotFoundException("Pokemon não existe");
            default:
                throw new InternalServerException("Erro não mapeado na PokemonAPI");
        }
    }
}
