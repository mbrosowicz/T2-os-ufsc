package main.java;

import java.util.Scanner;

public class Guiche extends Thread {
    static GeradorCidadao geradorCidadao;
    static Scanner sc = new Scanner(System.in);


    Guiche(GeradorCidadao p) {
        geradorCidadao = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(getName() + " Está removendo");
                sleep(5000);
                geradorCidadao.removeDaFila();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println("Digite o número de guichês desejado: ");
        int nThread = sc.nextInt();
        geradorCidadao = new GeradorCidadao();
        geradorCidadao.start();
        geradorCidadao.generateGuiches(nThread, geradorCidadao);
    }
}

