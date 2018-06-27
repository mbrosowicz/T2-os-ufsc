package main.java;

import java.util.*;

public class Simulator {

    private static int nThreads0P;
    private static int nThreads1P;
    private static int nThreads2P;
    private static Simulator simulator;
    private Random rand;

    public Simulator() {
        nThreads0P = 0;
        nThreads1P = 0;
        nThreads2P = 0;
        rand = new Random();
    }

    public void generateThreads(int threadNumber) {
        Citizen[] citizens = new Citizen[threadNumber];
        for (int i = 0; i < citizens.length; i++) {
            citizens[i] = new Citizen(generateRandom());
            citizens[i].start();
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


}
