package service;

import model.Attendance;
import model.Employee;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AttendanceService {
    private static List<Employee> employees = new ArrayList<>();
    private static List<Attendance> attendanceRecord = new ArrayList<>();
    private final String fileName = "attendance.txt";

    public AttendanceService(){ loadFromFile(); }

    public void addEmployee(Employee e){
        employees.add(e);
        saveToFile();
    }

    public boolean removeEmployee(int id){
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            Employee e =itr.next();
            if(e.getId()== id){
                employees.remove(e);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public int getAttendance(int id){
        int count = 0;
        Iterator<Attendance> itr = attendanceRecord.iterator();
        while(itr.hasNext()){
            Attendance e = itr.next();
            if(e.getEmployeeID() == id) count++;
        }
        return count;
    }

    public boolean logCheckIn(int id){
        Employee e = findEmployeeById(id);
        if(e!=null){
            attendanceRecord.add(new Attendance(id,e.getName(),LocalDateTime.now(),null));
            return true;
        }
        return false;
    }

    public boolean logCheckOut(int id){
        for(Attendance a : attendanceRecord){
            if(a.getEmployeeID()==id && a.getCheckOutTime()==null){
                a.setCheckOut(LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    public Employee findEmployeeById(int id){
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            Employee e =itr.next();
            if(e.getId()== id){
                return e;
            }
        }
        return null;
    }

    private void loadFromFile() {
        File f = new File(fileName);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    LocalDateTime in = LocalDateTime.parse(parts[2]);
                    LocalDateTime out = parts[3].equals("null") ? null : LocalDateTime.parse(parts[3]);
                    attendanceRecord.add(new Attendance(id, name, in, out));
                    if (findEmployeeById(id) == null) employees.add(new Employee(id, name));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }

    public void saveToFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Attendance a : attendanceRecord) {
                bw.write(a.toFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save to file.");
        }
    }
}
