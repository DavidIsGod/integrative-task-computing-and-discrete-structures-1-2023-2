package model;

import java.util.Calendar;
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
            taskHashTable.insert(id, task);
        } else {
            taskPriorityQueue.insert(task.getPriority(), task);
            taskHashTable.insert(task.getId(),task);
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

    public String modify(String modify, String Id, int modifyAction) {
        Task taskToModify = taskHashTable.search(Id);
        Task copy = new Task(taskToModify);
        switch (modifyAction) {
            case 1://"title":
                taskToModify.setTitle(modify);

                break;
            case 2://"description":
                taskToModify.setSummary(modify);

                break;
            case 3://"deadLine":
                //Manejo de fechas 
                //taskToModify.setDeadline(modify);


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
                addTask(userAction.getTask().getId(), userAction.getTask().getTitle(), userAction.getTask().getSummary(), userAction.getTask().getDeadline(), userAction.getTask().getPriority());
                break;
            case MODIFY:
                deleteTask(userAction.getTask().getId());
                addTask(userAction.getTask().getId(), userAction.getTask().getTitle(), userAction.getTask().getSummary(), userAction.getTask().getDeadline(), userAction.getTask().getPriority());
                break;
        }


    }
}
