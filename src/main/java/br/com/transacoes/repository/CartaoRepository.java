package br.com.transacoes.repository;

import br.com.transacoes.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {


    Optional<Cartao> findCartaoById(String numeroCartao);
}
