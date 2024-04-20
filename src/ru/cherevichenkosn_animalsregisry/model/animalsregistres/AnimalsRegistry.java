package ru.cherevichenkosn_animalsregisry.model.animalsregistres;
import ru.cherevichenkosn_animalsregisry.model.animalsclases.PackAnimals;
import ru.cherevichenkosn_animalsregisry.model.datainputanimals.DataInput;
import ru.cherevichenkosn_animalsregisry.model.filehandler.FileHandler;
import ru.cherevichenkosn_animalsregisry.model.animalsoperation.PackAnimalOperation;
import ru.cherevichenkosn_animalsregisry.model.animalsoperation.PetsOperation;
import ru.cherevichenkosn_animalsregisry.model.interfaces.Writable;

import java.util.Scanner;
import java.io.Serializable;
public class AnimalsRegistry implements Writable,Serializable {

    private DataInput dataInput;
    private PetsOperation petsOperation;
    private PackAnimalOperation packAnimalOperation;
    private Writable writable;

    public AnimalsRegistry() {
        this.packAnimalOperation = new PackAnimalOperation();
        this.petsOperation = new PetsOperation();
        this.dataInput = new DataInput();
        this.writable = new FileHandler(this);
    }
    public void addAnimalsByType() {
        int animalsType = dataInput.numberAnimals("Какое животное вы хотите добавить," +
                " если домашнее введите 1 или если вьючное введите цифру 2");
        if (animalsType == 1) {
           petsOperation.CreateAndAddAnimal();

        } else {
            packAnimalOperation.CreateAndAddAnimal();
        }
    }
    public void  InputCommandForAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вид животного 1 домашнее или 2 вьючное, которому вы хотите добавить команду: ");
        int kindNumber = 0;
        boolean com = false;
        while (!com) {
            try {
                 kindNumber = Integer.parseInt(scanner.next());
                com = true;
            } catch (Exception e) {
                System.out.println("Вы должны выбрать 1 или 2");
            }
        }
        boolean findAnimals = false;
        if (kindNumber == 1) {
           petsOperation.CommandAnimal();

        } else {
           packAnimalOperation.CommandAnimal();
        }
    }
    public void removeAnimalsAndUpdate () {

        int numberType = dataInput.numberAnimals("Какое животное вы хотите удалить, " +
                "если домашнее введите 1 или если вьючное введите цифру 2");
        boolean findAnimals = false;
        if (numberType == 1) {
            petsOperation.removeAnimalAndUpdate();
        }else {
            packAnimalOperation.removeAnimalAndUpdate();

        }
    }
    public void save() {
        try {
            writable.save();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Object read() {
        try {
             AnimalsRegistry animalsRegistry = (AnimalsRegistry) writable.read();
             this.petsOperation = animalsRegistry.petsOperation;
             this.packAnimalOperation = animalsRegistry.packAnimalOperation;
             this.dataInput = animalsRegistry.dataInput;
             this.writable = animalsRegistry.writable;
             return animalsRegistry;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
    public void deleteFile() {
        try {
            writable.deleteFile();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void SortByDataBirthDayPets() {
        int animalType = dataInput.numberAnimals("Введите тип животных, которые вы хотите отсортировать " +
                "по дате рождения по возрастанию 1 или 2: ");
        if (animalType == 1) {
            petsOperation.SortByDateBirthDay();
        } else {
            packAnimalOperation.SortByDateBirthDay();
        }
    }
    public  void printCommandAnimals() {

        int animalType = dataInput.numberAnimals("Введите вид животных 1 домашнее или 2 вьючное  " +
                "список команд которых вы хотите увидеть:");
        boolean findAnimals = false;
        if (animalType == 1) {
           petsOperation.printCommandAnimal();
        } else {
           packAnimalOperation.CommandAnimal();
        }
    }
    public void allPetsPrint() {
        System.out.println("Все домашние животные: ");
        petsOperation.printAllAnimal();

    }
       public void allPackAnimalsPrint(){
           System.out.println("Все вьючные животные: ");
           packAnimalOperation.printAllAnimal();

    }
    public void allAnimalPrints(){
        allPetsPrint();
        allPackAnimalsPrint();
    }

}
