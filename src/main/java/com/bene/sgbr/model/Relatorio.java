package com.bene.sgbr.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "relatorios")
public class Relatorio implements Serializable {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "EditedBy")
    private String EditedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "CPF")
    private String cpf;

    private String categoria;

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
