package ru.cherevichenkosn_animalsregisry.model.animalsclases;

import java.time.LocalDate;
import java.util.ArrayList;

public class PackAnimals extends Animals {

        private static int packAnimalsIdCounter = 0;
        private int packAnimalsId;

        private ArrayList<PackAnimals> allPackAnimals = new ArrayList<>();

        public PackAnimals(String type, String name, LocalDate birthDay) {
            super(type, name, birthDay);
            this.packAnimalsId = ++packAnimalsIdCounter;

        }

        @Override
        public void command(String command) {
            ArrayList<String> petCommand = getCommandsPets();
            petCommand.add(command);
        }

    public int getPackAnimalsId() {
        return packAnimalsId;
    }

    public static int getPackAnimalsIdCounter() {
        return packAnimalsIdCounter;
    }

    public static void setPackAnimalsIdCounter(int packAnimalsIdCounter) {
        PackAnimals.packAnimalsIdCounter = packAnimalsIdCounter;
    }

    public void setPackAnimalsId(int packAnimalsId) {
        this.packAnimalsId = packAnimalsId;
    }
}


