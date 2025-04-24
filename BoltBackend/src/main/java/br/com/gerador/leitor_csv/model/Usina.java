package br.com.gerador.leitor_csv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeEmpreendimento;
    @Column
    private String cnpjEmpresa;
    @Column
    private String uf;
    @Column
    private Double potenciaOrtorgadaKm;
    @Column
    private String fonteCombustivel;
    @Column
    private String modeloUsina;
}
