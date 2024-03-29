package br.com.matheusluz1.clientes.entities;
import br.com.matheusluz1.clientes.enums.Sexo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "cadastro")
@Getter
@Setter
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sexo")
    private Sexo sexo;

    @NotNull
    @Email(message = "email invalido!")
    private String email;

    @Column(name = "naturalidade")
    private String naturalidade;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @CPF(message = "CPF invalido!")
    @Column(name = "cpf")
    private String cpf;

    @NotNull(message = "Data de nascimento deve ser informado.")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "data_edicao")
    private LocalDate dataEdicao;

}
