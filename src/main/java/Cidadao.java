package main.java;

public class Cidadao extends Thread {

    private Thread t;
    private String nome;

    public Cidadao(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, nome);
            t.start();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cidadao{nome='" + nome + '\'' + '}';
    }
}
