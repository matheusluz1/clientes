package br.com.matheusluz1.clientes.services;

import br.com.matheusluz1.clientes.entities.Cadastro;
import br.com.matheusluz1.clientes.repositories.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;


    public Cadastro salvarCadastro(Cadastro cadastro) {
        return repository.save(cadastro);
    }
}


