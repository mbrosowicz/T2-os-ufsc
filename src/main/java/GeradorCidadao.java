package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

class GeradorCidadao extends Thread {

    private List<Prioridade> fila = new ArrayList<>();
    private Prioridade p0;
    private Prioridade p1;
    private Prioridade p2;

    private Random rand;
    private static int nThreads0P;
    private static int nThreads1P;
    private static int nThreads2P;

    private Vector messages = new Vector();

    public GeradorCidadao() {
        rand = new Random();
    }

    public synchronized void generateGuiches(int nThread, GeradorCidadao geradorCidadao) {
        Guiche[] guiches = new Guiche[nThread];
        for (int i = 0; i < guiches.length; i++) {
            guiches[i] = new Guiche(geradorCidadao);
            guiches[i].start();
        }
    }

    @Override
    public void run() {
        fila.add(p0 = new Prioridade(0));
        fila.add(p1 = new Prioridade(1));
        fila.add(p2 = new Prioridade(2));
        try {
            while (true) {
                criaCidadao();
                sleep(500);
            }
        } catch (InterruptedException e) {
        }
    }

    private String generateRandom() {
        int id = rand.nextInt(3);
        String tid = id + "P";
        switch (id) {
            case 0:
                nThreads0P++;
                tid += nThreads0P;
                break;
            case 1:
                nThreads1P++;
                tid += nThreads1P;
                break;
            case 2:
                nThreads2P++;
                tid += nThreads2P;
                break;
        }
        return tid;
    }

    private synchronized void criaCidadao() throws InterruptedException {
        while (fila.get(0).getListaCidadao().size() == 10 || fila.get(1).getListaCidadao().size() == 10 || fila.get(2).getListaCidadao().size() == 10) {
            wait();
        }
        Cidadao cidadao = new Cidadao(generateRandom());
        System.out.println("Cidadao: " + cidadao.getNome());

        cidadao.start();
        if (cidadao.getNome().contains("0P")) {
            p0.getListaCidadao().add(cidadao);

        } else if (cidadao.getNome().contains("1P")) {
            p1.getListaCidadao().add(cidadao);

        } else if (cidadao.getNome().contains("2P")) {
            p2.getListaCidadao().add(cidadao);
        }
        notify();
    }

    public synchronized boolean verificaFilaVazia() {
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).getListaCidadao().size() >= 1) {
                return false;
            }
        }
        return true;
    }

    public synchronized void removeDaFila() throws InterruptedException {
        notify();
        while (verificaFilaVazia()) {
            wait();
        }
        int count = 0;
        for (int i = 0; i < fila.size(); i++) {
            for (int j = 0; j < fila.get(i).getListaCidadao().size(); ) {
                if (count == 3 && i != 2) {
                    if (!fila.get(i + 1).getListaCidadao().isEmpty()) {
                        System.out.println("Mais velho ---> " + fila.get(i + 1).getListaCidadao().get(0));
                        fila.get(i + 1).getListaCidadao().get(0).setNome(fila.get(i + 1).getListaCidadao().get(0).getNome() + "V");
                        fila.get(i).getListaCidadao().add(fila.get(i + 1).getListaCidadao().get(0));
                        fila.get(i + 1).getListaCidadao().remove(0);
                    }
                }
                System.out.println("Removendo ---> " + fila.get(i).getListaCidadao().get(j));
                fila.get(i).getListaCidadao().remove(j);
                count++;
            }
            count = 0;
        }
    }

}
