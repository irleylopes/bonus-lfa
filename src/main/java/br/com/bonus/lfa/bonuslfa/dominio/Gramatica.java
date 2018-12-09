package br.com.bonus.lfa.bonuslfa.dominio;

import java.util.ArrayList;
import java.util.List;

public class Gramatica {

    private List<String> variaveis;
    private List<String> terminais;
    private List<Producao> producoes;
    private String start;

    public Gramatica() {
    }

    public Gramatica(List<String> variaveis, List<String> terminais, List<Producao> producoes, String start) {
        this.variaveis = variaveis;
        this.terminais = terminais;
        this.producoes = producoes;
        this.start = start;
    }

    public List<String> getVariaveis() {
        return variaveis;
    }

    public void setVariaveis(List<String> variaveis) {
        this.variaveis = variaveis;
    }

    public List<String> getTerminais() {
        return terminais;
    }

    public void setTerminais(List<String> terminais) {
        this.terminais = terminais;
    }

    public List<Producao> getProducoes() {
        return producoes;
    }

//    public List<Producao> getProducoes(String variavel) {
//        List<Producao> producaoList = new ArrayList<>();
//        for(Producao p : this.producoes) {
//            if(p.getVariavel().contains(variavel)) {
//                producaoList.add(p);
//            }
//        }
//        return producaoList;
//    }

    public void setProducoes(List<Producao> producoes) {
        this.producoes = producoes;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Gramatica{" +
                "variaveis=" + variaveis +
                ", terminais=" + terminais +
                ", producoes=" + producoes +
                ", start='" + start + '\'' +
                '}';
    }
}
