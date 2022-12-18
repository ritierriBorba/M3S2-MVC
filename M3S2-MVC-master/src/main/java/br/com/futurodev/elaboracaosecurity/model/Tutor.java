package br.com.futurodev.elaboracaosecurity.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tutor {
    private String nome;
    private Integer id;
    private Pet pet;
    private Integer idade;
}
