package ui;

import java.util.Calendar;

import java.util.Scanner;

import model.ControllerDodge;

public class Dodge {

    private Scanner sc;
    private ControllerDodge dodge;

    public Dodge() {
        sc = new Scanner(System.in);
        dodge = new ControllerDodge();
    }

    public static void main(String[] args) {
        Dodge exe = new Dodge();
        exe.menu();
    }

    public void menu() {
        System.out.println("/----------Always_Note----------/");
        boolean flag = false;
        while (!flag) {
            System.out.println("1.\tAdd a new task.\r\n" +
                    "2.\tModify an existing task.\r\n" +
                    "3.\tDelete a task.\r\n" +
                    "4.\tView the list of tasks and reminders.\r\n" +
                    "5.\tFilter tasks by priority.\r\n" +
                    "6.\tUndo the last action.\r\n" +
                    "7.\tExit the system.");

            int value = sc.nextInt();

            switch (value) {
                case 1:
                    addTask();
                    break;
                case 2:
                    modifyTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    showAllTask();
                    break;
                case 5:
                    showTaskforPriority();
                    break;
                case 6:
                    undoLastAction();
                    break;
                case 7:
                    System.exit(value);
                default:
                    break;
            }
        }
    }

    private void addTask() {
        System.out.println("Para agregar una Tarea debes proporcionar la siguiente información:");
        System.out.println("Enter the ID:");
        String id = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the Title:");
        String label = sc.nextLine();
        System.out.println("Enter the information:");
        String overview = sc.nextLine();
        System.out.println("Enter the limit date");
        System.out.println("Enter the day");
        int day = sc.nextInt();
        System.out.println("Enter the month");
        int month = sc.nextInt();
        System.out.println("Enter the year");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Choose the priority: 1. Priority or 2. Non-Priority");
        int priorityKU = sc.nextInt();

        Calendar deadline = dodge.creatCalendar(day, month, year);

        if (priorityKU == 2) {
            int priority = 0;

            if (dodge.addTask(id, label, overview, deadline, priority)) {
                System.out.println("Task added successfully");
            } else {
                System.out.println("No se pudo agregar la tarea");
            }
        } else if (priorityKU > 0) {
            System.out.println("Choose the priority in a range of [1, 10]");
            int priority = sc.nextInt();

            if (dodge.addTask(id, label, overview, deadline, priority)) {
                System.out.println("Task added successfully");
            } else {
                System.out.println("No se pudo agregar la tarea");
            }
        }

    }

    private void modifyTask() {
        System.out.println("Para modificar una Tarea debes proporcionar la siguiente información:");
        System.out.println("Enter the ID:");
        String id = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the Title:");
        String label = sc.nextLine();
        System.out.println("Enter the information:");
        String overview = sc.nextLine();
        System.out.println("Enter the limit date");
        System.out.println("Enter the day");
        int day = sc.nextInt();
        System.out.println("Enter the month");
        int month = sc.nextInt();
        System.out.println("Enter the year");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Choose the priority: 1. Priority or 2. Non-Priority");
        int priority = sc.nextInt();

        Calendar deadline = dodge.creatCalendar(day, month, year);

        if (dodge.addTask(id, label, overview, deadline, priority)) {
            System.out.println("Task added successfully");
        } else {
            System.out.println("No se pudo agregar la tarea");
        }
    }

    private void deleteTask() {
        System.out.println("Para eliminar una Tarea debes proporcionar la siguiente información:");
        System.out.println("Enter the ID:");
        String id = sc.nextLine();
        sc.nextLine();
        if (dodge.deleteTask(id)) {
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Cant delete the task");
        }
    }

    private void showAllTask() {

        System.out.println("This is the list of all the tasks registered so far:");
        System.out.println(dodge.showAllTask());
    }

    private void showTaskforPriority() {
        System.out.println("This is the list of all tasks by priority");
        System.out.println(dodge.showAllTaskPriority());
    }

    private void undoLastAction() {
        // Implementa la lógica para deshacer la última acción
    }
}
