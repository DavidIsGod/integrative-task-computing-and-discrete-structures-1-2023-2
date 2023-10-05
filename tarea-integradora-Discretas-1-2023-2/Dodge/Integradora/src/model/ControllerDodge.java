package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllerDodge {

    private TaskHashTable taskHashTable;

    public ControllerDodge() {
        taskHashTable = new TaskHashTable();
    }

    public Calendar creatCalendar(int day, int month, int year) {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar;
    }

    public boolean addTask(int id, String title, String summary, Calendar deadline, int priority) {
        boolean flag = false;
        Task task = new Task(summary, id, deadline, priority, title);
        taskHashTable.addTask(id, task);
        return flag;
    }
}
