package ru.cherevichenkosn_animalsregisry.model.animalsclases;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Animals implements Serializable {
    private String name;
    private String type;
    private LocalDate birthDay;

    private ArrayList<String> commandsPets;
    protected static int idCounter = 0;
    private int id;

    public Animals(String type, String name, LocalDate birthDay) {
        this.id = ++idCounter;
        this.type = type;
        this.name = name;
        this.birthDay = birthDay;
        commandsPets = new ArrayList<>();

    }


    public abstract void command(String command);

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getCommandsPets() {
        return commandsPets;
    }

    public void setCommandsPets(String command) {
        commandsPets.add(command);
    }




}
