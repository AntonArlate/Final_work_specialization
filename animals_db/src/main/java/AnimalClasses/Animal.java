package AnimalClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

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
    private LocalDate brithDate;



    public Animal(String owner_name, String breed, String name, LocalDate brithDate, int id){
        this.skills = new HashMap<>();
        this.skills.put("����", null);
        this.skills.put("�����", null);

        this.id = id;
        this.owner_name = owner_name;
        this.breed = breed;
        this.name = name;
        this.brithDate = brithDate;

        this.kind = "";
        this.typeAnimal = "";

    }

    public boolean applySkill(String skill) {
        if (!this.skills.containsKey(skill)) {
            System.out.println("�������� �� ����� ��� ��� �������");
            return false;
        }
        return true;
    }

    // �� ��������������� �����
    public void addNewSkill (String skill){
        this.skills.put(skill, null);
    }

    // ��������������� �����
    public void addNewSkill (String skill, String extendSkill){
        this.skills.put(skill, extendSkill);
        }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
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

    public String[] getAnimalAsString() {
        return new String[]{
                ("ID: " + Integer.toString(this.id)),
                ("���: " + this.name),
                ("���� ��������: " + brithDate.toString()),
                ("��� �������: " + this.owner_name),
                ("���: " + this.kind),
                ("���: " + this.typeAnimal),
                ("������: " + this.breed)
        };
    }
}
