package br.com.stefanini.infrastructure.exception;

import br.com.stefanini.infrastructure.exception.custom.CepNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<ObjectNode> handleCepNotFoundException(CepNotFoundException ex) {
        log.warn("[Busca de CEP] Cep não encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(converterMensagem("O CEP informado não encontrado na base de dados."));
    }

    ObjectNode converterMensagem(String mensagem){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("mensagem", mensagem);
        return json;
    }
}
