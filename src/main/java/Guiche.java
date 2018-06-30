package main.java;

public class Guiche extends Thread {
    GeradorCidadao geradorCidadao;

    Guiche(GeradorCidadao p) {
        geradorCidadao = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                geradorCidadao.removeDaFila();
                sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        GeradorCidadao geradorCidadao = new GeradorCidadao();
        geradorCidadao.start();
        new Guiche(geradorCidadao).start();
    }
}

