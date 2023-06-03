/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author g.guzman
 */
public class MyCalendar extends GregorianCalendar {

    public MyCalendar(int day, int month, int year) throws MyCalendarException {
        super(year, month-1, day);
        
        setLenient(false); // evitar la permisividad
        
        try {
            get(Calendar.MONTH);
        }
        catch (IllegalArgumentException ex) {
            throw new MyCalendarException("Wrong date ("+ex.getMessage()+")");
        }
    }

    public int getDay() {
        return get(DAY_OF_MONTH);
    }
            
    public int getMonth() {
        return get(MONTH)+1;
    }
    
    public int getYear() {
        return get(YEAR);
    }
    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", getDay(), getMonth(), getYear());
    }

    public Date toSqlDate(){
        return new Date(this.getTimeInMillis());
    }
    
}
