package ru.cherevichenkosn_animalsregisry.model.animalsregistres;

import ru.cherevichenkosn_animalsregisry.model.animalsclases.PackAnimals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PackAnimalRegistry implements Serializable {
    private List<PackAnimals> allPackAnimals;

    public PackAnimalRegistry() {
        this.allPackAnimals = new ArrayList<>();
    }
    public  void addPackFnimals(PackAnimals packAnimals){
        allPackAnimals.add(packAnimals);
    }

    public List<PackAnimals> getAllPackAnimals() {
        return allPackAnimals;
    }

    public void setAllPackAnimals(List<PackAnimals> allPackAnimals) {
        this.allPackAnimals = allPackAnimals;
    }
}
