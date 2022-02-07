package chatbot.command;

import chatbot.sfx.Sfx;
import chatbot.task.TaskList;

public class ResetCommand extends Command {
    public static final String TRIGGER = "reset";
    public static final String FORMAT = TRIGGER;

    public ResetCommand() {
        super(TRIGGER);
    }

    @Override
    public CommandOutput execute(String[] input, TaskList taskList) {
        validateTrigger(input);

        if (input.length > 1) {
            return new CommandOutput("Error: Invalid arguments\nCommand format: " + FORMAT, Sfx.SFX_ERROR_INVALID_ARGS);
        }

        taskList.clear();
        return new CommandOutput("I've removed all your tasks.", Sfx.SFX_COMMAND_RESET);
    }
}
