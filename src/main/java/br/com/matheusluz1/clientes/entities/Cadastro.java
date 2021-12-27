package br.com.matheusluz1.clientes.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//(name = ) desnecessário table com o mesmo nome da entity não precisa
@Entity
@Table(name = "cadastro")
@Getter
@Setter
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    private String email;
}
