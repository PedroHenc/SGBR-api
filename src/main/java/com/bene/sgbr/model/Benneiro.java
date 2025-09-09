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
public class Benneiro implements Serializable {

    @Id
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CARGO")
    private String cargo;

    private Boolean Ativo;

    @Column(columnDefinition = "text", name = "FOTO_PERFIL")
    private String fotoPerfil;

    @OneToMany(mappedBy = "benneiro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Relatorio> relatorios;
}
