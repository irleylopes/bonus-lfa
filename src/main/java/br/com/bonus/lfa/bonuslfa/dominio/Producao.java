package br.com.bonus.lfa.bonuslfa.dominio;

public class Producao {

    private String variavel;

    private String producao;

    public Producao() {
    }

    public Producao(String variavel, String producao) {
        this.variavel = variavel;
        this.producao = producao;
    }

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }

    public String getProducao() {
        return producao;
    }

    public void setProducao(String producao) {
        this.producao = producao;
    }

    @Override
    public String toString() {
        return "Producao{" +
                "variavel='" + variavel + '\'' +
                ", producao='" + producao + '\'' +
                '}';
    }
}
