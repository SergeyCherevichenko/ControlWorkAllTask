package ru.cherevichenkosn_animalsregisry.model.animalsclases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Pets extends Animals implements Serializable {
    private static   int petsIdCounter = 0;
    private int petsId;
    private ArrayList<Pets> allPets = new ArrayList<>();

    public Pets(String type, String name, LocalDate birthDay) {
        super(type, name, birthDay);
        this.petsId = ++petsIdCounter;
        this.allPets.add(this);
    }

    @Override
    public void command(String command) {
        ArrayList<String> petCommand = getCommandsPets();
        petCommand.add(command);
    }

    public int getPetsId() {
        return petsId;
    }

    public static void setPetsIdCounter(int petsIdCounter) {
        Pets.petsIdCounter = petsIdCounter;
    }

    public static int getPetsIdCounter() {
        return petsIdCounter;
    }

    public void setPetsId(int petsId) {
        this.petsId = petsId;
    }
}

