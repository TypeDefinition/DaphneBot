package chatbot.command;

import chatbot.task.Task;

import java.util.ArrayList;

public interface Command {
    String execute(String[] input, ArrayList<Task> tasks);
}