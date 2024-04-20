package ru.cherevichenkosn_animalsregisry.model.animalsbulders;

import ru.cherevichenkosn_animalsregisry.model.animalsclases.PackAnimals;

import java.time.LocalDate;
import java.io.Serializable;
public class PackAnimalsBuilder implements Serializable {
    public PackAnimals packAnimals(String type, String name, LocalDate birthday){
        PackAnimals packAnimals =  new PackAnimals(type,name,birthday);
        return packAnimals;
    }
}
