package model;

public class Action {
    private ActionType action;
    private Task task;


    public Action(ActionType action, Task task) {
        this.action = action;
        this.task = task;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
