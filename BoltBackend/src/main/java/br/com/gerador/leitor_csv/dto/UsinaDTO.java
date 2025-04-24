package br.com.gerador.leitor_csv.dto;


public record UsinaDTO(
        String nomeEmpreendimento,
        Double potenciaOrtorgadaMW,
        String uf,
        String modeloUsina
) {}
