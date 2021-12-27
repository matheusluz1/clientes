package br.com.matheusluz1.clientes.controllers;

import br.com.matheusluz1.clientes.entities.Cadastro;
import br.com.matheusluz1.clientes.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cadastros")
public class CadastroController {

    @Autowired
    private CadastroService service;


    @PostMapping
    public ResponseEntity<Cadastro> salvarCadastro(@RequestBody @Valid Cadastro cadastro){
        Cadastro retorno = service.salvarCadastro(cadastro);
        return ResponseEntity.ok(retorno);


        }
    }




