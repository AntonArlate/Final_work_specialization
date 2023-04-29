package AnimalClasses;

import java.util.HashMap;

public class SkillsInteract {
    private HashMap<String, String> skillList;

    public SkillsInteract() {
        this.skillList = new HashMap<>();
        this.skillList.put("есть", "животное поело");
        this.skillList.put("голос", "издаЄт звук");
    }

    // в перспективе можно реализовать реагировать на действи€ не простым текстовым сообщением.
    public void applySkill(String skill, String extendSkill) {
        if (!checkSkill(skill)) System.out.println("Ќи кто этого не умеет");
        else if (extendSkill == null) System.out.println(this.skillList.get(skill));
        else System.out.println(extendSkill);
    }
    public void applySkill(String skill) {
        applySkill(skill, null);
    }

    public boolean checkSkill (String skill){
        return this.skillList.containsKey((skill));
    }

    // добавление с переопределением
    public void addNewSkill (String skill, String extendedSkill){
        this.skillList.put(skill, extendedSkill);
    }
}
