package com.bene.sgbr.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Benneiro implements Serializable {

    @Id
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CARGO")
    private String cargo;

    private Boolean Ativo;

    @OneToMany(mappedBy = "beneiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relatorio> relatorios;
}
