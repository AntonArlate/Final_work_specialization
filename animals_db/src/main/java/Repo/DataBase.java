package Repo;

import AnimalClasses.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    List<Animal> animalList;
    Animal lastAnimal;
    SkillsInteract skillsInteract;

    public DataBase() {
        this.animalList = new ArrayList<>();
        this.skillsInteract = new SkillsInteract();
    }

    public boolean addNewAnimal(String owner_name, String breed, String name, String brithDateStr, String kind){
        boolean complete = true;
        int id;
        LocalDate brithDate = LocalDate.parse(brithDateStr);

        System.out.println(animalList.size());
        if (animalList.size() > 0) id = animalList.get(animalList.size()-1).getId() + 1;
        else id = 1;

        kind = kind.toLowerCase();
        if (kind.equals("asse")) animalList.add(new Asse(owner_name, breed, name, brithDate, id));
        else if (kind.equals("camel")) animalList.add(new Camel(owner_name, breed, name, brithDate, id));
        else if (kind.equals("cat")) animalList.add(new Cat(owner_name, breed, name, brithDate, id));
        else if (kind.equals("dog")) animalList.add(new Dog(owner_name, breed, name, brithDate, id));
        else if (kind.equals("hamster")) animalList.add(new Hamster(owner_name, breed, name, brithDate, id));
        else if (kind.equals("horse")) animalList.add(new Horse(owner_name, breed, name, brithDate, id));
        else {
            System.out.println("не верный вид животного");
            return false;
        }
        return complete;
    }

    public  String getAllSkills(){
        if (lastAnimal == null) {
            System.out.println("животное не выбрано");
            return "";
        }
        else return lastAnimal.getSkills().keySet().toString();
    }
    public void getAllSkills(int id){
        findForId(id);
        getAllSkills();
    }

    public void findForId (int id){
        for (Animal animal : animalList) {
            if (animal.getId() == id) {
                lastAnimal = animal;
                break;
            }
        }
    }

    public void addNewSkill (String skill, String extendedSkill) {
        if (lastAnimal == null) System.out.println("животное не выбрано");
        else if (extendedSkill == "") {
            // проверяем нет ли уже этого скила
            if (lastAnimal.getSkills().containsKey(skill)) {
                System.out.println("этот навык уже доступен. Но его можно переопределить");
            }
            // так как скилл не переопределён, то проверяем его наличие в общей базе и если найдём, то записываем
            else if (skillsInteract.checkSkill(skill)) lastAnimal.addNewSkill(skill);
            else System.out.println("этого ни кто не знает. Используйте переопределение");
        } else {
            // сразу без проверки добавляем с заменой новое значение
            lastAnimal.addNewSkill(skill, extendedSkill);
            // спрашиваем известен ли скил в общей базе. Если нет, добавляем с данным значением.
            if (!skillsInteract.checkSkill(skill)) {
                skillsInteract.addNewSkill(skill, extendedSkill);
            }
        }
    }

    public String[][] getAllAnimalsAsString() throws Exception {
        if(animalList.size()==0) {throw new Exception("Нет данных");}

        String[][] result = new String
                [animalList.size()]
                [animalList.get(0).getAnimalAsString().length]; //тут получаем один образец чтобы уточнить сколько полей выдаёт метод

        int i = 0;
        for (Animal animal : animalList) {
            result[i] = animal.getAnimalAsString();
            i++;
        }

        return result;
    }

    public String[] getAnimalAsString (){
        if (lastAnimal == null) System.out.println("животное не выбрано");
        else return lastAnimal.getAnimalAsString();
        return new String[] {""};
    }

    public void applySkill (String skill){
        if (lastAnimal.applySkill(skill))
            // посылаем запрос в обработчик действий.
            skillsInteract.applySkill(skill, lastAnimal.getSkills().get(skill));
    }


    public void changeTheSetting (String parameter, String value){
        parameter = parameter.toLowerCase();
        switch (parameter) {
            case "name":
                lastAnimal.setName(value);
                break;

            case "owner name":
                lastAnimal.setOwner_name(value);
                break;

            case "breed":
                lastAnimal.setBreed(value);
                break;

            case "brith date":
                lastAnimal.setBrithDate(LocalDate.parse(value));
                break;

            default:
                System.out.println("Параметр не найден");
                break;
        }
    }


}