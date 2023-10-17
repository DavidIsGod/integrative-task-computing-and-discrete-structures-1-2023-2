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

            int value = Integer.parseInt(sc.nextLine());

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
        System.out.println("Enter the Title:");
        String label = sc.nextLine();
        System.out.println("Enter the information:");
        String overview = sc.nextLine();
        System.out.println("Enter the limit date");
        System.out.println("Enter the day");
        int day = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the month");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the year");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("Choose the priority: 1. Priority or 2. Non-Priority");
        int priorityKU = Integer.parseInt(sc.nextLine());

        Calendar deadline = dodge.creatCalendar(day, month, year);

        if (priorityKU == 2) {
            int priority = 0;

            if (dodge.addTask(id, label, overview, deadline, priority)) {
                System.out.println("Task added successfully");
            } else {
                System.out.println("The task could not be added");
            }
        } else if (priorityKU > 0) {
            System.out.println("Choose the priority in a range of [1, 10]");
            int priority = Integer.parseInt(sc.nextLine());

            if (dodge.addTask(id, label, overview, deadline, priority)) {
                System.out.println("Task added successfully");
            } else {
                System.out.println("The task could not be added");
            }
        }

    }

    private void modifyTask() {
        System.out.println("To modify a Task you must provide the following information:");
        System.out.println("Enter the ID:");
        String id = sc.nextLine();
        System.out.println("What do you want to modify? \n1.Label \n2.Overview \n3.Date \n4.Priority" );
        int val = Integer.parseInt(sc.nextLine());
        System.out.println("Write the modification you wish to perform: ");
        String modify = "";
        switch (val) {
            case 1: // "title"
                modify = sc.nextLine();
                break;
            case 2: // "description"
                modify = sc.nextLine();
                break;
            case 3: // "deadLine"
                modify = sc.nextLine();
                break;
            case 4: // "priority"
                modify = sc.nextLine();
                break;
            default:
                System.out.println("Invalid action");
                break;
        }
        dodge.modify(modify, id, val);
        System.out.println("It was correctly modified.");

    }
    private void deleteTask() {
        System.out.println("To delete a Task you must provide the following information:");
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
        dodge.undone();
    }
}