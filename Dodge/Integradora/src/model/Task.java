package model;

import java.util.Calendar;

public class Task {
    private String summary;
    private String id;
    private Calendar deadline;
    private int priority;
    private String title;

    public Task(String summary, String id, Calendar deadline, int priority, String title) {
        this.summary = summary;
        this.id = id;
        this.deadline = deadline;
        this.priority = priority;
        this.title = title;
    }

    public Task(Task taskToCopy){
        this.summary = taskToCopy.getSummary();
        this.id = taskToCopy.getId();
        this.deadline = taskToCopy.getDeadline();
        this.priority = taskToCopy.getPriority();
        this.title = taskToCopy.getTitle();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
