package br.com.stefanini.adapter.in.web;

import br.com.stefanini.application.dto.request.BuscaConsultaCepRequest;
import br.com.stefanini.application.dto.response.BuscaConsultaCepResponse;
import br.com.stefanini.application.port.BuscarConsultaCepUseCasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CepController {

    private final BuscarConsultaCepUseCasePort buscaConsultaCepUseCasePort;

    @GetMapping("/buscar-cep")
    public ResponseEntity<BuscaConsultaCepResponse> buscaCep(@RequestBody BuscaConsultaCepRequest request) throws Exception {
        log.info("Buscando CEP: {}", request.getCep());
        BuscaConsultaCepResponse buscaConsultaCepResponse = buscaConsultaCepUseCasePort.pesquisaCep(request.getCep());
        return new ResponseEntity<>(buscaConsultaCepResponse, HttpStatus.OK);
    }
}
