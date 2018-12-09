package br.com.bonus.lfa.bonuslfa.logica;

import br.com.bonus.lfa.bonuslfa.dominio.Gramatica;
import br.com.bonus.lfa.bonuslfa.dominio.Producao;

import java.util.HashSet;
import java.util.Set;

public class Normalizacao {

    private Gramatica gramatica;

    public Normalizacao(Gramatica gramatica) {
        this.gramatica = gramatica;
    }

    public Gramatica producoesVazias() {

        /**
         * achar qual leva aos vazios
         */
        Set<String> contemVazio = new HashSet<String>();
        for(Producao producao : this.gramatica.getProducoes()) {
            if(producao.getProducao().length()==0) {
                contemVazio.add(producao.getVariavel());
            }
        }

        if(!contemVazio.isEmpty()) {

            for(String vazio : contemVazio) {
                for(Producao producao : this.gramatica.getProducoes()) {
                    if(producao.getProducao().contains(vazio)) {
                        contemVazio.add(producao.getVariavel());
                    }
                }
            }
        }

        /**
         * acrescentar vazio
         */





        return null;
    }
}
