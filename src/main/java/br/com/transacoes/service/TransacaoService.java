package br.com.transacoes.service;

import br.com.transacoes.model.Cartao;
import br.com.transacoes.model.Transacao;
import br.com.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> recuperaTransacaoPorCartao(Cartao cartao) {
        List<Transacao> transacaoRecuperada = transacaoRepository.findAllByCartaoCodigo(cartao.getId());
        if(transacaoRecuperada.isEmpty()) return null;
        return transacaoRecuperada;
    }
}
