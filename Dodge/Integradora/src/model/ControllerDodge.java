package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Exceptions.ListNullException;

public class ControllerDodge {

    private Queue<Task> taskQueue;
    private IPriorityQueue<Integer, Task> taskPriorityQueue = new Heap<>();
    private Stack<Action> userActionsStack;

    private TaskHashTable<String, Task> taskHashTable;

    public ControllerDodge() {
        int size = 97;
        taskHashTable = new TaskHashTable<String, Task>(size);
        taskQueue = new Queue<>();
        userActionsStack = new Stack<>();
    }

    public Calendar creatCalendar(int day, int month, int year) {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar;
    }

    public boolean addTask(String id, String label, String overview, Calendar deadline, int priority) {
        if (id == null || label == null || overview == null || deadline == null) {
            return false;
        }
        Task task = new Task(id, label, overview, deadline, priority);
        if (task == null) {
            return false;
        }
        if (task.getPriority() == 0) {
            taskQueue.enqueue(task);
            taskHashTable.add(id, task);
        } else {
            taskPriorityQueue.add(Integer.valueOf(task.getPriority()), task);
            taskHashTable.add(task.getId(), task);
        }
        userAction(0, task);
        return true;
    }

    public Task search(String Id) {

        return taskHashTable.search(Id);
    }

    public boolean deleteTask(String Id) {
        boolean result = false;
        Task task = taskHashTable.search(Id);
        if (task != null) {
            taskHashTable.delete(Id);
            if (task.getPriority() == 0) {
                taskQueue.delete(task);
            } else {
                taskPriorityQueue.delete(task);
            }
            userAction(1, task);
            result = true;
        }
        return result;
    }

    public String modify(String modify, String Id, int modifyAction) {
        Task taskToModify = taskHashTable.search(Id);
        Task copy = new Task(taskToModify);
        switch (modifyAction) {
            case 1:// "title":
                taskToModify.setLabel(modify);
                break;
            case 2:// "description":
                taskToModify.setOverview(modify);
                break;
            case 3:// "deadLine":

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;
                try {
                    date = sdf.parse(modify);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                taskToModify.setDeadline(calendar);
                break;
            case 4:// "priority":
                taskToModify.setPriority(Integer.parseInt(modify));
                break;
            default:
                break;
        }
        userAction(2, copy);
        return "Correctly modified";
    }

    public void userAction(int action, Task agenda) {
        Action userAction = new Action(ActionType.values()[action], agenda);
        userActionsStack.push(userAction);
    }

    public void undone() {
        Action userAction = userActionsStack.pop();
        switch (userAction.getAction()) {
            case ADD:
                deleteTask(userAction.getTask().getId());
                break;
            case DELETE:
                addTask(userAction.getTask().getId(), userAction.getTask().getLabel(),
                        userAction.getTask().getOverview(), userAction.getTask().getDeadline(),
                        userAction.getTask().getPriority());
                break;
            case MODIFY:
                deleteTask(userAction.getTask().getId());
                addTask(userAction.getTask().getId(), userAction.getTask().getLabel(),
                        userAction.getTask().getOverview(), userAction.getTask().getDeadline(),
                        userAction.getTask().getPriority());
                break;
        }

    }

    public String showAllTaskPriority() {
        String msg = "";
        if (((Heap<Integer, Task>) taskPriorityQueue).getSize() == 0) {
            msg += "The task queue by priority is empty.";
        } else {
            msg += "Task queue content by priority:\n" + ((Heap<Integer, Task>) taskPriorityQueue).print() + "\n";
        }
        return msg;
    }

    public String showAllTask() {
        String msg = "";
        if (taskQueue.isEmpty()) {
            msg += "The task queue by priority is empty. \n";
        } else {
            msg += "TaskQueue content:\n" + taskQueue.print() + "\n";
        }

        if (((Heap<Integer, Task>) taskPriorityQueue).getSize() == 0) {
            msg += "The task queue by priority is empty.";
        } else {
            msg += "Task queue content by priority:\n" + ((Heap<Integer, Task>) taskPriorityQueue).print();
        }
        return msg;
    }

}