package ru.cherevichenkosn_animalsregisry.view;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new CreateAnimal(consoleUI));
        commands.add(new RemoveAnimals(consoleUI));
        commands.add(new CommandsAnimals(consoleUI));
        commands.add(new PrintCommandsAnimal(consoleUI));
        commands.add(new SortAnimalsByDataBirthday(consoleUI));
        commands.add(new PrintAllAnimals(consoleUI));
        commands.add(new SaveAnimals(consoleUI));
        commands.add(new ReadAnimals(consoleUI));
        commands.add(new DeleteAnimals(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    public String menu(){
        StringBuilder stringBuilder  = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1)
                    .append(". ")
                    .append(commands.get(i).getDescription())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
    public void  exicute(int choice){
        Command command = commands.get(choice -1);
        command.execute();
    }
    public int size(){
        return commands.size();
    }
}
