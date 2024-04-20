package ru.cherevichenkosn_animalsregisry.view;

public class SaveAnimals extends Command{
    public SaveAnimals( ConsoleUI consoleUI) {
        super("Сохранить проект регистрации животных.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().save();

    }
}
