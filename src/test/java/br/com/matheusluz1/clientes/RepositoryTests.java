package br.com.matheusluz1.clientes;

import br.com.matheusluz1.clientes.controllers.CadastroController;
import br.com.matheusluz1.clientes.entities.Cadastro;
import br.com.matheusluz1.clientes.repositories.CadastroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false )
@WebMvcTest(CadastroController.class)
public class RepositoryTests {

    @Autowired
    private CadastroRepository repository;

    @Test
    public void Test_CriarCadastro() {
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Matheus");
        cadastro.setEmail("matheus@gmail.com");
        repository.save(cadastro);
        assertThat(cadastro.getId()).isGreaterThan(0);
    }

    @Test
    public void Test_DeletarCadastro() {
        Cadastro cadastro = repository.findById(1L).get();
        repository.deleteById(cadastro.getId());
    }

    @Test
    public void Test_AtualizarCadastro() {
        Cadastro cadastro = repository.findById(1L).get();
        cadastro.setNome("Matheus Luz");
        repository.save(cadastro);
    }


    @Test
    public  void Test_ListarTodos() {
        Iterable<Cadastro> listaCadastro = repository.findAll();
        listaCadastro.forEach(System.out::println);
    }
}