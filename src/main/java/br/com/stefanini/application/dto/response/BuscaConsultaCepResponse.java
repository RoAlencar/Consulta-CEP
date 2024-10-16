package br.com.stefanini.application.dto.response;

import br.com.stefanini.application.dto.CepDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BuscaConsultaCepResponse extends CepDto {

    public BuscaConsultaCepResponse(CepDto dto) {
        super(dto);
    }

}
