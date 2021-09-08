package br.com.transacoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String id;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
