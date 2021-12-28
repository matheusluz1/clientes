package br.com.matheusluz1.clientes.controllers;

import br.com.matheusluz1.clientes.entities.Cadastro;
import br.com.matheusluz1.clientes.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CadastroController {

    @Autowired
    private CadastroService service;

    @PostMapping
    public ResponseEntity<Cadastro> salvarCadastro(@RequestBody @Valid Cadastro cadastro){
        Cadastro retorno = service.salvarCadastro(cadastro);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/{idCadastro}")
    public ResponseEntity<Object> buscarCadastroPorId(@PathVariable Long idCadastro){
        Optional<Cadastro> cadastro = service.buscarCadastroPorId(idCadastro);
        if (!cadastro.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro nao encontrado");
        return ResponseEntity.status(HttpStatus.OK).body(cadastro.get());
    }

    @DeleteMapping("/{idCadastro}")
    public ResponseEntity<Object> deletarCadastro(@PathVariable Long idCadastro){
        Optional<Cadastro> cadastro = service.buscarCadastroPorId(idCadastro);
        if (!cadastro.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro nao encontrado");
        service.deletarCadastro(cadastro.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cadastro deletado com sucesso!");
    }

    @PutMapping("/{idCadastro}")
    public ResponseEntity<Object> salvarCadastro( @PathVariable Long idCadastro, @RequestBody @Valid Cadastro cadastroAEditar){
        Optional<Cadastro> cadastroBase = service.buscarCadastroPorId(idCadastro);
        if (!cadastroBase.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro nao encontrado");
        Cadastro retorno = service.editarCadastros(cadastroBase.get(), cadastroAEditar);
        return ResponseEntity.ok(retorno);
    }
}




