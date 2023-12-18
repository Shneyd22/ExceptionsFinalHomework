package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] personData = scanner.nextLine().split(" ");
        System.out.println(Arrays.toString(personData));
        Person person = new Person(new String[3], null, 0, ' ');
        dataInputService(personData, person);
        System.out.println(Arrays.toString(person.getName()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(person.birthDate);
        System.out.println(strDate);
        System.out.println(person.phone);
        System.out.println(person.gender);
        fileService(person);


    }

    public static void dataInputService(String[] personData, Person person) {
        int count = 0;
        if (personData.length == 6) {
            for (int i = 0; i < personData.length; i++) {
                if (personData[i].contains(".")) {
                    try {
                        person.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(personData[i]);
                    } catch (ParseException e) {
                        throw new RuntimeException("Некорректный ввод даты");
                    }
                } else if (personData[i].length() == 1) {
                    if (personData[i].equals("m") || personData[i].equals("f")) {
                        person.gender = personData[i].charAt(0);
                    } else throw new RuntimeException("Введите свой пол в формате m или f!");
                } else {
                    try {
                        person.phone = Long.parseLong(personData[i]);
                    } catch (NumberFormatException e) {
                        //throw new RuntimeException("Некорректный ввод номера телефона");
                        while (count < 3) {
                            person.name[count] = personData[i + count];
                            count++;
                        }
                    }
                }
            }
        } else throw new RuntimeException("Введено меньше и больше данных, чем требуется");
    }

    public static void fileService(Person person) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(person.birthDate);
        try {
            File file = new File(person.name[0] + ".txt");
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(person.name[0] + ".txt", false);
                fileWriter.write(
                        "<" + person.name[0] + ">" +
                                "<" + person.name[1] + ">" +
                                "<" + person.name[2] + ">" +
                                "<" + strDate + ">" +
                                "<" + person.phone + ">" +
                                "<" + person.gender + ">");
                fileWriter.close();
            } else {
                FileWriter fileWriter = new FileWriter(person.name[0] + ".txt", true);
//                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                bufferedWriter.append(
                fileWriter.write("\n" +
                        "<" + person.name[0] + ">" +
                                "<" + person.name[1] + ">" +
                                "<" + person.name[2] + ">" +
                                "<" + strDate + ">" +
                                "<" + person.phone + ">" +
                                "<" + person.gender + ">");
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }
    }
}
