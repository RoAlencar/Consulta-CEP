package br.com.stefanini.adapter.out.jpa.cep.entities;

import br.com.stefanini.adapter.out.jpa.cep.CepJpaRepositoryAdapter;
import br.com.stefanini.adapter.out.jpa.cep.repositories.CepJpaRepository;
import br.com.stefanini.domain.Cep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CepJpaRepositoryAdapterTest {

    @Mock
    private CepJpaRepository cepJpaRepository;

    @Mock
    private CepJpaRepositoryAdapter cepJpaRepositoryAdapter;

    @Mock
    private CepEntity  cepEntity;

    @BeforeEach
    void setUp() {
        cepJpaRepositoryAdapter = new CepJpaRepositoryAdapter(cepJpaRepository);
    }

    @Test
    void testFindByCep_Success() {
        String cep = "12345678";
        Cep expectedCep = new Cep();
        when(cepJpaRepository.findByCep(cep)).thenReturn(Optional.of(cepEntity));

        when(cepEntity.toDomain()).thenReturn(expectedCep);

        Optional<Cep> result = cepJpaRepositoryAdapter.findByCep(cep);

        assertTrue(result.isPresent());
        assertEquals(expectedCep, result.get());
    }
    @Test
    void testFindByCep_NotFound() {
        String cep = "87654321";

        when(cepJpaRepository.findByCep(cep)).thenReturn(Optional.empty());

        Optional<Cep> result = cepJpaRepositoryAdapter.findByCep(cep);

        assertFalse(result.isPresent());
    }

}
