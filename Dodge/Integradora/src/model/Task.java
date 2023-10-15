package model;

import java.util.Calendar;

public class Task {
    private String overview;
    private String id;
    private Calendar deadline;
    private int priority;
    private String label;

    public Task(String overview, String id, Calendar deadline, int priority, String label) {
        this.overview = overview;
        this.id = id;
        this.deadline = deadline;
        this.priority = priority;
        this.label = label;
    }

    public Task(Task taskToCopy){
        this.overview = taskToCopy.getOverview();
        this.id = taskToCopy.getId();
        this.deadline = taskToCopy.getDeadline();
        this.priority = taskToCopy.getPriority();
        this.label = taskToCopy.getLabel();
    }

    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
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
}
