package br.com.transacoes.config.kafka;

import br.com.transacoes.model.Transacao;
import br.com.transacoes.model.request.TransacaoRequest;
import br.com.transacoes.repository.TransacaoRepository;
import br.com.transacoes.service.SalvaTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private SalvaTransacaoService salvaTransacao;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoRequest eventoDeTransacao) {
        salvaTransacao.SalvaEvento(eventoDeTransacao);
        System.out.println(eventoDeTransacao.getCartao());
    }
}
