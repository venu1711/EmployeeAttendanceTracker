package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Attendance implements Recordable{
    private int employeeID;
    private String employeeName;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    Attendance(int employeeID,String employeeName,LocalDateTime checkIn,LocalDateTime checkOut){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getEmployeeID(){ return employeeID;}
    public String getEmployeeName(){ return employeeName;}
    public LocalDateTime getCheckInTime(){ return checkIn;}
    public LocalDateTime getCheckOutTime(){ return checkOut;}

    public Duration getDuration(){
        if(checkIn!=null && checkOut!=null){
            return Duration.between(checkIn,checkOut);
        }
        return Duration.ZERO;
    }


    @Override
    public String toFileFormat(){
        return employeeID + "|" + employeeName + "|" + checkIn + "|" + checkOut;
    }

    @Override
    public String toString(){
        return "ID: " + employeeID + ", Name: " + employeeName +
                ", Check In Time: " + checkIn + ", Check Out Time: " + checkOut +
                ", Duration: " + getDuration().toHours() + "hrs";
    }
}
