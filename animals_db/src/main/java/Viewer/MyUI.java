package Viewer;


import Repo.DataBase;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MyUI {

    private DataBase dataBase;

    private Scanner in = new Scanner(System.in);

    public void setDataBase (DataBase dataBase) {this.dataBase = dataBase;}

    public void start() {
        Boolean begin = true;
        String com;
//        System.out.print("\033[H\033[J");

        String owner_name = "";
        String breed = "";
        String name = "";
        String brithDateStr = "";
        String kind = "";


        while (begin) {

            System.out.println("------");
            System.out.println("������� ����� ��� ��������������� ������ ��� ���� ��� ������:");
            System.out.println("0. ��������� �������� ������");
            System.out.println("1. ������ ���� ��������");
            System.out.println("2. ������� ����� ��������");
            System.out.println("3. ������� �������� ��� ��������������");

            com = in.nextLine();

            switch (com) {
                case "0": // ��������� �������� ������
                    TestData testData = new TestData();

                    for (int i = 0; i < testData.testString.length; i++) {
                        for (int j = 0; j < testData.testString[0].length; j++) {
                            if (j == 0) owner_name = testData.testString[i][j];
                            if (j == 1) breed = testData.testString[i][j];
                            if (j == 2) name = testData.testString[i][j];
                            if (j == 3) brithDateStr = testData.testString[i][j];
                            if (j == 4) kind = testData.testString[i][j];

                        }
                        if (!dataBase.addNewAnimal(owner_name, breed, name, brithDateStr, kind)) System.out.println("�� ���������");
                    }

                    break;

                case "1": // ������ ���� ��������
                    try {
                        String [][] animalList = dataBase.getAllAnimalsAsString();
                        for (String[] item : animalList) {
                            System.out.println(Arrays.toString(item));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2": // ������� ����� ��������
                    System.out.print("������� ��� (asse, camel, cat, dog, hamster or horse): ");
                    kind = in.nextLine();
                    if (!Arrays.asList("asse", "camel", "cat", "dog", "hamster", "horse").contains(kind.toLowerCase())) {
                        System.out.println("�� ������ ����. ������� �������");
                        break;
                    }
                    System.out.print("������� ���: ");
                    name = in.nextLine();
                    System.out.print("������� ������: ");
                    breed = in.nextLine();
                    System.out.print("������� ���� �������� (����-��-��): ");
                    brithDateStr = in.nextLine();
                    System.out.print("������� ��� �������]: ");
                    owner_name = in.nextLine();

                    if (dataBase.addNewAnimal(owner_name, breed, name, brithDateStr, kind)) System.out.println("���������");
                    else System.out.println("�� ���������");
                    break;

                case "3": // ������� �������� ��� ��������������
                    System.out.print("������� id: ");
                    dataBase.findForId(in.nextInt());
                    menuModification();
                    break;

                default:
                    begin = false;
                    break;
            }
        }

    }

    public void sendErrorMessage(String message) {
        System.out.println(message);
    }

    private void menuModification() {

        in.nextLine();

        Boolean begin = true;
        String com;
        while (begin) {

            System.out.println("------");
            System.out.println("������� ��������: " + Arrays.toString(dataBase.getAnimalAsString()));
            System.out.println("������� ����� ��� ��������������� ������ ��� ���� ��� �������� � ���������� ����:");
            System.out.println("1. ������� ������ ������, ������� ��������� ��������");
            System.out.println("2. ������� �������� ����� ��������");
            System.out.println("3. ��������� �������");
            System.out.println("4. ��������");

            com = in.nextLine();

            switch (com) {
                case "1": // ������� ������ ������, ������� ��������� ��������
                    System.out.println(dataBase.getAllSkills());
                    break;

                case "2": // ������� �������� ����� ��������
                    System.out.println("������� �������� �������: ");
                    String skill = in.nextLine();
                    System.out.println("������� �������� ��� ���������� (�������� ������ ��� ������ ���������������): ");
                    String extendedSkill = in.nextLine();

                    dataBase.addNewSkill(skill, extendedSkill);
                    break;

                case "3": // ��������� �������
                    System.out.print("������� �������: ");
                    dataBase.applySkill(in.nextLine());
                    break;

                case "4": // ��������
                    System.out.print("������� �������� (name, owner name, breed, brith date): ");
                    String parameter = in.nextLine();
                    System.out.print("������� ����� ��������: ");
                    String value = in.nextLine();
                    dataBase.changeTheSetting(parameter, value);
                    break;

                default:
                    begin = false;
                    break;
            }
            System.out.println(">> ��������� <<");
        }
    }
}
class TestData{
//    owner_name, breed, name, brithDateStr, kind
    String[][] testString = {
            {"����", "", "����", "2019-05-25", "dog"},
            {"���", "", "�����", "2020-11-05", "Hamster"},
            {"������", "", "�����", "2021-01-12", "Cat"},
            {"���", "", "�������", "2019-07-01", "horse"}
    };
}

