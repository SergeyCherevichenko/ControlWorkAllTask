package ru.cherevichenkosn_animalsregisry.view;

public class PrintCommandsAnimal extends Command{
    public PrintCommandsAnimal( ConsoleUI consoleUI) {
        super("Вывести список команд выбранного животного.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printCommandAnimal();

    }
}
