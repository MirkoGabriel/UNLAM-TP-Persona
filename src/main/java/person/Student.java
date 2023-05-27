/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public class Student extends Person {

    public static final String DELIM = "\t";
    private MyCalendar admissionDate;
    
    private int approvedSubjectQuantity;
    
    private double average;
    
    private boolean active = true;
    
    public static final int MAX_CANT_MAT_APROB = 50;

    public Student() {
        super();
    }

    public Student(MyCalendar admissionDate, int approvedSubjectQuantity, double average, char gender, int dni,
                   String name, String surname, MyCalendar birthday)
            throws PersonNameException, StudentException, PersonDniException {
        super(dni, name, surname, birthday, gender);
        this.admissionDate = admissionDate;
        setApprovedSubjectQuantity(approvedSubjectQuantity);
        setAverage(average);
    }
    
    

    public MyCalendar getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(MyCalendar admissionDate) {
        this.admissionDate = admissionDate;
    }

    public int getApprovedSubjectQuantity() {
        return approvedSubjectQuantity;
    }

    public void setApprovedSubjectQuantity(int approvedSubjectQuantity) throws StudentException {
        if (approvedSubjectQuantity < 0 || approvedSubjectQuantity > MAX_CANT_MAT_APROB) {
            throw new StudentException("The approved subjects quantity is wrong. Values must be between 0 and 50");
        }
        this.approvedSubjectQuantity = approvedSubjectQuantity;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) throws StudentException {
        if(average < 0 || average > 10|| String.valueOf(average).length() > 5) {
            throw new StudentException("Subjects averge its wrong");
        }
        this.average = average;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return super.toString() +
                admissionDate + DELIM +
                StringUtils.leftPad(String.valueOf(approvedSubjectQuantity), 2,'0') + DELIM +
                StringUtils.center(String.valueOf(average),5,'0') + DELIM +
                (active ? 'A' : 'B');
    }
}
