package ru.cherevichenkosn_animalsregisry.model.animalsoperation;

import ru.cherevichenkosn_animalsregisry.model.datainputanimals.DataInput;
import ru.cherevichenkosn_animalsregisry.model.animalsregistres.PackAnimalRegistry;
import ru.cherevichenkosn_animalsregisry.model.animalsclases.PackAnimals;
import ru.cherevichenkosn_animalsregisry.model.animalsbulders.PackAnimalsBuilder;
import ru.cherevichenkosn_animalsregisry.model.interfaces.AnimalOperations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.Serializable;
public class PackAnimalOperation implements AnimalOperations,Serializable{
    private PackAnimalsBuilder packAnimalsBuilder;
    private PackAnimalRegistry packAnimalRegistry;
    private DataInput dataInput;
    private StringBuilder stringBuilder;

    public PackAnimalOperation() {
        this.packAnimalRegistry = new PackAnimalRegistry();
        this.stringBuilder = new StringBuilder();
        this.packAnimalsBuilder = new PackAnimalsBuilder();
        this.dataInput = new DataInput();
    }

    @Override
    public void CreateAndAddAnimal() {
        String type = dataInput.inputTypePackAnimals();
        String name = dataInput.inputNameAnimals();
        LocalDate birthday = dataInput.inputDateBirthDay();
        PackAnimals packAnimals = packAnimalsBuilder.packAnimals(type, name, birthday);
        packAnimalRegistry.addPackFnimals(packAnimals);
        String answer = dataInput.command();
        if(answer.equals("д")) CommandAnimal();
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
        for (int i = 0; i < packAnimalRegistry.getAllPackAnimals().size(); i++) {
            if (idInput == packAnimalRegistry.getAllPackAnimals().get(i).getPackAnimalsId()) {
                PackAnimals packAnimals = packAnimalRegistry.getAllPackAnimals().get(i);
                System.out.println("Напишите какую команду вы хотите добавить: ");
                String command = scanner.next();
                packAnimals.setCommandsPets(command);
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
            }catch (Exception e) {
                System.out.println("Не правильно выбран id. Попробуйте ущу раз!");
            }
        }
        for (int i = 0; i < packAnimalRegistry.getAllPackAnimals().size(); i++) {
            if (idInput == packAnimalRegistry.getAllPackAnimals().get(i).getPackAnimalsId()) {
                int finalIdInput = idInput;
                packAnimalRegistry.getAllPackAnimals().removeIf(packAnimals ->
                        packAnimals.getPackAnimalsId() == finalIdInput);
                for (int j = 0; j < packAnimalRegistry.getAllPackAnimals().size(); j++) {
                    packAnimalRegistry.getAllPackAnimals().get(j).setPackAnimalsId(j+1);
                }
                PackAnimals.setPackAnimalsIdCounter(packAnimalRegistry.getAllPackAnimals().size() +1);
                findAnimals = true;
                System.out.println("Удалено успешно!");
            }
        }
        if (!findAnimals) System.out.println("Животного с таким id нет в списке!");

    }

    @Override
    public void SortByDateBirthDay() {
        Collections.sort(packAnimalRegistry.getAllPackAnimals(), Comparator.comparing(PackAnimals::getBirthDay));
        printAllAnimal();

    }

    @Override
    public void printCommandAnimal() {
        Scanner scanner = new Scanner(System.in);
        boolean findAnimals = false;
        printAllAnimal();
        System.out.println("Введите номер животного по id список команд которого вы хотите увидеть:  ");
        boolean com = false;
        int idInput = 0;
        while (!com) {
            try {
                idInput = Integer.parseInt(scanner.next());
            }catch (Exception e) {
                System.out.println("Не правильно выбран id. Попробуйте ущу раз!");
            }
        }
        for (int i = 0; i < packAnimalRegistry.getAllPackAnimals().size(); i++) {
            if (idInput == packAnimalRegistry.getAllPackAnimals().get(i).getPackAnimalsId()) {
                System.out.println(packAnimalRegistry.getAllPackAnimals().get(i).getCommandsPets());
            }
        }
        if (!findAnimals) System.out.println("Животного с таким id нет в списке!");

    }

    @Override
    public void printAllAnimal() {
        String animal = "";
        if(packAnimalRegistry.getAllPackAnimals().isEmpty())
            System.out.println("У вас нет добавленных вьючных животных");
        else {
            for (int i = 0; i < packAnimalRegistry.getAllPackAnimals().size(); i++) {
                animal = stringBuilder.append(packAnimalRegistry.getAllPackAnimals().get(i).getPackAnimalsId())
                        .append("  ").append(packAnimalRegistry.getAllPackAnimals().get(i).getType())
                        .append("  ").append(packAnimalRegistry.getAllPackAnimals().get(i).getName())
                        .append("  ").append(packAnimalRegistry.getAllPackAnimals().get(i).getBirthDay())
                        .append("  ").append(packAnimalRegistry.getAllPackAnimals().get(i).getCommandsPets())
                        .append("\n").toString();

            }
            System.out.println(animal);
            stringBuilder = new StringBuilder();
        }
    }

    public PackAnimalRegistry getPackAnimalRegistry() {
        return packAnimalRegistry;
    }

    public void setPackAnimalRegistry(PackAnimalRegistry packAnimalRegistry) {
        this.packAnimalRegistry = packAnimalRegistry;
    }
}
