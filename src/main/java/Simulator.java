package main.java;

import java.util.*;

public class Simulator {

    private static int nThreads0P;
    private static int nThreads1P;
    private static int nThreads2P;
    private static Simulator simulator;
    private Random rand;
    private TicketWindow[] ticketWindows;
    private List<Prioridade> fila;
    private Prioridade p0;
    private Prioridade p1;
    private Prioridade p2;

    public Simulator() {
        nThreads0P = 0;
        nThreads1P = 0;
        nThreads2P = 0;
        rand = new Random();
        fila = new ArrayList<>();
        fila.add(p0 = new Prioridade(0));
        fila.add(p1 = new Prioridade(1));
        fila.add(p2 = new Prioridade(2));
    }

    public void generateThreads(int threadNumber) {
        ticketWindows = new TicketWindow[threadNumber];
        for (int i = 0; i < ticketWindows.length; i++) {
            ticketWindows[i] = new TicketWindow(i);
            ticketWindows[i].start();
        }
    }

    public String generateRandom() {
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

    public static Simulator getSimulator() {
        if (simulator == null) {
            simulator = new Simulator();
        }
        return simulator;
    }

    public static void setSimulator(Simulator Simulator) {
        Simulator.simulator = Simulator;
    }

    public List<Prioridade> getFila() {
        return fila;
    }

    public void startCitizen() {
        Citizen citizen = new Citizen(generateRandom());
        citizen.start();
    }

    public synchronized void entraFila(Citizen citizen) {
        if (citizen.getTid().contains("0P")) {
            p0.getCitizens().add(citizen);

        } else if (citizen.getTid().contains("1P")) {
            p1.getCitizens().add(citizen);

        } else if (citizen.getTid().contains("2P")) {
            p2.getCitizens().add(citizen);
        }
    }

    public synchronized void removeCitizen() {
   /*     for (int i = 0; i < fila.get(0).getCitizens().size(); i++) {
            System.out.println("Citizen removido -> " + fila.get(0).getCitizens().get(i).getTid());
            if (i == 3) {
                fila.get(i + 1).getCitizens().add(fila.get(1).getCitizens().get(0));
            }
            fila.get(0).getCitizens().remove(i);
        }*/
        int count = 0;
        for (int i = 0; i < fila.size(); i++) {
            System.out.println("lista de prioridades" + fila.get(i));
            for (int j = 0; j < fila.get(i).getCitizens().size(); j++) {
                System.out.println(fila.get(i).getCitizens().get(j));
//                count++;
//                if (j == count) {
//                    fila.get(i + 1).getCitizens().add(fila.get(1).getCitizens().get(0));
//                    count = 0;
//                }
//                System.out.println("Removido-> " + fila.get(i).getCitizens().get(i));
//                fila.get(i).getCitizens().remove(i);
            }
        }
    }

}
