package com.bene.sgbr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
}
