package Repo;

import AnimalClasses.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBase {
    List<Animal> animalList;

    public void DataBase (){
        animalList = new ArrayList<>();
    }

    public void addNewAnimal(String owner_name, String breed, String name, Date brithDate, String kind){
        int id;

        if (animalList.size() > 0) id = animalList.get(animalList.size()-1).getId() + 1;
        else id = 1;

        kind = kind.toLowerCase();
        if (kind == "asse") animalList.add(new Asse(owner_name, breed, name, brithDate, id));
        else if (kind == "camel") animalList.add(new Camel(owner_name, breed, name, brithDate, id));
        else if (kind == "cat") animalList.add(new Cat(owner_name, breed, name, brithDate, id));
        else if (kind == "dog") animalList.add(new Dog(owner_name, breed, name, brithDate, id));
        else if (kind == "hamster") animalList.add(new Hamster(owner_name, breed, name, brithDate, id));
        else if (kind == "horse") animalList.add(new Horse(owner_name, breed, name, brithDate, id));
        else System.out.println("не верный вид животного");
    }

    public void getSkill (int id){
        for (Animal animal : animalList) {
            if (animal.getId() == id) {
                System.out.println(animal.getSkills());
                break;
            }
        }
    }


}
