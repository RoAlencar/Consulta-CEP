package br.com.stefanini.application.port;

import br.com.stefanini.domain.Cep;

import java.util.Optional;

public interface CepRepositoryPort {

    Cep save(Cep cep);
    Optional<Cep> findByCep(String cep);
}
