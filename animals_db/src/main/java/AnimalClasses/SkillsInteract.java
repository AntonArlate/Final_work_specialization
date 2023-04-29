package AnimalClasses;

import java.util.HashMap;

public class SkillsInteract {
    private HashMap<String, String> skillList;

    public SkillsInteract() {
        this.skillList = new HashMap<>();
        this.skillList.put("����", "�������� �����");
        this.skillList.put("�����", "����� ����");
    }

    // � ����������� ����� ����������� ����������� �� �������� �� ������� ��������� ����������.
    public void applySkill(String skill, String extendSkill) {
        if (!checkSkill(skill)) System.out.println("�� ��� ����� �� �����");
        else if (extendSkill == null) System.out.println(this.skillList.get(skill));
        else System.out.println(extendSkill);
    }
    public void applySkill(String skill) {
        applySkill(skill, null);
    }

    public boolean checkSkill (String skill){
        return this.skillList.containsKey((skill));
    }

    // ���������� � ����������������
    public void addNewSkill (String skill, String extendedSkill){
        this.skillList.put(skill, extendedSkill);
    }
}
