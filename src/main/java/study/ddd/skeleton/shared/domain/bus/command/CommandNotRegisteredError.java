package study.ddd.skeleton.shared.domain.bus.command;

public class CommandNotRegisteredError extends Exception {
    public CommandNotRegisteredError(Class<? extends Command> commandClass) {
        super(String.format("The command <%s> hasn't a command handler associated", commandClass.toString()));
    }
}
