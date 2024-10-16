package br.com.stefanini.domain;

import br.com.stefanini.adapter.out.jpa.cep.entities.CepEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private Integer ibge;
    private Integer gia;
    private Integer ddd;
    private Integer siafi;
    private Date dataConsulta;

    public Cep(Cep cep) {
        this.cep = cep.getCep();
        this.logradouro = cep.getLogradouro();
        this.complemento = cep.getComplemento();
        this.bairro = cep.getBairro();
        this.localidade = cep.getLocalidade();
        this.uf = cep.getUf();
        this.estado = cep.getEstado();
        this.regiao = cep.getRegiao();
        this.ibge = cep.getIbge();
        this.gia = cep.getGia();
        this.ddd = cep.getDdd();
        this.siafi = cep.getSiafi();
        this.dataConsulta = cep.getDataConsulta();
    }

    public CepEntity toEntity() {
        return CepEntity.builder()
                .cep(this.cep)
                .logradouro(this.logradouro)
                .complemento(this.complemento)
                .bairro(this.bairro)
                .localidade(this.localidade)
                .uf(this.uf)
                .estado(this.estado)
                .regiao(this.regiao)
                .ibge(this.ibge)
                .gia(this.gia)
                .ddd(this.ddd)
                .siafi(this.siafi)
                .dataConsulta(this.dataConsulta)
                .build();
    }
}
