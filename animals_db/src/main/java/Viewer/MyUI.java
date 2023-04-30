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
            System.out.println("Введите число для соответствующей задачи или иное для выхода:");
            System.out.println("0. Загрузить тестовые данные");
            System.out.println("1. Список всех животных");
            System.out.println("2. Завести новое животное");
            System.out.println("3. Выбрать животное для взаимодействия");

            com = in.nextLine();

            switch (com) {
                case "0": // Загрузить тестовые данные
                    TestData testData = new TestData();

                    for (int i = 0; i < testData.testString.length; i++) {
                        for (int j = 0; j < testData.testString[0].length; j++) {
                            if (j == 0) owner_name = testData.testString[i][j];
                            if (j == 1) breed = testData.testString[i][j];
                            if (j == 2) name = testData.testString[i][j];
                            if (j == 3) brithDateStr = testData.testString[i][j];
                            if (j == 4) kind = testData.testString[i][j];

                        }
                        if (!dataBase.addNewAnimal(owner_name, breed, name, brithDateStr, kind)) System.out.println("Не выполнено");
                    }

                    break;

                case "1": // Список всех животных
                    try {
                        String [][] animalList = dataBase.getAllAnimalsAsString();
                        for (String[] item : animalList) {
                            System.out.println(Arrays.toString(item));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2": // Завести новое животное
                    System.out.print("Введите вид (asse, camel, cat, dog, hamster or horse): ");
                    kind = in.nextLine();
                    if (!Arrays.asList("asse", "camel", "cat", "dog", "hamster", "horse").contains(kind.toLowerCase())) {
                        System.out.println("Не верный ввод. Начните сначала");
                        break;
                    }
                    System.out.print("Введите имя: ");
                    name = in.nextLine();
                    System.out.print("Введите породу: ");
                    breed = in.nextLine();
                    System.out.print("Введите дату рождения (гггг-мм-дд): ");
                    brithDateStr = in.nextLine();
                    System.out.print("Введите имя хозяина]: ");
                    owner_name = in.nextLine();

                    if (dataBase.addNewAnimal(owner_name, breed, name, brithDateStr, kind)) System.out.println("Выполнено");
                    else System.out.println("Не выполнено");
                    break;

                case "3": // Выбрать животное для взаимодействия
                    System.out.print("Введите id: ");
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
            System.out.println("Выбрано животное: " + Arrays.toString(dataBase.getAnimalAsString()));
            System.out.println("Введите число для соответствующей задачи или иное для возврата в предыдущее меню:");
            System.out.println("1. Увидеть список команд, которые выполняет животное");
            System.out.println("2. Обучить животное новым командам");
            System.out.println("3. Выполнить команду");
            System.out.println("4. Изменить");

            com = in.nextLine();

            switch (com) {
                case "1": // Увидеть список команд, которые выполняет животное
                    System.out.println(dataBase.getAllSkills());
                    break;

                case "2": // Обучить животное новым командам
                    System.out.println("Введите название команды: ");
                    String skill = in.nextLine();
                    System.out.println("Введите действие при выполнении (оставить пустым для отмены переопределения): ");
                    String extendedSkill = in.nextLine();

                    dataBase.addNewSkill(skill, extendedSkill);
                    break;

                case "3": // Выполнить команду
                    System.out.print("Введите команду: ");
                    dataBase.applySkill(in.nextLine());
                    break;

                case "4": // Изменить
                    System.out.print("Введите параметр (name, owner name, breed, brith date): ");
                    String parameter = in.nextLine();
                    System.out.print("Введите новое значение: ");
                    String value = in.nextLine();
                    dataBase.changeTheSetting(parameter, value);
                    break;

                default:
                    begin = false;
                    break;
            }
            System.out.println(">> Выполнено <<");
        }
    }
}
class TestData{
//    owner_name, breed, name, brithDateStr, kind
    String[][] testString = {
            {"Вася", "", "Нилс", "2019-05-25", "dog"},
            {"Оля", "", "Риддл", "2020-11-05", "Hamster"},
            {"Максим", "", "Керри", "2021-01-12", "Cat"},
            {"Оля", "", "Джаспер", "2019-07-01", "horse"}
    };
}

