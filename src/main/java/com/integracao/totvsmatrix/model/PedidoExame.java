package com.integracao.totvsmatrix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PedidoExame")
public class PedidoExame {
    @JsonProperty("CODCOLIGADA")
    private int codColigada;
    @Id
    @JsonProperty("ORDEMSERVICO")
    private Integer ordemServico;

    @JsonProperty("NUMEROCONTA")
    private String numeroConta;
    @JsonProperty("SEQUENCIALCONTA")
    private int sequencialConta;
    @JsonProperty("EXAMELEITO")
    private String exameLeito;

    //@JsonProperty("DATAEXAME")
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //private LocalDateTime dataExame;

    @JsonProperty("CODMEDSOLICITANTE")
    private int codMedSolicitante;

    //@JsonProperty("DATAGRAVACAO")
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //private LocalDateTime dataGravacao;

    @JsonProperty("NOMEMEDICOSOLIC")
    private String nomeMedicoSolic;
    @JsonProperty("TIPOMEDSOLIC")
    private String tipoMedSolic;
    @JsonProperty("CODSETOR")
    private int codSetor;
    @JsonProperty("RECCREATEDBY")
    private String recCreatedBy;

  //  @JsonProperty("RECCREATEDON")
   // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   // private LocalDateTime recCreatedOn;

    @JsonProperty("RECMODIFIEDBY")
    private String recModifiedBy;

    //@JsonProperty("RECMODIFIEDON")
   // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
   // private LocalDateTime recModifiedOn;

    @JsonProperty("IDUNIDATEND")
    private int idUnidAtend;
    @JsonProperty("CANCELADO")
    private String cancelado;
    @JsonProperty("IDPEP2")
    private int idPep2;
    @JsonProperty("EXIBERESULTADOONLINE")
    private String exibeResultadoOnline;
    @JsonProperty("SENHAINTERNET")
    private String senhaInternet;
    @JsonProperty("HORAEXAME")
    private String horaExame;

    private Enum status;


    public Integer getOrdemServico() {
        return ordemServico;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "codColigada=" + codColigada +
                ", ordemServico=" + ordemServico +
                ", numeroConta='" + numeroConta + '\'' +
                ", sequencialConta=" + sequencialConta +
                ", exameLeito='" + exameLeito + '\'' +
               // ", dataExame=" + dataExame +
                ", codMedSolicitante=" + codMedSolicitante +
               // ", dataGravacao=" + dataGravacao +
                ", nomeMedicoSolic='" + nomeMedicoSolic + '\'' +
                ", tipoMedSolic='" + tipoMedSolic + '\'' +
                ", codSetor=" + codSetor +
                ", recCreatedBy='" + recCreatedBy + '\'' +
               // ", recCreatedOn=" + recCreatedOn +
                ", recModifiedBy='" + recModifiedBy + '\'' +
               // ", recModifiedOn=" + recModifiedOn +
                ", idUnidAtend=" + idUnidAtend +
                ", cancelado='" + cancelado + '\'' +
                ", idPep2=" + idPep2 +
                ", exibeResultadoOnline='" + exibeResultadoOnline + '\'' +
                ", senhaInternet='" + senhaInternet + '\'' +
                ", horaExame='" + horaExame + '\'' +
                '}';
    }
}
