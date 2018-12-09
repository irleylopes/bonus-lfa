package br.com.bonus.lfa.bonuslfa.logica;

import br.com.bonus.lfa.bonuslfa.dominio.Gramatica;
import br.com.bonus.lfa.bonuslfa.dominio.Producao;

import java.util.*;

public class Normalizacao {

    private Gramatica gramatica;

    public Normalizacao(Gramatica gramatica) {
        this.gramatica = gramatica;
    }

    public void producoesVazias() {

        /**
         * achar quais variaveis tem vazio e excluila a produção vazia
         */
        Set<String> contemVazio = new HashSet<>();
        Set<Integer> listaVazios = new HashSet<Integer>();

        for(int i = 0; i < this.gramatica.getProducoes().size(); i++) {
            if(this.gramatica.getProducoes().get(i).getProducao().length()==0) {
                contemVazio.add(this.gramatica.getProducoes().get(i).getVariavel());
                listaVazios.add(i);
                this.gramatica.getProducoes().remove(i);
            }

        }

        /**
         * achar quais variaveis podem chegar ao vazio indiretamente
         */
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
         * acrescentar novas produções que substituem o vazio
         */
        Set<Producao> producoes = new HashSet<Producao>();
        if(!contemVazio.isEmpty()) {

            for(String variavel : contemVazio) {
                for(Producao producao : this.gramatica.getProducoes()) {
                    producoes.add(producao);
                    if(producao.getProducao().contains(variavel)) {
                        String NovaProducao = producao.getProducao().replace(variavel,"");
                        if(NovaProducao.length()>0) {
                            producoes.add(new Producao(producao.getVariavel(), NovaProducao));
                        }
                    }
                }
            }
        }

        List<Producao> producoeList = new ArrayList<>();
        producoeList.addAll(producoes);

        Collections.sort(producoeList, new Comparator<Producao>() {
            @Override
            public int compare(Producao o1, Producao o2) {
                return o1.getVariavel().compareTo(o2.getVariavel());
            }
        });
        this.gramatica.setProducoes(producoeList);
    }
//
//    public void producoesUnitarias() {
//        /**
//         * procura quais producoes tem uma variavel unitaria
//         */
//        List<Producao> prod = new ArrayList<>();
//        for(String variavel : this.gramatica.getVariaveis()) {
//            for (Producao producao : this.gramatica.getProducoes()) {
//                if (producao.getProducao().length() == 1 && producao.getProducao().contains(variavel)) {
//                    prod.add(producao);
//                }
//            }
//        }
//
//        /**
//         * removendo producoes que tem uma variavel unitaria
//         */
//        for(Producao p : prod) {
//            this.gramatica.getProducoes().remove(p);
//        }
//        for(Producao p : prod) {
//            List<Producao> novasProducoes = this.gramatica.getProducoes(p.getProducao());
//            for(Producao nova : novasProducoes) {
//                this.gramatica.getProducoes().add(new Producao(p.getVariavel(),nova.getProducao()));
//            }
//
//        }
//    }
//
//


}
