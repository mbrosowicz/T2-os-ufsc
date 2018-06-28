package main.java;

public class Citizen extends Thread {

    private String tid;

    public Citizen(String tid) {
        this.tid = tid;
    }

    @Override
    public void run() {

    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "tid='" + tid + '\'' +
                '}';
    }
}
