package br.com.stefanini.utils;

import br.com.stefanini.domain.Cep;

import java.util.Date;

public class CepTestUtils {

    private CepTestUtils(){}

    public static Cep gerarCep(){
        return Cep.builder()
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
                .dataConsulta(new Date())
                .build();
    }
}
