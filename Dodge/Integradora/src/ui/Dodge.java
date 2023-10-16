package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import model.Task;

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
        
              try {
            Task taskToModify = dodge.search(taskToModify.getId());
            if (taskToModify == null) {
                System.out.println("La tarea con ID " + taskToModify.getId() + " no existe."); 
            }

<<<<<<< HEAD
        System.out.println("To modify the task, we need to delete the task.");
        deleteTask();
        addTask();
=======
            
            Task copy = new Task(taskToModify);
            System.out.println("¿Qué deseas modificar? \n1.Label \n2.Overview \n3.Date \n4.Priority" );
            int val = sc.nextInt();
            System.out.println("Escribe la modificaciona realizar: ");
            String modify = "";
            
            
            switch (val) {
                case 1: // "title"
                    modify = sc.nextLine();
                  sc.nextLine();
                    taskToModify.setLabel(modify);
                    break;
                case 2: // "description"
                modify = sc.nextLine();
                    taskToModify.setOverview(modify);
                    break;
                case 3: // "deadLine"
                modify = sc.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date parsedDate = dateFormat.parse(modify);
                    Calendar dateTaskModify = new GregorianCalendar();
                    dateTaskModify.setTime(parsedDate);
                    taskToModify.setDeadline(dateTaskModify);
                    break;
                case 4: // "priority"
                modify = sc.nextLine();
                    taskToModify.setPriority(Integer.parseInt(modify));
                    break;
                    default:
                    System.out.println("Accion no válida");
                    break;
            }
>>>>>>> 943b12c47866fbc36b1b27ed34a43c45ab85d2e9

            
            dodge.userAction(2, copy);
            System.out.println("Se modificó correctamente.");;

        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha.");;
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
