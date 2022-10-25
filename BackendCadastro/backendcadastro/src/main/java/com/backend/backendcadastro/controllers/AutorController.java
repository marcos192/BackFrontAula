package com.backend.backendcadastro.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backend.backendcadastro.modelos.Autor;
import com.backend.backendcadastro.rdn.AutorRdn;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AutorController 
{
    @GetMapping("/autores")
    public List<Autor> Get() 
    {
        AutorRdn rdn = new AutorRdn();
        return rdn.obterTodos();

    }

    @GetMapping("/autores/{id}")
    public Autor GetById(@PathVariable("id") int id) 
    {
        AutorRdn rdn = new AutorRdn();
        return rdn.obterPorId(id);
    }

    @PostMapping("/autores")
    public int Post(@RequestBody Autor palun) throws SQLException 
    {
        AutorRdn rdn = new AutorRdn();
        return rdn.Inserir(palun);

    }

    @PutMapping("/autores/{id}")
    public int Put(@PathVariable(value = "id") int id, @RequestBody Autor pAutor) 
    {
        AutorRdn rdn = new AutorRdn();
        if (rdn.obterPorId(id).getIdAutor() > 0) 
        {
            return rdn.alterar(pAutor);
        } 
        
        else 
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado");
        }
    }

    @DeleteMapping("/autores/{IdAutor}")
    public int Delete(@PathVariable(value = "IdAutor") int idAutor) {

        AutorRdn rdn = new AutorRdn();
        if (rdn.obterPorId(idAutor).getIdAutor() > 0) 
        {
            return rdn.deletar(idAutor);
        } 
        
        else 
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado");
        }
    }
}
