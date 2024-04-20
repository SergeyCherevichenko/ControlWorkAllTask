package ru.cherevichenkosn_animalsregisry.model.animalsbulders;

import ru.cherevichenkosn_animalsregisry.model.animalsclases.Pets;

import java.io.Serializable;
import java.time.LocalDate;

public class PetsAnimalBuilder implements Serializable {
    public Pets petsBuilder(String type, String name, LocalDate birthDay){
        Pets pets  = new Pets(type,name,birthDay);
        return pets;
    }
}
