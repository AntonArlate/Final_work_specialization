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
            System.out.println("�� ������ ��� ���������");
            return false;
        }
        return complete;
    }

    public  String getAllSkills(){
        if (lastAnimal == null) {
            System.out.println("�������� �� �������");
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
        if (lastAnimal == null) System.out.println("�������� �� �������");
        else if (extendedSkill == "") {
            // ��������� ��� �� ��� ����� �����
            if (lastAnimal.getSkills().containsKey(skill)) {
                System.out.println("���� ����� ��� ��������. �� ��� ����� ��������������");
            }
            // ��� ��� ����� �� ������������, �� ��������� ��� ������� � ����� ���� � ���� �����, �� ����������
            else if (skillsInteract.checkSkill(skill)) lastAnimal.addNewSkill(skill);
            else System.out.println("����� �� ��� �� �����. ����������� ���������������");
        } else {
            // ����� ��� �������� ��������� � ������� ����� ��������
            lastAnimal.addNewSkill(skill, extendedSkill);
            // ���������� �������� �� ���� � ����� ����. ���� ���, ��������� � ������ ���������.
            if (!skillsInteract.checkSkill(skill)) {
                skillsInteract.addNewSkill(skill, extendedSkill);
            }
        }
    }

    public String[][] getAllAnimalsAsString() throws Exception {
        if(animalList.size()==0) {throw new Exception("��� ������");}

        String[][] result = new String
                [animalList.size()]
                [animalList.get(0).getAnimalAsString().length]; //��� �������� ���� ������� ����� �������� ������� ����� ����� �����

        int i = 0;
        for (Animal animal : animalList) {
            result[i] = animal.getAnimalAsString();
            i++;
        }

        return result;
    }

    public String[] getAnimalAsString (){
        if (lastAnimal == null) System.out.println("�������� �� �������");
        else return lastAnimal.getAnimalAsString();
        return new String[] {""};
    }

    public void applySkill (String skill){
        if (lastAnimal.applySkill(skill))
            // �������� ������ � ���������� ��������.
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
                System.out.println("�������� �� ������");
                break;
        }
    }


}