package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllerDodge {

    private TaskHashTable taskHashTable;

    public ControllerDodge() {
        taskHashTable = new TaskHashTable();
    }

    public Calendar creatCalendar(int day, int month, int year) {
        Calendar calendar = new GregorianCalendar(day, month, year);
        return calendar;
    }

    public boolean addTask(int id, String summary, Calendar deadline, int priority, String title) {
        boolean flag = false;
        Task task = new Task(summary, id, deadline, priority, title);
        taskHashTable.addTask(id, task);
        return flag;
    }

}
