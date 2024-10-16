package br.com.stefanini.adapter.out.jpa.cep.entities;

import br.com.stefanini.domain.Cep;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CepEntityTest {

    @Test
    void setCepEntity(){
    CepEntity cepEntity = new CepEntity();
    cepEntity.setCep("12345678");
    cepEntity.setLogradouro("Teste");
    cepEntity.setComplemento("Teste");
    cepEntity.setBairro("Teste");
    cepEntity.setLocalidade("Teste");
    cepEntity.setUf("Teste");
    cepEntity.setEstado("Teste");
    cepEntity.setRegiao("Teste");
    cepEntity.setIbge(1234);
    cepEntity.setGia(1234);
    cepEntity.setDdd(11);
    cepEntity.setSiafi(1234);
    cepEntity.setDataConsulta(new Date());

    assertThat(cepEntity.getCep().equals("12345678")).isTrue();
    assertThat(cepEntity.getLogradouro().equals("Teste")).isTrue();
    assertThat(cepEntity.getComplemento().equals("Teste")).isTrue();
    assertThat(cepEntity.getBairro().equals("Teste")).isTrue();
    assertThat(cepEntity.getLocalidade().equals("Teste")).isTrue();
    assertThat(cepEntity.getUf().equals("Teste")).isTrue();
    assertThat(cepEntity.getEstado().equals("Teste")).isTrue();
    assertThat(cepEntity.getRegiao().equals("Teste")).isTrue();
    assertThat(cepEntity.getIbge() == 1234).isTrue();
    assertThat(cepEntity.getGia() == 1234).isTrue();
    assertThat(cepEntity.getDdd() == 11).isTrue();
    assertThat(cepEntity.getSiafi() == 1234).isTrue();
    assertThat(cepEntity.getDataConsulta()).isNotNull();
    }

    @Test
    void testToDomain() {
        // Arrange: Crie um objeto CepDto com valores de teste
        CepEntity cepEntity = new CepEntity();
        cepEntity.setCep("12345678");
        cepEntity.setLogradouro("Rua Exemplo");
        cepEntity.setComplemento("Apto 1");
        cepEntity.setBairro("Bairro Exemplo");
        cepEntity.setLocalidade("Cidade Exemplo");
        cepEntity.setUf("SP");
        cepEntity.setEstado("São Paulo");
        cepEntity.setRegiao("Região Exemplo");
        cepEntity.setIbge(1234567);
        cepEntity.setGia(1234);
        cepEntity.setDdd(11);
        cepEntity.setSiafi(1234);

        // Act: Converta o objeto CepDto para Cep
        Cep cep = cepEntity.toDomain();

        // Assert: Verifique se os valores foram copiados corretamente
        assertEquals(cepEntity.getCep(), cep.getCep());
        assertEquals(cepEntity.getLogradouro(), cep.getLogradouro());
        assertEquals(cepEntity.getComplemento(), cep.getComplemento());
        assertEquals(cepEntity.getBairro(), cep.getBairro());
        assertEquals(cepEntity.getLocalidade(), cep.getLocalidade());
        assertEquals(cepEntity.getUf(), cep.getUf());
        assertEquals(cepEntity.getEstado(), cep.getEstado());
        assertEquals(cepEntity.getRegiao(), cep.getRegiao());
        assertEquals(cepEntity.getIbge(), cep.getIbge());
        assertEquals(cepEntity.getGia(), cep.getGia());
        assertEquals(cepEntity.getDdd(), cep.getDdd());
        assertEquals(cepEntity.getSiafi(), cep.getSiafi());
    }

    @Test
    void testToListDomain() {
        // Arrange: Crie um objeto CepDto com valores de teste
        CepEntity cepEntity = new CepEntity();
        cepEntity.setUf("SP");
        cepEntity.setLocalidade("Cidade Exemplo");
        cepEntity.setLogradouro("Rua Exemplo");

        // Act: Converta o objeto CepDto para Cep (versão simplificada)
        Cep cep = cepEntity.toListDomain();

        // Assert: Verifique se os valores foram copiados corretamente
        assertEquals(cepEntity.getUf(), cep.getUf());
        assertEquals(cepEntity.getLocalidade(), cep.getLocalidade());
        assertEquals(cepEntity.getLogradouro(), cep.getLogradouro());

        // Verifique se os outros campos estão nulos
        assertNull(cep.getComplemento());
        assertNull(cep.getBairro());
        assertNull(cep.getEstado());
        assertNull(cep.getRegiao());
        assertNull(cep.getIbge());
        assertNull(cep.getGia());
        assertNull(cep.getDdd());
        assertNull(cep.getSiafi());
    }

}
