package ru.cherevichenkosn_animalsregisry.view;

import ru.cherevichenkosn_animalsregisry.model.datainputanimals.DataInput;
import ru.cherevichenkosn_animalsregisry.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);

    }

    @Override
    public void start() {
        System.out.println("Здравствуйте. Это программа для создания реестра животных.\n Выберите одну" +
                " из операций ниже по номеру: ");
        while (work){
            ppintMenu();
            choice();
        }

    }
    private void choice(){
        int line = scanner.nextInt();
        if(line > 0 && line <= menu.size()) menu.exicute(line);
        else error();
    }
    private void ppintMenu(){
        System.out.println(menu.menu());
    }
    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }
    private void error(){
        System.out.println("Операции с таким номером не существует! Выберите из списка!");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
    public void createAnimals(){
        presenter.createAnimals();
    }
    public void removeAnimalsAndUpdate(){
        presenter.removeAnimal();
    }
    public void inputCommandForAnimal(){
        presenter.commandAnimals();
    }
    public void printCommandAnimal(){
        presenter.printCommandAnimal();
    }
    public void sortAnimalByDateBirthday(){
        presenter.SortAnimalByDateBirthDay();
    }
    public void printAllAnimals(){
        presenter.printAllAnimals();
    }
    public void save(){
        presenter.saveAnimals();
    }
    public void read(){
        presenter.readAnimals();
    }
    public void delete(){
        presenter.deleteAnimals();
    }

}
