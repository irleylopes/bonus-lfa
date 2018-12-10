package br.com.bonus.lfa.bonuslfa.dominio;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producao producao1 = (Producao) o;
        return Objects.equals(variavel, producao1.variavel) &&
                Objects.equals(producao, producao1.producao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variavel, producao);
    }

    @Override
    public String toString() {
        return "Producao{" +
                "variavel='" + variavel + '\'' +
                ", producao='" + producao + '\'' +
                '}';
    }
}
