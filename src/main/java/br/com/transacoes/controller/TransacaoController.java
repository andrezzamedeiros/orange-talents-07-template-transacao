package br.com.transacoes.controller;

import br.com.transacoes.model.Cartao;
import br.com.transacoes.model.Transacao;
import br.com.transacoes.model.request.TransacaoRequest;
import br.com.transacoes.repository.CartaoRepository;
import br.com.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository repository;

    @Autowired
    CartaoRepository cartaoRepository;

    @GetMapping("/{id}")
    ResponseEntity<?> buscaUltimasTransacoes (@PathVariable String id){
        Optional<Cartao> cartao = cartaoRepository.findCartaoById(id);
        if(!cartao.isPresent()){
            return ResponseEntity.notFound().build();
        }

        List<Transacao> transacoes = repository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(cartao.get().getId());
        return ResponseEntity.ok().body(transacoes);
    }
}
