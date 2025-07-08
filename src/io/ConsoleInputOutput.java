package io;

import controller.AttendanceController;
import model.Employee;

import java.util.Scanner;

public class ConsoleInputOutput {
    AttendanceController controller = new AttendanceController();
    private final String admin_login = "admin";
    private final String admin_pass = "admin123";
    Scanner sc = new Scanner(System.in);

    public void start(){
        while(true){
            System.out.println("1. Admin");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            switch (choice){
                case 1 -> adminLogin();
                case 2 -> employeePrivileges();
                case 3 -> {
                    System.out.println("Bye");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void employeePrivileges(){
        while(true){
            System.out.println("1. Add employee");
            System.out.println("2. Remove employee");
            System.out.println("3. Get employee attendance");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1 -> addEmployee();
                case 2 -> removeEmployee();
                case 3 -> getAttendance();
                case 4 ->{
                    System.out.println("Bye");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void adminPrivileges(){
        while(true){
            System.out.println("1. Check in");
            System.out.println("2. Check Out");
            System.out.println("3. Get employee attendance");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1 -> checkIn();
                case 2 -> checkOut();
                case 3 -> getAttendance();
                case 4 ->{
                    System.out.println("Bye");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void adminLogin(){
        System.out.print("Enter username: ");
        String user = sc.next();
        sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        if(user.equals(admin_login) && pass.equals(admin_pass)){
            adminPrivileges();
        }else{
            System.out.println("Invalid credentials");
        }
    }

    public void addEmployee(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        controller.addEmployee(new Employee(id,name));
        System.out.println("Added member");
    }

    public void removeEmployee(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        boolean cond = controller.removeEmployee(id);
        if(cond) System.out.println("Removed employee");
        else System.out.println("Error!!");
    }

    public void getAttendance(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.println(controller.getAttendance(id));
    }

    public void checkIn(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        controller.getCheckIn(id);
        System.out.println("Employee Checked In");
    }

    public void checkOut(){
        System.out.print("Enter ID:" );
        int id = sc.nextInt();
        controller.getCheckOut(id);
        System.out.println("Employee Checked Out");
    }
}
