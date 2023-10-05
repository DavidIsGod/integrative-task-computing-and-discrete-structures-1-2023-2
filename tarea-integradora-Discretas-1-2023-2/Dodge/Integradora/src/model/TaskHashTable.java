package model;

import java.util.HashMap;

public class TaskHashTable {
    private HashMap<Integer, Task> taskMap;

    public TaskHashTable() {
        taskMap = new HashMap<>();
    }

    public void addTask(int id, Task task) {
        taskMap.put(id, task);
    }

    public Task getTask(int id) {
        return taskMap.get(id);
    }

    public void removeTask(int id) {
        taskMap.remove(id);
    }

}
