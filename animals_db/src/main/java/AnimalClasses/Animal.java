package AnimalClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Animal {
    private int id;
    private String owner_name;
    private String breed;

    // �������� ����� ��������� ����� �������.
    // ���� ������� ����� (����� ��� �����), �� � ������� ����� ��� � �������� ����� � ������ ���������.
    // �� ������ �������� �������������� �������
    private HashMap<String, String> skills;
    protected String typeAnimal;
    protected String kind;
    protected String name;
    private Date brithDate;

    private SkillsInteract skillsInteract = new SkillsInteract();

    public Animal(String owner_name, String breed, String name, Date brithDate, int id){
        this.skills = new HashMap<>();
        this.skills.put("����", null);
        this.skills.put("�����", null);

        this.id = this.id;
        this.owner_name = owner_name;
        this.breed = breed;
        this.name = name;
        this.brithDate = brithDate;
    }

    public void applySkill(String skill) {
        if (!this.skills.containsKey(skill)) System.out.println("�������� �� ����� ��� ��� �������");
        else {
            // �������� ������ � ���������� ��������.
            skillsInteract.applySkill(skill, this.skills.get(skill));
        }
    }

    // �� ��������������� �����
    public void addNewSkill (String skill){
        // ��������� ��� �� ��� ����� �����
        if (this.skills.containsKey(skill)) System.out.println("���� ����� ��� ��������. �� ��� ����� ��������������");
        // ��� ��� ����� �� ������������, �� ��������� ��� ������� � ����� ���� � ���� �����, �� ����������
        else if (skillsInteract.checkSkill(skill)) this.skills.put(skill, null);
        else System.out.println("����� �� ��� �� �����. ����������� ���������������");
    }

    // ��������������� �����
    public void addNewSkill (String skill, String extendSkill){
        // ����� ��� �������� ��������� � ������� ����� ��������
        this.skills.put(skill, extendSkill);
        // ���������� �������� �� ���� � ����� ����. ���� ���, ��������� � ������ ���������.
        if (!skillsInteract.checkSkill(skill)) skillsInteract.addNewSkill(skill, extendSkill);
    }

    public int getId() {
        return id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public HashMap<String, String> getSkills() {
        return skills;
    }

//    public void setSkills(List<String> skills) {
//        this.skills = skills;
//    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
