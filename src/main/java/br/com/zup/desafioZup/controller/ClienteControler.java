package br.com.zup.desafioZup.controller;
import br.com.zup.desafioZup.interfaces.ClienteInterface;
import br.com.zup.desafioZup.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/jogo")
public class ClienteControler {
    @Autowired
    private ClienteInterface clienteInterface;
    @GetMapping
    public ResponseEntity<?> listarTodos() {
        List<Cliente> cliente = clienteInterface.findAll();
        return !cliente.isEmpty() ? ResponseEntity.ok(cliente) : ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente, HttpServletResponse response) {
        Cliente clienteSalvar = clienteInterface.save(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(clienteSalvar.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(clienteSalvar);
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return clienteInterface.findById(id).orElse(null);
    }

}



