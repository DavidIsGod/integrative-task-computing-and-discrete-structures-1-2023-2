package ui;

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
        System.out.println("Para agregar una Tarea debes proporcionar la siguiente información: \nEnter the ID:");
        int id = sc.nextInt();
        System.out.println("Choose the priority: 1. Pirority or 2. Non-Priority");
        int priority = sc.nextInt();
        System.out.println("Enter the limit date");
        System.out.println("Enter the day");
        int day = sc.nextInt();
        System.out.println("Enter the month");
        int month = sc.nextInt();
        System.out.println("Enter the year");
        int year = sc.nextInt();
        sc.nextInt();

        sc.nextLine();
        System.out.println("Enter de Title");
        String title = sc.nextLine();
        System.out.println("Enter the information:");
        String summary = sc.nextLine();

        if (dodge.addTask(id, summary, dodge.creatCalendar(day, month, year), priority, title)) {
            System.out.println("Task added successfully");
        } else {
            System.out.println("No se pudo agregar la tarea");
        }
    }

    private void modifyTask() {
    }

    private void deleteTask() {
    }

    private void showAllTask() {
    }

    private void showTaskforPriority() {
    }

    private void undoLastAction() {
    }

}
