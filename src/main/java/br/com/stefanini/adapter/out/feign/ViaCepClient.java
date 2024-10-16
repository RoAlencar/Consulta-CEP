package br.com.stefanini.adapter.out.feign;

import br.com.stefanini.application.dto.CepDto;
import br.com.stefanini.application.dto.response.BuscaConsultaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "viaCepClient", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    BuscaConsultaCepResponse buscaCEP(@PathVariable("cep") String cep);

    @GetMapping("${uf}/${cidade}/${logradouro}/json")
    List<CepDto> pesquisaCEP(@RequestParam String uf, @RequestParam String cidade, @RequestParam String logradouro);
}
