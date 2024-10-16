package br.com.stefanini.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CepDto {

    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private Integer ibge;
    private Integer gia;
    private Integer ddd;
    private Integer siafi;

    public CepDto(CepDto dto){
        this.cep = dto.getCep();
        this.logradouro = dto.getLogradouro();
        this.complemento = dto.getComplemento();
        this.unidade = dto.getUnidade();
        this.bairro = dto.getBairro();
        this.localidade = dto.getLocalidade();
        this.uf = dto.getUf();
        this.estado = dto.getEstado();
        this.regiao = dto.getRegiao();
        this.ibge = dto.getIbge();
        this.gia = dto.getGia();
        this.ddd = dto.getDdd();
        this.siafi = dto.getSiafi();
    }
}
