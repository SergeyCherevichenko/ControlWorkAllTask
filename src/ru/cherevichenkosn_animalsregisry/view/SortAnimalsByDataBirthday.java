package ru.cherevichenkosn_animalsregisry.view;

public class SortAnimalsByDataBirthday extends Command{
    public SortAnimalsByDataBirthday( ConsoleUI consoleUI) {
        super("Отсортировать животных по дате рождения.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortAnimalByDateBirthday();

    }
}
