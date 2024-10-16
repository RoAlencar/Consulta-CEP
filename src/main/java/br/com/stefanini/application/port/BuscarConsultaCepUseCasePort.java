package br.com.stefanini.application.port;

import br.com.stefanini.application.dto.response.BuscaConsultaCepResponse;

public interface BuscarConsultaCepUseCasePort {

    BuscaConsultaCepResponse pesquisaCep(String request) throws Exception;

    //List<BuscaConsultaCepResponse> pesquisaCep(String uf, String cidade, String logradouro) throws Exception;
}
