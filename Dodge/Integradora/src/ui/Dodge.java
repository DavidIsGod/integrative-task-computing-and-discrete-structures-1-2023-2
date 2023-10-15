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
                    "7.\tNotification settings.\r\n" +
                    "8.\tExit the system.");

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
        int id = sc.nextInt();
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

    private void modifyTask() {
        // Implementa la lógica para modificar una tarea
    }

    private void deleteTask() {
        // Implementa la lógica para eliminar una tarea
    }

    private void showAllTask() {
        // Implementa la lógica para mostrar todas las tareas
    }

    private void showTaskforPriority() {
        // Implementa la lógica para mostrar tareas por prioridad
    }

    private void undoLastAction() {
        // Implementa la lógica para deshacer la última acción
    }
}
