package AnimalClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Animal {
    private int id;
    private String owner_name;
    private String breed;
    private List<String> skills;
    protected String typeAnimal;
    protected String kind;
    protected String name;
    private Date brithDate;

    private SkillsInteract skillsInteract = new SkillsInteract();

    public Animal(String owner_name, String breed, String name, Date brithDate){
        this.skills = new ArrayList<>();
        this.skills.add("есть");
        this.skills.add("голос");

        this.owner_name = owner_name;
        this.breed = breed;
        this.name = name;
        this.brithDate = brithDate;
    }

    public void applySkill(String skill) {
        applySkill(skill, "");
    }

    public void applySkill(String skill, String extendSkill) {
        if (!this.skills.contains(skill)) System.out.println("Животное не знает как это сделать");
        else {
            // посылаем запрос в обработчик действий.
            skillsInteract.applySkill(skill, extendSkill);
        }
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

    public List<String> getSkills() {
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
