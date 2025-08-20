package controller;

import model.Employee;
import service.AttendanceService;

public class AttendanceController {
    AttendanceService service = new AttendanceService();

    public void addEmployee(Employee e){
        service.addEmployee(e);
    }

    public boolean removeEmployee(int id){
        return service.removeEmployee(id);
    }

    public int getAttendance(int id){
        return service.getAttendance(id);
    }

    public boolean getCheckIn(int id){
        return service.logCheckIn(id);
    }

    public boolean getCheckOut(int id){
        return service.logCheckOut(id);
    }

    public Employee findEmployeeById(int id){
        return service.findEmployeeById(id);
    }
    public void loadFromFile() {
        service.loadFromFile();
    }
    public void saveToFile() {
        service.saveToFile();
    }
    public void clearData() {
        service.clearData();
    }
    public void printAllEmployees() {
        service.printAllEmployees();
    }
    public void printAttendanceRecord() {
        service.printAttendanceRecord();
    }
}
