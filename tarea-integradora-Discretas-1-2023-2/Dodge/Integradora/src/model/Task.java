package model;

import java.util.Calendar;

public class Task {
    private String summary;
    private int id;
    private Calendar deadline;
    private int priority;
    private String title;

    public Task(String summary, int id, Calendar deadline, int priority, String title) {
        this.summary = summary;
        this.id = id;
        this.deadline = deadline;
        this.priority = priority;
        this.title = title;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
