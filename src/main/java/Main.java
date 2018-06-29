package main.java;

import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(30);
        stpe.scheduleAtFixedRate(new CitizenCreator(), 0, 1, TimeUnit.SECONDS);
        System.out.println("Digite um número: ");
        int nThreads = scanner.nextInt();
//        Simulator.getSimulator().generateThreads(nThreads);
        if (nThreads == 1) {
            Simulator.getSimulator().generateThreads(2);
        }
    }

}
