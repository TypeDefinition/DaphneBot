package chatbot.command;

import chatbot.sfx.Sfx;
import chatbot.task.Task;
import chatbot.task.TaskList;

public class UnmarkCommand extends Command {
    public static final String TRIGGER = "unmark";
    public static final String FORMAT = TRIGGER + " <index>\n" + "Index range: 1 to <size of list>";

    public UnmarkCommand() {
        super(TRIGGER);
    }

    @Override
    public CommandOutput execute(String[] input, TaskList taskList) {
        validateTrigger(input);

        try {
            int index = Integer.parseInt(input[1]);
            Task task = taskList.get(index - 1);
            task.setDone(false);
            return new CommandOutput(String.format("Okay, I've marked this task as not yet done:\n  %s", task),
                Sfx.SFX_COMMAND_UNMARK);
        } catch (Exception e) {
            return new CommandOutput("Error: Invalid index\nCommand format: " + FORMAT, Sfx.SFX_ERROR_INVALID_INDEX);
        }
    }
}
