package br.com.stefanini.adapter.out.jpa.cep;

import br.com.stefanini.adapter.out.jpa.cep.repositories.CepJpaRepository;
import br.com.stefanini.adapter.out.jpa.cep.entities.CepEntity;
import br.com.stefanini.application.port.CepRepositoryPort;
import br.com.stefanini.domain.Cep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CepJpaRepositoryAdapter implements CepRepositoryPort {

    private final CepJpaRepository cepJpaRepository;

    @Override
    public Cep save(Cep cep) {
        return cepJpaRepository.save(cep.toEntity()).toDomain();
    }

    @Override
    public Optional<Cep> findByCep(String cep) {
        return cepJpaRepository.findByCep(cep)
                .map(CepEntity::toDomain);
    }

}
