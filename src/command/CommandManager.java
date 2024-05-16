package command;

import application.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommand> commands;
    private int currentCommand;

    public CommandManager(){
        commands = new ArrayList<>();
        currentCommand = 0;
    }

    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size()){
            commands.remove(currentCommand);
        }
        commands.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < commands.size()){
            //currentCommand++;
            commands.get(currentCommand++).doCommand();
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);

            //System.out.println(commands.get(currentCommand));
            //System.out.println(currentCommand);
        }
        if(currentCommand == commands.size()){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }

    }

    public void undoCommand(){
        if(currentCommand > 0){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
            //currentCommand--;
            commands.get(--currentCommand).undoCommand();

            //System.out.println(commands.get(currentCommand));
            //System.out.println(currentCommand);

        }
        if(currentCommand == 0){
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
        }

    }

}
