package chatbot.command;

import chatbot.sfx.Sfx;
import chatbot.task.TaskList;

public class TerminateCommand extends Command {
    public static final String TRIGGER = "bye";
    public static final String FORMAT = TRIGGER;

    public TerminateCommand() {
        super(TRIGGER);
    }

    @Override
    public CommandOutput execute(String[] input, TaskList taskList) {
        validateTrigger(input);

        if (input.length > 1) {
            return new CommandOutput("Error: Invalid arguments\nCommand format: " + FORMAT, Sfx.SFX_ERROR_INVALID_ARGS);
        }
        return new CommandOutput("Bye bye! I will see you again, won't I?", Sfx.SFX_COMMAND_TERMINATE, true);
    }
}
