package main.java;

import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Simulator.getSimulator().generateThreads(6);
        ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(30);
        stpe.scheduleAtFixedRate(new CitizenCreator(), 0, 4, TimeUnit.SECONDS);
//        System.out.println("Digite um número: ");
//        int nThreads = scanner.nextInt();
//        Simulator.getSimulator().generateThreads(nThreads);
    }

}
