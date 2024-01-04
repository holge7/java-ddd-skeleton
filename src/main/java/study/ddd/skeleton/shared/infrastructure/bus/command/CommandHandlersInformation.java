package study.ddd.skeleton.shared.infrastructure.bus.command;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.command.Command;
import study.ddd.skeleton.shared.domain.bus.command.CommandHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;
import study.ddd.skeleton.shared.domain.bus.command.CommandNotRegisteredError;

@Service
public final class CommandHandlersInformation {

    HashMap<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;

    public CommandHandlersInformation() {
        Reflections reflections = new Reflections("study.ddd.skeleton");

        // Obtenemos las subclases de CommandHandler
        Set<Class<? extends CommandHandler>> classes = reflections.getSubTypesOf(CommandHandler.class);

        indexedCommandHandlers = formatHandlers(classes);
    }

    public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (commandHandlerClass == null) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return  commandHandlerClass;
    }

    private HashMap<Class<? extends Command>, Class<? extends CommandHandler>> formatHandlers(
            Set<Class<? extends CommandHandler>> commandHandlers
    ) {
        HashMap<Class<? extends Command>, Class<? extends CommandHandler>> handlers = new HashMap<>();

        // Por cada subclase de commandHandler
        for (Class<? extends CommandHandler> handler : commandHandlers) {
            // Obtener las interfaces genéricas implementadas por la clase
            Type[] genericInterfaces = handler.getGenericInterfaces();

            // Obtener el primer elemento del array de interfaces genéricas
            Type firstInterface = genericInterfaces[0];

            // Convertirlo a ParameterizedType (que permite obtener información sobre los argumentos de tipo)
            ParameterizedType paramType = (ParameterizedType) firstInterface;

            // Obtener el primer argumento de tipo, que es el tipo de Command asociado
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }

}