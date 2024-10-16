package br.com.stefanini.adapter.out.jpa.cep.repositories;

import br.com.stefanini.adapter.out.jpa.cep.entities.CepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CepJpaRepository extends JpaRepository<CepEntity, Long> {

    Optional<CepEntity> findByCep(String cep);
}
