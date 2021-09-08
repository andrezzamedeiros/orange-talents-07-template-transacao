package br.com.transacoes.repository;

import br.com.transacoes.model.Cartao;
import br.com.transacoes.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findAllByCartaoCodigo(String id);

    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String id);
}
