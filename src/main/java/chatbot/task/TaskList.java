package chatbot.task;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task remove(int index) {
        return tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public void clear() {
        tasks.clear();
    }
}