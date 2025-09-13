package com.bene.sgbr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "benneiro")
public class Benneiro implements Serializable {

    @Id
    @SequenceGenerator(name = "seqBenneiro", sequenceName = "seq_tb_benneiro", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBenneiro")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cargo", length = 100)
    private String cargo;

    @Column(name = "ativo")
    private Boolean ativo = true;

    @Column(name = "foto_perfil", columnDefinition = "TEXT")
    private String fotoPerfil;

    @OneToMany(mappedBy = "benneiro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Relatorio> relatorios;
}
