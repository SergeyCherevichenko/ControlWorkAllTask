package ru.cherevichenkosn_animalsregisry.view;

public class CreateAnimal extends Command{
    public CreateAnimal( ConsoleUI consoleUI) {
        super("Добавить животное.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().createAnimals();
    }
}
