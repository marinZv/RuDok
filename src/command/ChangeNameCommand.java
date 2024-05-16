package command;

import application.MainFrame;
import model.workspace.nodes.RuNode;

import javax.swing.*;

public class ChangeNameCommand extends AbstractCommand{

    private RuNode ruNode;
    private String oldName;
    private String newName;

    public ChangeNameCommand(RuNode ruNode, String newName){
        this.ruNode = ruNode;
        this.oldName = ruNode.getName();
        this.newName = newName;
    }

    @Override
    public void doCommand() {
        this.ruNode.setName(newName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        this.ruNode.setName(oldName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
