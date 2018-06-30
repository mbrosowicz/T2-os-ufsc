package main.java;

public class TicketWindow extends Thread {

    private int tid;

    public TicketWindow(int tid) {
        this.tid = tid;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (Simulator.getSimulator().filaVazia()) {
                    /*try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
            }
            Simulator.getSimulator().removeCitizen();
        }
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "tid='" + tid + '\'' +
                '}';
    }
}
