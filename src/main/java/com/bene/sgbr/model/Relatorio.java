package com.bene.sgbr.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "relatorios")
public class Relatorio implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "CPF")
    private String cpf;

    private Categoria categoria;

    @Column(name = "VEICULO")
    private String veiculo;

    @Column(name = "LUCRO")
    private String lucro;

    @Column(name = "ESCAPE")
    private String escapamento;

    @ManyToOne
    @JoinColumn(name = "beneiro_id")
    private Benneiro beneiro;
}
