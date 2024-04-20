package ru.cherevichenkosn_animalsregisry.view;

public class ReadAnimals extends Command{
    public ReadAnimals(ConsoleUI consoleUI) {
        super("Восстановить регистрацию животных.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().read();

    }
}
