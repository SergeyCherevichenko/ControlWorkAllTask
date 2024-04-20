package ru.cherevichenkosn_animalsregisry.model.animalsregistres;

import ru.cherevichenkosn_animalsregisry.model.animalsclases.Pets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PetsRegistry implements Serializable {
    private List<Pets> allPets;

    public PetsRegistry() {
        this.allPets = new ArrayList<>();
    }
    public void  addPets(Pets pets){
        allPets.add(pets);
    }

    public List<Pets> getAllPets() {
        return allPets;
    }

    public void setAllPets(List<Pets> allPets) {
        this.allPets = allPets;
    }
}
