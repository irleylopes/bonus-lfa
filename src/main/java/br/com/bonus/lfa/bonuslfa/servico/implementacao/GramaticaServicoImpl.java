package br.com.bonus.lfa.bonuslfa.servico.implementacao;

import br.com.bonus.lfa.bonuslfa.dominio.Gramatica;
import br.com.bonus.lfa.bonuslfa.logica.Chomsky;
import br.com.bonus.lfa.bonuslfa.logica.Normalizacao;
import br.com.bonus.lfa.bonuslfa.servico.interfaceService.GramaticaServico;
import org.springframework.stereotype.Service;

@Service
public class GramaticaServicoImpl implements GramaticaServico {

    private Normalizacao normalizacao;
    private Chomsky chomsky;

    @Override
    public Gramatica normalizacao(Gramatica gramatica) {
        normalizacao = new Normalizacao(gramatica);
        normalizacao.producoesVazias();
        normalizacao.producoesUnitarias();
        normalizacao.variaveisInuteis();
        return gramatica;
    }

    @Override
    public Gramatica chomsky(Gramatica gramatica) {
        chomsky = new Chomsky(gramatica);
        chomsky.primeiraNorma();
        return gramatica;
    }
}
