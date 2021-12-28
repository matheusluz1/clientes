package br.com.matheusluz1.clientes.services;

import br.com.matheusluz1.clientes.entities.Cadastro;
import br.com.matheusluz1.clientes.repositories.CadastroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;


    public Cadastro salvarCadastro(Cadastro cadastro) {
        cadastro.setDataCadastro(LocalDate.now());
        return repository.save(cadastro);
    }

    public Optional<Cadastro> buscarCadastroPorId(Long idCadastro){
        return repository.findById(idCadastro);
    }

    public void deletarCadastro(Cadastro cadastro){
        repository.delete(cadastro);
    }

    public Cadastro editarCadastros(Cadastro cadastroBase, Cadastro cadastroAEditar) {
        cadastroBase.setNome(cadastroAEditar.getNome());
        cadastroBase.setEmail(cadastroAEditar.getEmail());
        cadastroBase.setDataNascimento(cadastroAEditar.getDataNascimento());
        cadastroBase.setCpf(cadastroAEditar.getCpf());
        cadastroBase.setDataEdicao(LocalDate.now());
        return repository.save(cadastroBase);
    }
}


