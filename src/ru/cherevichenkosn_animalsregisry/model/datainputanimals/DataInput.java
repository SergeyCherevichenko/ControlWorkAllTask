package ru.cherevichenkosn_animalsregisry.model.datainputanimals;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class DataInput implements Serializable {
     private List<String> petsAnimalList;
    private List<String> packAnimalsList;

    public DataInput() {
        this.petsAnimalList = new ArrayList<>();
        petsAnimalList.add("собака");
        petsAnimalList.add("кошка");
        petsAnimalList.add("хомяк");
        this.packAnimalsList = new ArrayList<>();
        packAnimalsList.add("верблюд");
        packAnimalsList.add("лошадь");
        packAnimalsList.add("осел");
    }

    public int numberAnimals(String str) {
        Scanner scann = new Scanner(System.in);
        int number = 0;

        while (true) {
            System.out.println(str);
            try {
                number = Integer.parseInt(scann.next());
                if (number < 1 || number > 2) {
                    System.out.println("Вы должны ввести 1 или 2. Попробуйте еще раз!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число, попробуйте еще раз");
            }
        }

        return number;
    }

    public String inputNameAnimals() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Введите имя животного: ");
        String name = scann.next();
        return name;
    }

    public String inputTypePetsAnimals() {
        Scanner scann = new Scanner(System.in);
        System.out.println("Вы можете добавить: " );
        for (int i = 0; i < petsAnimalList.size(); i++) {
            System.out.println(petsAnimalList.get(i));
        }
        System.out.println("Введите тип животного: ");
        String type = scann.next();
        boolean findAnimals = false;
        for (int i = 0; i < petsAnimalList.size(); i++) {
            if (type.equals(petsAnimalList.get(i))) {
                type = petsAnimalList.get(i);
                findAnimals = true;
                return type;
            }
        }
        if(!findAnimals){
            System.out.println("Животного такого типа нет в списке! Хотите добавить новый тип " +
                "домашнего животного? д/н");
                String ans = scann.next();
                if(ans.equals("д")) {
                    System.out.println("Введите новый вид  домашнего животного: ");
                    String newPets = scann.next();
                    List<String> newAnimal = getPetsAnimalList();
                    newAnimal.add(newPets);
                    setPetsAnimalList(newAnimal);
                    inputTypePetsAnimals();
                }else {
                    inputTypePetsAnimals();
                }
        }
        return type;
    }
    public  String inputTypePackAnimals(){
        Scanner scann = new Scanner(System.in);
        System.out.println("Вы можете добавить: " );
        for (int i = 0; i < packAnimalsList.size(); i++) {
            System.out.println(packAnimalsList.get(i));
        }
        System.out.println("Введите тип животного: ");
        String type = scann.next();
        boolean findAnimals = false;
        for (int i = 0; i < packAnimalsList.size(); i++) {
            if (type.equals(packAnimalsList.get(i))) {
                type = packAnimalsList.get(i);
                findAnimals = true;
                return type;

            }
        }
        if(!findAnimals){
            System.out.println("Животного такого типа нет в списке! Хотите добавить новый тип " +
                    "вьючного животного? д/н");
            String ans = scann.next();
            if(ans.equals("д")) {
                System.out.println("Введите новый вид вьючного животного: ");
                String newPets = scann.next();
                List<String> newAnimal = getPackAnimalsList();
                newAnimal.add(newPets);
                setPackAnimalsList(newAnimal);
                inputTypePackAnimals();
            }else {
                inputTypePackAnimals();
            }
        }
        return type;
    }

    public LocalDate inputDateBirthDay() {
        Scanner scann = new Scanner(System.in);
        boolean input = false;
        int year = 0;
        int month = 0;
        int day = 0;
        LocalDate birthday  = LocalDate.now();
        while (!input) {
            System.out.println("введите год рождения животного: ");
            try {
                year = Integer.parseInt(scann.next());
                input = true;
            } catch (Exception e) {
                System.out.println("Вы ввели не число! Попробуйте еще раз!");
            }

            System.out.println("Введите месяц рождения животного: ");
            try {
                month = Integer.parseInt(scann.next());
                input = true;
            } catch (Exception e) {
                System.out.println("Вы ввели не число! Попробуйте еще раз!");
            }

            System.out.println("Введите день рождения животного: ");
            try {
                day = Integer.parseInt(scann.next());
                input = true;
            } catch (Exception e) {
                System.out.println("Вы ввели не число! Попробуйте еще раз!");
            }

            try {
                birthday = LocalDate.of(year, month, day);
                input = true;
            } catch (Exception e) {
                System.out.println("Не корректна введена дата! Попробуйте еще раз! ");
                inputDateBirthDay();
            }
        }
        return birthday;
        }

    public String command() {
        Scanner scann = new Scanner(System.in);
        String answer = " ";
        boolean ans = false;
        while (!ans) {
            System.out.println("Хотите ли вы добавить команды для животного, нажмите д/н");
            answer = scann.next();
            if (answer.equals("д") || answer.equals("н")) {
                ans = true;

            } else {
                System.out.println("Вы должны ввести д или н");
            }
        }
        return answer;

            }

    public void setPetsAnimalList(List<String> petsAnimalList) {
        this.petsAnimalList = petsAnimalList;
    }

    public void setPackAnimalsList(List<String> packAnimalsList) {
        this.packAnimalsList = packAnimalsList;
    }

    public List<String> getPetsAnimalList() {
        return petsAnimalList;
    }

    public List<String> getPackAnimalsList() {
        return packAnimalsList;
    }
}




