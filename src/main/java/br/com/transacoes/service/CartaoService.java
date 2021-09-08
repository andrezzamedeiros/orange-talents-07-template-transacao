package br.com.transacoes.service;

import br.com.transacoes.model.Cartao;
import br.com.transacoes.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao validaCartao(String numeroCartao) {
        Optional<Cartao> cartao = cartaoRepository.findCartaoById(numeroCartao);
        if (cartao.isEmpty())
            return null;
        return cartao.get();
    }

    public Cartao cartaoExiste(Cartao cartao) {
        Optional<Cartao> cartaoRecuperado = cartaoRepository.findCartaoById(cartao.getId());
        if (cartaoRecuperado.isEmpty()) {
            return cartaoRepository.save(cartao);
        }
        return cartaoRecuperado.get();

    }

}
