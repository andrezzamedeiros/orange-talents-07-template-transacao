package br.com.transacoes.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String codigo;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    private LocalDateTime efetivadaEm;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cartao_codigo")
    private Cartao cartao;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "estabelecimento_codigo")
    private Estabelecimento estabelecimento;

    public Transacao() {

    }

    public Transacao(String codigo, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
                     LocalDateTime efetivadaEm) {
        this.codigo = codigo;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
    }


    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }


}
