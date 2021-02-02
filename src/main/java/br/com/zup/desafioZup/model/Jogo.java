package br.com.zup.desafioZup.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "jogo")
public class Jogo {
    @Id
    @GeneratedValue
    private int id;
    private  int jogos;

    @ManyToMany
    @JoinTable(name = "cliente_jogos",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "jogos_id")
    )
    private Set<Cliente> clientes = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

}
