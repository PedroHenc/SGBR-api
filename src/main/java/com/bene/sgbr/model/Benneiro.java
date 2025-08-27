package com.bene.sgbr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
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
