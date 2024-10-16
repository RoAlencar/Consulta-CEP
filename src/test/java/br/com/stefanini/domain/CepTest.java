package br.com.stefanini.domain;

import br.com.stefanini.adapter.out.jpa.cep.entities.CepEntity;
import br.com.stefanini.utils.CepTestUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CepTest {

    @Test
    void setCep(){
        Cep cep = new Cep();
        cep.setCep("Teste");
        cep.setLogradouro("Teste");
        cep.setComplemento("Teste");
        cep.setBairro("Teste");
        cep.setLocalidade("Teste");
        cep.setUf("Teste");
        cep.setEstado("Teste");
        cep.setRegiao("Teste");
        cep.setIbge(12345);
        cep.setDdd(12345);
        cep.setSiafi(12345);
        cep.setDataConsulta(new Date());

        assertThat(cep.getCep()).isEqualTo("Teste");
        assertThat(cep.getLogradouro()).isEqualTo("Teste");
        assertThat(cep.getComplemento()).isEqualTo("Teste");
        assertThat(cep.getBairro()).isEqualTo("Teste");
        assertThat(cep.getLocalidade()).isEqualTo("Teste");
        assertThat(cep.getUf()).isEqualTo("Teste");
        assertThat(cep.getEstado()).isEqualTo("Teste");
        assertThat(cep.getRegiao()).isEqualTo("Teste");
        assertThat(cep.getIbge()).isEqualTo(12345);
        assertThat(cep.getDdd()).isEqualTo(12345);
        assertThat(cep.getSiafi()).isEqualTo(12345);
        assertThat(cep.getDataConsulta()).isNotNull();
    }

    @Test
    void cepBuilder(){
         String cep = "Teste";
         String logradouro = "Teste";
         String complemento = "Teste";
         String bairro = "Teste";
         String localidade = "Teste";
         String uf = "Teste";
         String estado = "Teste";
         String regiao = "Teste";
         Integer ibge = 12345;
         Integer gia = 12345;
         Integer ddd = 12345;
         Integer siafi = 12345;

         Cep cepGerado = CepTestUtils.gerarCep();

         assertThat(cepGerado.getCep()).isEqualTo(cep);
         assertThat(cepGerado.getLogradouro()).isEqualTo(logradouro);
         assertThat(cepGerado.getComplemento()).isEqualTo(complemento);
         assertThat(cepGerado.getBairro()).isEqualTo(bairro);
         assertThat(cepGerado.getLocalidade()).isEqualTo(localidade);
         assertThat(cepGerado.getUf()).isEqualTo(uf);
         assertThat(cepGerado.getEstado()).isEqualTo(estado);
         assertThat(cepGerado.getRegiao()).isEqualTo(regiao);
         assertThat(cepGerado.getIbge()).isEqualTo(ibge);
         assertThat(cepGerado.getDdd()).isEqualTo(ddd);
         assertThat(cepGerado.getSiafi()).isEqualTo(siafi);
         assertThat(cepGerado.getDataConsulta()).isNotNull();
    }

    @Test
    void cepToEntity(){
        Cep cep = Cep.builder()
                .cep("Teste")
                .logradouro("Teste")
                .complemento("Teste")
                .bairro("Teste")
                .localidade("Teste")
                .uf("Teste")
                .estado("Teste")
                .regiao("Teste")
                .ibge(12345)
                .gia(12345)
                .ddd(12345)
                .siafi(12345)
                .build();

        CepEntity cepEntity = cep.toEntity();

        assertThat(cepEntity).isNotNull();
        assertThat(cepEntity.getCep()).isEqualTo(cep.getCep());
        assertThat(cepEntity.getLogradouro()).isEqualTo(cep.getLogradouro());
        assertThat(cepEntity.getComplemento()).isEqualTo(cep.getComplemento());
        assertThat(cepEntity.getBairro()).isEqualTo(cep.getBairro());
        assertThat(cepEntity.getLocalidade()).isEqualTo(cep.getLocalidade());
        assertThat(cepEntity.getUf()).isEqualTo(cep.getUf());
        assertThat(cepEntity.getEstado()).isEqualTo(cep.getEstado());
        assertThat(cepEntity.getRegiao()).isEqualTo(cep.getRegiao());
        assertThat(cepEntity.getIbge()).isEqualTo(cep.getIbge());
        assertThat(cepEntity.getDdd()).isEqualTo(cep.getDdd());
        assertThat(cepEntity.getSiafi()).isEqualTo(cep.getSiafi());
    }

    @Test
    void testCepCopyConstructor(){
        Cep cep = Cep.builder()
                .cep("Teste")
                .logradouro("Teste")
                .complemento("Teste")
                .bairro("Teste")
                .localidade("Teste")
                .uf("Teste")
                .estado("Teste")
                .regiao("Teste")
                .ibge(12345)
                .gia(12345)
                .ddd(12345)
                .siafi(12345)
                .build();

        Cep copiedCep = new Cep(cep);

        assertThat(copiedCep).isNotNull();
        assertThat(copiedCep.getCep()).isEqualTo(cep.getCep());
        assertThat(copiedCep.getLogradouro()).isEqualTo(cep.getLogradouro());
        assertThat(copiedCep.getComplemento()).isEqualTo(cep.getComplemento());
        assertThat(copiedCep.getBairro()).isEqualTo(cep.getBairro());
        assertThat(copiedCep.getLocalidade()).isEqualTo(cep.getLocalidade());
        assertThat(copiedCep.getUf()).isEqualTo(cep.getUf());
        assertThat(copiedCep.getEstado()).isEqualTo(cep.getEstado());
        assertThat(copiedCep.getRegiao()).isEqualTo(cep.getRegiao());
        assertThat(copiedCep.getIbge()).isEqualTo(cep.getIbge());
        assertThat(copiedCep.getDdd()).isEqualTo(cep.getDdd());
        assertThat(copiedCep.getSiafi()).isEqualTo(cep.getSiafi());
    }
}
