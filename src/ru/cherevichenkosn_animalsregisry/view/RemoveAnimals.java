package ru.cherevichenkosn_animalsregisry.view;

public class RemoveAnimals extends Command{
    public RemoveAnimals( ConsoleUI consoleUI) {
        super("Удалить выбранное животное.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().removeAnimalsAndUpdate();

    }
}
