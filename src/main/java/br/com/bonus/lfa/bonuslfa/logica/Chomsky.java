package br.com.bonus.lfa.bonuslfa.logica;

import br.com.bonus.lfa.bonuslfa.dominio.Gramatica;
import br.com.bonus.lfa.bonuslfa.dominio.Producao;

import java.util.*;

public class Chomsky {

    private Gramatica gramatica;

    public Chomsky(Gramatica gramatica) {
        this.gramatica = gramatica;
    }

    public void primeiraNorma() {

        Set<Producao> novasProducoes = new HashSet<>();

        for(Producao producao : this.gramatica.getProducoes()) {

            /**
             * um terminal ok
             */
            if(producao.getProducao().length()==1) {
                novasProducoes.add(producao);
                continue;
            }

            /**
             * producao com duas variaveis
             */
            if(producao.getProducao().length()==2) {
                int cont = 0;
                String primeiroChar = String.valueOf(producao.getProducao().charAt(0));
                String segundoChar = String.valueOf(producao.getProducao().charAt(1));
                for(String caracter : this.gramatica.getVariaveis()) {
                    if(caracter.contains(primeiroChar)||caracter.equals(segundoChar)) {
                        cont++;
                    }
                }
                if(cont>2) {
                    novasProducoes.add(producao);
                    continue;
                }
            }



            /**
             * producoes com um terminal e uma variavel
             */
            if(producao.getProducao().length()==2) {
                String primeiroChar = String.valueOf(producao.getProducao().charAt(0));
                String segundoChar = String.valueOf(producao.getProducao().charAt(1));
                for(String varivel : this.gramatica.getTerminais()) {
                    if(varivel.contains(primeiroChar)) {

                        Producao novaProducao = new Producao(producao.getVariavel().concat(n()), varivel);
                        novasProducoes.add(novaProducao);
                        this.gramatica.getVariaveis().add(novaProducao.getVariavel());

                        Producao novaProd = new Producao(producao.getVariavel(),novaProducao.getVariavel().concat(segundoChar));
                        novasProducoes.add(novaProd);
                        this.gramatica.getVariaveis().add(novaProd.getVariavel());
                    }

                }
                continue;
            }

            /**
             * producoes com tres variaveis
             */
            if(producao.getProducao().length()>2) {
                String primeiroChar = String.valueOf(producao.getProducao().charAt(0));
                String segundoChar = String.valueOf(producao.getProducao().charAt(1));
                String terceiroChar = String.valueOf(producao.getProducao().charAt(2));

                for(String varivel : this.gramatica.getTerminais()) {
                    if(varivel.contains(primeiroChar)) {

                        Producao novaProducao = new Producao(producao.getVariavel().concat(n()), varivel);
                        novasProducoes.add(novaProducao);
                        this.gramatica.getVariaveis().add(novaProducao.getVariavel());

                        Producao novaProd = new Producao(producao.getVariavel(),novaProducao.getVariavel().concat(segundoChar.concat(terceiroChar)));
                        novasProducoes.add(novaProd);
                        this.gramatica.getVariaveis().add(novaProd.getVariavel());
                        continue;
                    }
                }

                Producao novaProducao = new Producao(
                        producao.getVariavel().concat(n()),
                        primeiroChar.concat(segundoChar)
                );
                novasProducoes.add(novaProducao);
                this.gramatica.getVariaveis().add(novaProducao.getVariavel());

                Producao novaProd = new Producao(producao.getVariavel(),
                        novaProducao.getVariavel().concat(terceiroChar));

                novasProducoes.add(novaProd);
                this.gramatica.getVariaveis().add(novaProd.getVariavel());

            }

        }



        List<Producao> producoeList = new ArrayList<>();
        producoeList.addAll(novasProducoes);
        this.gramatica.setProducoes(producoeList);


        Set<String> variaveis = new HashSet<>(this.gramatica.getVariaveis());
        List<String> listVariaveis = new ArrayList<>();
        listVariaveis.addAll(variaveis);
        this.gramatica.setVariaveis(listVariaveis);
        ordenarProducoes(this.gramatica.getProducoes());
    }

    private boolean terminais(List<Producao> producoes, String producao) {

        if(producao.length()==2) {
            if(producoes.contains(producao.charAt(0))) {
                if (producoes.contains(producao.charAt(1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private String n() {
        Random random = new Random();
        int numero = random.nextInt(9);
        return "P" + String.valueOf(numero);
    }

    private void ordenarProducoes(List<Producao> listaProducoes) {

        Collections.sort(listaProducoes, new Comparator<Producao>() {
            @Override
            public int compare(Producao o1, Producao o2) {
                return o1.getVariavel().compareTo(o2.getVariavel());
            }
        });
    }
}
