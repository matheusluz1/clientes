package br.com.matheusluz1.clientes.repositories;

import br.com.matheusluz1.clientes.entities.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
