package br.com.transacoes.repository;

import br.com.transacoes.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    Optional<Estabelecimento> findEstabelecimentoByNome(String nome);
}
