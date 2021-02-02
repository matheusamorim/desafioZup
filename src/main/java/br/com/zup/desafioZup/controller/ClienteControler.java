package br.com.zup.desafioZup.controller;

import br.com.zup.desafioZup.interfaces.ClienteInterface;
import br.com.zup.desafioZup.model.Cliente;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/cadastro")
public class ClienteControler {
    @Autowired
    private ClienteInterface clienteInterface;

    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteInterface.findAll();

    }

/*
*  INSERT INTO CLIENTE VALUES(1, 'eMAIL', 'NOME')
*
* */

}
