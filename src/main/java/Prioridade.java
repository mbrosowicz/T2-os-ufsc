package main.java;

import java.util.ArrayList;
import java.util.List;

public class Prioridade {
    private int prioridade;
    private List<Citizen> citizens;

    public Prioridade(int prioridade) {
        this.prioridade = prioridade;
        this.citizens = new ArrayList<>();
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return "Prioridade{" +
                "prioridade=" + prioridade +
                '}';
    }
}
