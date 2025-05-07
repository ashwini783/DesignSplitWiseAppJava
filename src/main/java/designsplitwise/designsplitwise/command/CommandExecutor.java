package designsplitwise.designsplitwise.command;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class CommandExecutor {
    private List<Command>commands;

    public CommandExecutor(List<Command> commands) {
        this.commands=new ArrayList<>(commands);
        commands.add(new SettleUpGroupCommand());
    }
    public void add(Command command) {
        commands.add(command);
    }
    public void remove(Command command) {
        commands.remove(command);
    }
    public List<Command>getCommands() {
        return commands;
    }
    public void execute(String input) {
        for(Command command : commands) {
            if(command.matches(input)) {
                command.execute(input);
            }
        }
    }
}
