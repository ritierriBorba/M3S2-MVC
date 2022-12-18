package br.com.futurodev.elaboracaosecurity.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {
    private String nome;
    private String raça;
    private Tutor tutor;
    private Integer id;
}
