package main.java;

public class CitizenCreator implements Runnable {

    private static CitizenCreator citizenCreator;

    @Override
    public void run() {
        Simulator.getSimulator().startCitizen();
    }

    public static CitizenCreator getCitizenCreator() {
        if (citizenCreator == null) {
            citizenCreator = new CitizenCreator();
        }
        return citizenCreator;
    }

    public static void setCitizenCreator(CitizenCreator citizenCreator) {
        CitizenCreator.citizenCreator = citizenCreator;
    }


}
