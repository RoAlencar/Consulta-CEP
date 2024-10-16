package br.com.stefanini.application.usecase;

import br.com.stefanini.application.port.BuscarConsultaCepUseCasePort;
import br.com.stefanini.application.port.CepRepositoryPort;
import br.com.stefanini.adapter.out.feign.ViaCepClient;
import br.com.stefanini.application.dto.CepDto;
import br.com.stefanini.application.dto.response.BuscaConsultaCepResponse;
import br.com.stefanini.domain.Cep;
import br.com.stefanini.infrastructure.exception.custom.CepNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuscaConsultaCepUseCase implements BuscarConsultaCepUseCasePort {

    private final CepRepositoryPort cepRepository;
    private final ViaCepClient viaCepClient;
    private final ModelMapper modelMapper;

    @Override
    public BuscaConsultaCepResponse pesquisaCep(String request) throws Exception {
        try {
            CepDto cepDto = viaCepClient.buscaCEP(request);
            BuscaConsultaCepResponse response = modelMapper.map(cepDto, BuscaConsultaCepResponse.class);
            Cep cep = Cep.builder()
                    .cep(response.getCep())
                    .logradouro(response.getLogradouro())
                    .complemento(response.getComplemento())
                    .bairro(response.getBairro())
                    .localidade(response.getLocalidade())
                    .uf(response.getUf())
                    .estado(response.getEstado())
                    .regiao(response.getRegiao())
                    .ibge(response.getIbge())
                    .gia(response.getGia())
                    .ddd(response.getDdd())
                    .siafi(response.getSiafi())
                    .dataConsulta(new Date())
                    .build();
            return modelMapper.map(cepRepository.save(cep),BuscaConsultaCepResponse.class);
        } catch (Exception e){
            log.error("Erro ao buscar CEP: ", e.getMessage());
            throw new CepNotFoundException();
        }
    }
}
