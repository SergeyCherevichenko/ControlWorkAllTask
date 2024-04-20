package ru.cherevichenkosn_animalsregisry.presenter;

import ru.cherevichenkosn_animalsregisry.model.animalsregistres.AnimalsRegistry;

import ru.cherevichenkosn_animalsregisry.view.View;

public class Presenter {
    View view;
    AnimalsRegistry animalsRegistry;

    public Presenter(View view) {
        this.view = view;
        animalsRegistry = new AnimalsRegistry();
    }
    public void createAnimals(){
        animalsRegistry.addAnimalsByType();
    }
    public  void  removeAnimal(){
        animalsRegistry.removeAnimalsAndUpdate();
    }
    public void commandAnimals(){
        animalsRegistry.InputCommandForAnimal();
    }
    public void printCommandAnimal(){
        animalsRegistry.printCommandAnimals();
    }
    public void SortAnimalByDateBirthDay(){
        animalsRegistry.SortByDataBirthDayPets();
    }
    public void printAllAnimals(){
        animalsRegistry.allAnimalPrints();
    }
    public void saveAnimals(){
        animalsRegistry.save();
    }
    public void readAnimals(){
        animalsRegistry.read();
    }
    public void deleteAnimals(){
        animalsRegistry.deleteFile();
    }


}
