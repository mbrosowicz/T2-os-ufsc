package main.java;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args)
    {
        System.out.println("Digite um número: ");
        int nThreads = scanner.nextInt();
        Simulator.getSimulator().generateThreads(nThreads);
    }

}
