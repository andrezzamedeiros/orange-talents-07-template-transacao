package br.com.transacoes.service;

import br.com.transacoes.model.Transacao;
import br.com.transacoes.model.request.TransacaoRequest;
import br.com.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvaTransacaoService {
    @Autowired
    private TransacaoRepository transacaoRespository;
    @Autowired
    private CartaoService cartaoService;
    @Autowired
    private EstabelecimentoService estabelecimentoService;

    public void SalvaEvento(TransacaoRequest transacaoRequest) {
        Transacao transacaoModel = transacaoRequest.toModel();

        cartaoService.cartaoExiste(transacaoModel.getCartao());

        estabelecimentoService.cartaoExiste(transacaoModel.getEstabelecimento());

        transacaoRespository.save(transacaoModel);
    }
}

