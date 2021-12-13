package com.bethaCode.vendas.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "O campo nome deve ser informado.")
    private String nome;

    @Column
    private BigDecimal comissao;

    @Column
    private String genero;

    @Column(name = "created_at")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadoEm;

    @PrePersist
    public void prePersist() {
        setCriadoEm(LocalDate.now());
    }
}
