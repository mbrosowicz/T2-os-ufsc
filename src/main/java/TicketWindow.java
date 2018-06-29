package main.java;

public class TicketWindow extends Thread {

    private int tid;

    public TicketWindow(int tid) {
        this.tid = tid;
    }

    @Override
    public void run() {
        Simulator.getSimulator().removeCitizen();
    }
//    TODO - meter um while pra verificar se a lista ta vazia se tiver só dar um wait

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
