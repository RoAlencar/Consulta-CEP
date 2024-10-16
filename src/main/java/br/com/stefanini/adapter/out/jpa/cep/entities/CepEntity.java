package br.com.stefanini.adapter.out.jpa.cep.entities;

import br.com.stefanini.domain.Cep;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "CORE_CONSULTA")
public class CepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long idConsulta;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "LOCALIDADE")
    private String localidade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "REGIAO")
    private String regiao;

    @Column(name = "IBGE")
    private Integer ibge;

    @Column(name = "GIA")
    private Integer gia;

    @Column(name = "DDD")
    private Integer ddd;

    @Column(name = "SIAFI")
    private Integer siafi;

    @Column(name = "DATA_CONSULTA")
    private Date dataConsulta;

    public Cep toDomain() {
        return Cep.builder()
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
                .build();
    }

    public Cep toListDomain(){
        Cep cep = new Cep();
        cep.setUf(this.uf);
        cep.setLocalidade(this.localidade);
        cep.setLogradouro(this.logradouro);
        return cep;
    }
}
