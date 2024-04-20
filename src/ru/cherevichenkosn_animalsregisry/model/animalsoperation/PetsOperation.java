package ru.cherevichenkosn_animalsregisry.model.animalsoperation;

import ru.cherevichenkosn_animalsregisry.model.datainputanimals.DataInput;
import ru.cherevichenkosn_animalsregisry.model.animalsclases.Pets;
import ru.cherevichenkosn_animalsregisry.model.animalsregistres.PetsRegistry;
import ru.cherevichenkosn_animalsregisry.model.animalsbulders.PetsAnimalBuilder;
import ru.cherevichenkosn_animalsregisry.model.interfaces.AnimalOperations;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PetsOperation implements AnimalOperations,Serializable{
    private PetsRegistry petsRegistry;
    private PetsAnimalBuilder petsAnimalBuilder;
    private DataInput dataInput;
    private StringBuilder stringBuilder;

    public PetsOperation() {
        this.petsAnimalBuilder = new PetsAnimalBuilder();
        this.petsRegistry = new PetsRegistry();
        this.dataInput = new DataInput();
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void CreateAndAddAnimal() {
        String type = dataInput.inputTypePetsAnimals();
        String name = dataInput.inputNameAnimals();
        LocalDate birthday = dataInput.inputDateBirthDay();
        Pets pets = petsAnimalBuilder.petsBuilder(type, name, birthday);
        petsRegistry.addPets(pets);
        String answer = dataInput.command();
        if (answer.equals("д")) CommandAnimal();

    }

    @Override
    public void CommandAnimal() {
        Scanner scanner = new Scanner(System.in);
        boolean findAnimals = false;
        printAllAnimal();
        System.out.println("Выберите животное, которому вы хотите добавить команду по id: ");
        boolean com = false;
        int idInput = 0;
        while (!com) {
            try {
                idInput = Integer.parseInt(scanner.next());
                com = true;
            } catch (Exception e) {
                System.out.println("Не правильно выбран id. Попробуйте ущу раз!");
            }
        }
        for (int i = 0; i < petsRegistry.getAllPets().size(); i++) {
            if (idInput == petsRegistry.getAllPets().get(i).getPetsId()) {
                Pets pets = petsRegistry.getAllPets().get(i);
                System.out.println("Напишите какую команду вы хотите добавить: ");
                String command = scanner.next();
                pets.setCommandsPets(command);
                findAnimals = true;
                System.out.println("Команда " + command + " добавлена успешна!");
            }
        }
        if (!findAnimals) System.out.println("Животного с таким id нет в списке!");
    }

    @Override
    public void removeAnimalAndUpdate() {
        Scanner scanner = new Scanner(System.in);
        boolean findAnimals = false;
        printAllAnimal();
        System.out.println("Выберите животное, которое вы хотите удалить по id: ");
        boolean com = false;
        int idInput = 0;
        while (!com) {
            try {
                idInput = Integer.parseInt(scanner.next());
                com = true;
            } catch (Exception e) {
                System.out.println("Не правильно выбран id. Попробуйте еще раз!");
            }
        }

        for (int i = 0; i < petsRegistry.getAllPets().size(); i++) {
            if (idInput == petsRegistry.getAllPets().get(i).getPetsId()) {
                int finalIdInput = idInput;
                petsRegistry.getAllPets().removeIf(pets -> pets.getPetsId() == finalIdInput);
                for (int j = 0; j < petsRegistry.getAllPets().size(); j++) {
                    petsRegistry.getAllPets().get(j).setPetsId(j + 1);
                }
                Pets.setPetsIdCounter(petsRegistry.getAllPets().size() + 1);
                findAnimals = true;
                System.out.println("Удалено успешно!");
            }
        }
        if (!findAnimals) System.out.println("Животного с таким id нет в списке!");

    }

    @Override
    public void SortByDateBirthDay() {
        Collections.sort(petsRegistry.getAllPets(), Comparator.comparing(Pets::getBirthDay));
        printAllAnimal();
    }

        @Override
        public void printCommandAnimal() {
            Scanner scanner = new Scanner(System.in);
            boolean findAnimals = false;
            printAllAnimal();
            System.out.println("Введите номер животного по id, список команд которого вы хотите увидеть: ");
            boolean com = false;
            int idInput = 0;
            while (!com) {
                try {
                    idInput = Integer.parseInt(scanner.next());
                } catch (Exception e) {
                    System.out.println("Не правильно выбран id. Попробуйте ущу раз!");
                }
            }
            for (int i = 0; i < petsRegistry.getAllPets().size(); i++) {
                if (idInput == petsRegistry.getAllPets().get(i).getPetsId()) {
                    System.out.println(petsRegistry.getAllPets().get(i).getCommandsPets());
                    findAnimals = true;
                }
            }
            if (!findAnimals) System.out.println("Животного с таким id нет в списке!");
        }

    @Override
    public void printAllAnimal() {
        String animal = " ";
        if(petsRegistry.getAllPets().isEmpty())
            System.out.println("У вас нет добавленных домашних животных");
        else {
            for (int i = 0; i < petsRegistry.getAllPets().size(); i++) {
                animal = stringBuilder.append(petsRegistry.getAllPets().get(i).getPetsId())
                        .append("  ").append(petsRegistry.getAllPets().get(i).getType())
                        .append("  ").append(petsRegistry.getAllPets().get(i).getName())
                        .append("  ").append(petsRegistry.getAllPets().get(i).getBirthDay())
                        .append("  ").append(petsRegistry.getAllPets().get(i).getCommandsPets())
                        .append("\n").toString();

            }
            System.out.println(animal);
            stringBuilder = new StringBuilder();
        }
    }

    public PetsRegistry getPetsRegistry() {
        return petsRegistry;
    }

    public void setPetsRegistry(PetsRegistry petsRegistry) {
        this.petsRegistry = petsRegistry;
    }
}

