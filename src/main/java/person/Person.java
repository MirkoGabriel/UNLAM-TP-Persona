/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import org.apache.commons.lang3.StringUtils;

/**
 * @author g.guzman
 */
public abstract class Person {

    private static final String DELIM = "\t";
    private static final int MAX_NAME_LENGTH = 15;

    private int dni;

    private String name;

    private String surname;

    private MyCalendar birthday; // 40/04/2023 ==> 10/05/2023

    private char gender;


    public Person() {
    }

    public Person(int dni) throws PersonDniException {
        setDni(dni);
    }

    public Person(int dni, String name, String surname, MyCalendar birthday, char gender)
            throws PersonNameException, PersonDniException {
        setDni(dni);
        setName(name);
        setSurname(surname);
        this.birthday = birthday;
        setGender(gender);
    }

    public int getDni() {
        return dni;
    }

    public void setDni(final int dni) throws PersonDniException {
        if (dni <= 0 || String.valueOf(dni).length() > 8) {
            throw new PersonDniException("DNI (" + dni + ") should be positive and the long should be less that 8");
        }
        this.dni = dni;
    }

    public String getName() {
        return name == null ? null : name.trim();
    }

    public void setName(String name) throws PersonNameException {
        if (StringUtils.isBlank(name)) {
            throw new PersonNameException("Name cannot empty");
        }
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws PersonNameException {
        if (StringUtils.isBlank(name)) {
            throw new PersonNameException("Surname connot be empty");
        }
        this.surname = surname.trim();
    }

    public MyCalendar getBirthday() {
        return birthday;
    }

    public void setBirthday(MyCalendar birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) throws PersonNameException {
        if (gender != 'M' && gender != 'F') {
            throw new PersonNameException("Gender value its wrong. Allowed fields: (M, F)");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        String truncateName = this.name.length() > MAX_NAME_LENGTH ?
                this.name.substring(0, MAX_NAME_LENGTH) :
                this.name;

        String truncateSurname = this.surname.length() > MAX_NAME_LENGTH ?
                this.surname.substring(0, MAX_NAME_LENGTH) :
                this.surname;

        return StringUtils.leftPad(String.valueOf(dni), 8, '0') + DELIM +
                StringUtils.rightPad(truncateName, 15, StringUtils.SPACE) + DELIM +
                StringUtils.rightPad(truncateSurname, 15, StringUtils.SPACE) + DELIM +
                gender + DELIM +
                birthday + DELIM;
    }


}
