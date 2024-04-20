package ru.cherevichenkosn_animalsregisry.view;

public class CommandsAnimals  extends Command{
    public CommandsAnimals( ConsoleUI consoleUI) {
        super("Добавить команды для выбранного животного.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().inputCommandForAnimal();

    }
}
