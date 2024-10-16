package br.com.stefanini.application.usecase;

import br.com.stefanini.adapter.out.feign.ViaCepClient;
import br.com.stefanini.application.dto.CepDto;
import br.com.stefanini.application.dto.response.BuscaConsultaCepResponse;
import br.com.stefanini.application.port.CepRepositoryPort;
import br.com.stefanini.application.usecase.BuscaConsultaCepUseCase;
import br.com.stefanini.domain.Cep;
import br.com.stefanini.infrastructure.exception.custom.CepNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscaConsultaCepUseCaseTest {

    @InjectMocks
    private BuscaConsultaCepUseCase buscaConsultaCepUseCase;

    @Mock
    private CepRepositoryPort cepRepository;

    @Mock
    private ViaCepClient viaCepClient;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void testPesquisaCep_Exception() throws Exception {
        // Arrange
        String cepRequest = "12345678";
        when(viaCepClient.buscaCEP(cepRequest)).thenThrow(new RuntimeException());

        // Act & Assert
        try {
            buscaConsultaCepUseCase.pesquisaCep(cepRequest);
        } catch (CepNotFoundException e) {
            assertEquals(null, e.getMessage());
        }
    }
}
