package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ControllerDodge {

    private Queue <Task> taskQueue;
    private IPriorityQueue<Integer, Task> taskPriorityQueue  = new Heap<>();
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

    public boolean addTask(String id, String title, String summary, Calendar deadline, int priority) {
        Task task = new Task(summary, id, deadline, priority, title);

        if (task.getPriority() == 0) {
            taskQueue.enqueue(task);
            taskHashTable.add(id, task);
        } else {
            taskPriorityQueue.add(Integer.valueOf(task.getPriority()), task);
            taskHashTable.add(task.getId(),task);
        }
        userAction(0, task);
        return true;
    }

    public Task search(String Id) {
        return taskHashTable.search(Id);
    }


    public boolean deleteTask(String Id) {
        Task task = (Task) taskHashTable.search(Id);
        taskHashTable.delete(task.getId());
        if (task.getPriority() == 0) {
            taskQueue.delete(task);
        } else {
            taskPriorityQueue.delete(task);
        }
        userAction(1, task);
        return true;
    }

    public String modify(String modify, String Id, int modifyAction, Calendar date) {
        Task taskToModify = taskHashTable.search(Id);
        Task copy = new Task(taskToModify);
        switch (modifyAction) {
            case 1://"title":
                taskToModify.setLabel(modify);

                break;
            case 2://"description":
                taskToModify.setOverview(modify);

                break;
            case 3://"deadLine":

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = dateFormat.format(date.getTime());
            try {
                Date parsedDate = dateFormat.parse(dateString);
                Calendar dateTaskModify = new GregorianCalendar();
                dateTaskModify.setTime(parsedDate);
                taskToModify.setDeadline(dateTaskModify);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            break;
            case 4://"priority":
                taskToModify.setPriority(Integer.parseInt(modify));
                break;

            default:
                break;
        }
        userAction(2, copy);
        return "Se modifico correctamente";
    }


    public void userAction(int action, Task agenda){
        Action userAction = new Action(ActionType.values()[action],  agenda);
        userActionsStack.push(userAction);
    }

    public void undone(){
        Action userAction = userActionsStack.pop();
        switch (userAction.getAction()){
            case ADD:
                deleteTask(userAction.getTask().getId());
                break;
            case DELETE:
                addTask(userAction.getTask().getId(), userAction.getTask().getLabel(), userAction.getTask().getOverview(), userAction.getTask().getDeadline(), userAction.getTask().getPriority());
                break;
            case MODIFY:
                deleteTask(userAction.getTask().getId());
                addTask(userAction.getTask().getId(), userAction.getTask().getLabel(), userAction.getTask().getOverview(), userAction.getTask().getDeadline(), userAction.getTask().getPriority());
                break;
        }


    }

    public String showAllTask() {
        return taskQueue.print();
    }

  
    public String showAllTaskPriority() {
       String msg = "";
        for (int i = 0; i < taskPriorityQueue.getSize(); i++) {
            ((Heap<Integer,Task>)taskPriorityQueue).print();
        }
        return msg;
    }
}
