package chatbot.command;

import chatbot.sfx.Sfx;
import chatbot.task.TaskList;

public class ListCommand extends Command {
    public static final String TRIGGER = "list";
    public static final String FORMAT = TRIGGER;

    public ListCommand() {
        super(TRIGGER);
    }

    @Override
    public CommandOutput execute(String[] input, TaskList taskList) {
        validateTrigger(input);

        if (input.length > 1) {
            return new CommandOutput("Error: Invalid arguments\nCommand format: " + FORMAT, Sfx.SFX_ERROR_INVALID_ARGS);
        }

        if (taskList.isEmpty()) {
            return new CommandOutput("You have no tasks.", Sfx.SFX_COMMAND_LIST_NONE);
        }

        StringBuilder output = new StringBuilder("Here are your tasks:\n");
        for (int i = 0; i < taskList.size(); ++i) {
            output.append(
                String.format("%d. %s%s", i + 1, taskList.get(i).toString(), i < taskList.size() - 1 ? "\n" : ""));
        }
        return new CommandOutput(output.toString(), Sfx.SFX_COMMAND_LIST);
    }
}
