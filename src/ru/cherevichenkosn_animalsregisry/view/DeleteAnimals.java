package ru.cherevichenkosn_animalsregisry.view;

public class DeleteAnimals extends  Command{
    public DeleteAnimals( ConsoleUI consoleUI) {
        super("Удалить файл с регистрацией животных.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().delete();

    }
}
