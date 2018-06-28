package main.java;

public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    SaveKristo PD;

    ThreadDemo(String name, SaveKristo pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        PD.printCount();
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
