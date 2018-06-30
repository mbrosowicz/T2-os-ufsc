package main.java;

import java.util.ArrayList;
import java.util.List;

public class Prioridade {
    private int prioridade;
    private List<Cidadao> listaCidadao;

    public Prioridade(int prioridade) {
        this.prioridade = prioridade;
        this.listaCidadao = new ArrayList<>();
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public List<Cidadao> getListaCidadao() {
        return listaCidadao;
    }

    public void setListaCidadao(List<Cidadao> listaCidadao) {
        this.listaCidadao = listaCidadao;
    }

    @Override
    public String toString() {
        return "Prioridade{" +
                "prioridade=" + prioridade +
                ", listaCidadao=" + listaCidadao +
                '}';
    }
}
