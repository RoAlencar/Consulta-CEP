package br.com.stefanini.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CepDtoTest {

    @Test
    void testCopyConstructor() {
        CepDto original = new CepDto();
        original.setCep("12345678");
        original.setLogradouro("Rua Exemplo");
        original.setComplemento("Apto 1");
        original.setUnidade("Unidade 1");
        original.setBairro("Bairro Exemplo");
        original.setLocalidade("Cidade Exemplo");
        original.setUf("SP");
        original.setEstado("São Paulo");
        original.setRegiao("Região Exemplo");
        original.setIbge(1234567);
        original.setGia(1234);
        original.setDdd(11);
        original.setSiafi(1234);

        // Act: Crie um novo objeto CepDto usando o construtor de cópia
        CepDto copied = new CepDto(original);

        // Assert: Verifique se os valores foram copiados corretamente
        assertEquals(original.getCep(), copied.getCep());
        assertEquals(original.getLogradouro(), copied.getLogradouro());
        assertEquals(original.getComplemento(), copied.getComplemento());
        assertEquals(original.getUnidade(), copied.getUnidade());
        assertEquals(original.getBairro(), copied.getBairro());
        assertEquals(original.getLocalidade(), copied.getLocalidade());
        assertEquals(original.getUf(), copied.getUf());
        assertEquals(original.getEstado(), copied.getEstado());
        assertEquals(original.getRegiao(), copied.getRegiao());
        assertEquals(original.getIbge(), copied.getIbge());
        assertEquals(original.getGia(), copied.getGia());
        assertEquals(original.getDdd(), copied.getDdd());
        assertEquals(original.getSiafi(), copied.getSiafi());
    }
}
