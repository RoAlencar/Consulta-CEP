package br.com.stefanini.adapter.in.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import br.com.stefanini.application.dto.request.BuscaConsultaCepRequest;
import br.com.stefanini.application.dto.response.BuscaConsultaCepResponse;
import br.com.stefanini.application.port.BuscarConsultaCepUseCasePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class CepControllerTest {

    @Mock
    private BuscarConsultaCepUseCasePort buscaConsultaCepUseCasePort;

    @InjectMocks
    private CepController cepController;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testBuscaCep() throws Exception {
        // Arrange
        String cep = "12345678";
        BuscaConsultaCepRequest request = new BuscaConsultaCepRequest();
        request.setCep(cep); // Defina o CEP corretamente
        BuscaConsultaCepResponse expectedResponse = new BuscaConsultaCepResponse(/* preencha com os dados esperados */);

        when(buscaConsultaCepUseCasePort.pesquisaCep(cep)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<BuscaConsultaCepResponse> responseEntity = cepController.buscaCep(request);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }
}
