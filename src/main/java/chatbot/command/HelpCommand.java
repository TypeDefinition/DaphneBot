package chatbot.command;

import chatbot.sfx.Sfx;
import chatbot.task.TaskList;

public class HelpCommand extends Command {
    public static final String TRIGGER = "help";
    public static final String FORMAT = TRIGGER;

    public HelpCommand() {
        super(TRIGGER);
    }

    @Override
    public CommandOutput execute(String[] input, TaskList taskList) {
        validateTrigger(input);

        if (input.length > 1) {
            return new CommandOutput("Error: Invalid arguments\nCommand format: " + FORMAT, Sfx.SFX_ERROR_INVALID_ARGS);
        }

        String output = "Commands (Case Sensitive):\n";
        output += HelpCommand.TRIGGER + ": list commands\n";

        output += ToDoCommand.TRIGGER + ": add to-do\n";
        output += DeadlineCommand.TRIGGER + ": add deadline\n";
        output += EventCommand.TRIGGER + ": add event\n";

        output += MarkCommand.TRIGGER + ": mark task as done\n";
        output += UnmarkCommand.TRIGGER + ": mark task as not done\n";

        output += ListCommand.TRIGGER + ": list current tasks\n";
        output += FindCommand.TRIGGER + ": find task via keyword search\n";
        output += DeleteCommand.TRIGGER + ": delete task\n";
        output += ResetCommand.TRIGGER + ": clear task list\n";

        output += UwuCommand.TRIGGER + ": UwU\n";
        output += OwoCommand.TRIGGER + ": OwO\n";

        output += TerminateCommand.TRIGGER + ": terminate program";

        return new CommandOutput(output, Sfx.SFX_COMMAND_HELP);
    }
}
