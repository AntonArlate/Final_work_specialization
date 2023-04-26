package AnimalClasses;

import java.util.HashMap;

public class SkillsInteract {
    private HashMap<String, String> skillList;

    public SkillsInteract() {
        this.skillList = new HashMap<>();
        this.skillList.put("����", "�������� �����");
        this.skillList.put("�����", "");
    }

    public void applySkill(String skill, String extendSkill) {
        if (!this.skillList.containsKey(skill)) System.out.println("�� ��� ����� �� �����");
        else {
            System.out.println(this.skillList.get(skill) + " " + extendSkill);
        }
    }

    public void applySkill(String skill) {
        applySkill(skill, "");
    }
}
