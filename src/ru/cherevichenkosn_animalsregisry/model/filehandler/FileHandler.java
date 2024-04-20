package ru.cherevichenkosn_animalsregisry.model.filehandler;

import ru.cherevichenkosn_animalsregisry.model.animalsclases.PackAnimals;
import ru.cherevichenkosn_animalsregisry.model.animalsclases.Pets;
import ru.cherevichenkosn_animalsregisry.model.animalsoperation.PetsOperation;
import ru.cherevichenkosn_animalsregisry.model.animalsregistres.AnimalsRegistry;
import ru.cherevichenkosn_animalsregisry.model.animalsregistres.PackAnimalRegistry;
import ru.cherevichenkosn_animalsregisry.model.animalsregistres.PetsRegistry;
import ru.cherevichenkosn_animalsregisry.model.interfaces.Writable;

import java.io.*;
import java.util.Arrays;

public class FileHandler implements Writable, Serializable {
    private AnimalsRegistry animalsRegistry;
    public FileHandler(AnimalsRegistry animalsRegistry) {
        this.animalsRegistry = animalsRegistry;
    }

    @Override
    public void save() {
        try {
             ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("file.out"));

            objectOutputStream.writeInt(Pets.getPetsIdCounter());
            objectOutputStream.writeInt(PackAnimals.getPackAnimalsIdCounter());
            objectOutputStream.writeObject(animalsRegistry);
            objectOutputStream.close();
            System.out.println("Сохранено успешно!");
        }catch (Exception e){
            System.out.println("Не удалось сохранить");
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("file.out"));
            Pets.setPetsIdCounter(objectInputStream.readInt());
            PackAnimals.setPackAnimalsIdCounter(objectInputStream.readInt());
            animalsRegistry = (AnimalsRegistry) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Файл регистрации восстановлен успешно!");
            return animalsRegistry;
        }catch (Exception e){
            System.out.println("Не удалось восстановить");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteFile() {
        File file = new File("file.out");
        if(file.delete()){
            System.out.println("Файл успешно удален");
        }else{
            System.out.println("Не удалось удалить файл");
        }



    }

}
