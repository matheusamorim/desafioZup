package br.com.zup.desafioZup.interfaces;

import br.com.zup.desafioZup.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteInterface extends JpaRepository<Cliente, Long> {

}
