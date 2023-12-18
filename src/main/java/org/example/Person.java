package org.example;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonData {
    public String[] name = new String[3];
    public Date birthDate;
    public int phone;
    public char gender;

    public PersonData(String[] name, Date birthDate, int phone, char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }
    public void inputPersonData (String[] name, Date birthDate, int phone, char gender) {
        Scanner n1 = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        if (n1 != null) {
            name[0] = n1.nextLine();
        } else throw new RuntimeException("Вы не ввели фамилию!");
        Scanner n2 = new Scanner(System.in);
        System.out.println("Введите имя: ");
        if (n2 != null) {
            name[1] = n2.nextLine();
        } else throw new RuntimeException("Вы не ввели имя!");
        Scanner n3 = new Scanner(System.in);
        System.out.println("Введите отчество: ");
        if (n3 != null) {
            name[2] = n3.nextLine();
        } else throw new RuntimeException("Вы не ввели отчество!");
        Scanner bd = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате dd.mm.yyyy: ");
        try {
            birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(bd.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException("Некорректный ввод даты");
        }
        Scanner p = new Scanner(System.in);
        System.out.println("Введите номер телефона без пробелов и тире: ");
        try {
            phone = Integer.parseInt(p.nextLine());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Некорректный ввод номера телефона");
        }
        Scanner g = new Scanner(System.in);
        System.out.println("Введите свой пол в формате m или f");
        if (g.nextLine() == "m" || g.nextLine() == "f"){
            gender = g.nextLine().charAt(0);
        }else throw new RuntimeException("Введите свой пол в формате m или f!");
    }
}
