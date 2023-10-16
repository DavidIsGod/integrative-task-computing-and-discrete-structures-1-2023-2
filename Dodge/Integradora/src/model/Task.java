package model;

import java.util.Calendar;

public class Task {

    private String id;
    private String label;
    private String overview;
    private Calendar deadline;
    private int priority;

    public Task(String id, String label, String overview, Calendar deadline, int priority) {
        this.id = id;
        this.label = label;
        this.overview = overview;
        this.deadline = deadline;
        this.priority = priority;
    }

    public Task(Task taskToCopy) {
        this.overview = taskToCopy.getOverview();
        this.id = taskToCopy.getId();
        this.deadline = taskToCopy.getDeadline();
        this.priority = taskToCopy.getPriority();
        this.label = taskToCopy.getLabel();
    }

    public void setDeadline(Calendar date) {
        this.deadline = date;
    }

    public Calendar getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "Title: " + label + "\n";
    }
}
