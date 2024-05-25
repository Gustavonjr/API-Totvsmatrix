package com.integracao.totvsmatrix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;



@Entity
@Table(name = "ExamesDoPedido")
public class ExameDoPedido {

    @Id
    @JsonProperty("SEQEXAME")
    private Integer SEQEXAME;

    @JsonProperty("ORDEMSERVICO")
    private Integer ordemservico;


    @JsonProperty("CODEXAME")
    private int Codexame;

    @JsonProperty("DESCEXAME")
    private String Descexame;

    public int getOrdemservico() {
        return ordemservico;
    }


    @Override
    public String toString() {
        return "ExameDoPedido{" +
                "SEQEXAME=" + SEQEXAME +
                ", Ordemservico=" + ordemservico +
                ", Codexame=" + Codexame +
                ", Descexame='" + Descexame + '\'' +

                '}';
    }
}
