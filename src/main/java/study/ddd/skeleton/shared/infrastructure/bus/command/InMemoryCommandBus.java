package study.ddd.skeleton.shared.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.command.Command;
import study.ddd.skeleton.shared.domain.bus.command.CommandBus;
import study.ddd.skeleton.shared.domain.bus.command.CommandHandler;
import study.ddd.skeleton.shared.domain.bus.command.CommandHandlerExecutionError;

@Service
public class InMemoryCommandBus implements CommandBus {

    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try{
            // Obtiene el commandHandler mediante reflexión
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            // Obtenemos una instancia del commandHandler
            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
