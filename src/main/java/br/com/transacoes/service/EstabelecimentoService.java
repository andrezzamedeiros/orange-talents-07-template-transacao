package br.com.transacoes.service;

import br.com.transacoes.model.Estabelecimento;
import br.com.transacoes.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EstabelecimentoService {
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public Estabelecimento cartaoExiste(Estabelecimento estabelecimento) {
        Optional<Estabelecimento> estabelecimento2 = estabelecimentoRepository
                .findEstabelecimentoByNome(estabelecimento.getNome());
        if (estabelecimento2.isEmpty()) {
            return estabelecimentoRepository.save(estabelecimento);
        }
        return estabelecimento2.get();

    }
}
