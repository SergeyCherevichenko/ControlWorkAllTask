package ru.cherevichenkosn_animalsregisry.view;

public class PrintAllAnimals extends Command{
    public PrintAllAnimals( ConsoleUI consoleUI) {
        super("Вывести всех животных.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printAllAnimals();

    }
}
