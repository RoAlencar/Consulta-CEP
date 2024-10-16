package br.com.stefanini.application.dto.response;

import br.com.stefanini.application.dto.CepDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuscaConsultaCepResponseTest {

    @Test
    void testConstructorWithCepDto() {
        CepDto originalDto = new CepDto();
        originalDto.setCep("12345678");
        originalDto.setLogradouro("Rua Exemplo");
        originalDto.setComplemento("Apto 1");
        originalDto.setBairro("Bairro Exemplo");
        originalDto.setLocalidade("Cidade Exemplo");
        originalDto.setUf("SP");
        originalDto.setEstado("São Paulo");
        originalDto.setRegiao("Região Exemplo");
        originalDto.setIbge(1234567);
        originalDto.setGia(1234);
        originalDto.setDdd(11);
        originalDto.setSiafi(1234);

        // Act: Crie um novo objeto BuscaConsultaCepResponse usando o construtor com CepDto
        BuscaConsultaCepResponse response = new BuscaConsultaCepResponse(originalDto);

        // Assert: Verifique se os valores foram copiados corretamente
        assertEquals(originalDto.getCep(), response.getCep());
        assertEquals(originalDto.getLogradouro(), response.getLogradouro());
        assertEquals(originalDto.getComplemento(), response.getComplemento());
        assertEquals(originalDto.getBairro(), response.getBairro());
        assertEquals(originalDto.getLocalidade(), response.getLocalidade());
        assertEquals(originalDto.getUf(), response.getUf());
        assertEquals(originalDto.getEstado(), response.getEstado());
        assertEquals(originalDto.getRegiao(), response.getRegiao());
        assertEquals(originalDto.getIbge(), response.getIbge());
        assertEquals(originalDto.getGia(), response.getGia());
        assertEquals(originalDto.getDdd(), response.getDdd());
        assertEquals(originalDto.getSiafi(), response.getSiafi());
    }
}
