package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {
    public String[] name = new String[3];
    public Date birthDate;
    public long phone;
    public char gender;

    public Person(String[] name, Date birthDate, int phone, char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }
    public String[] getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public long getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

    public void setName(String[] name) {
        this.name[0] = name[0];
        this.name[1] = name[1];
        this.name[2] = name[2];
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
