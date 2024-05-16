package command;

import application.MainFrame;
import model.workspace.nodes.RuNode;
import model.workspace.nodes.RuNodeComposite;

import javax.swing.*;

public class RemoveConcreteCommand extends AbstractCommand{

    private RuNode selectedRuNode;
    private RuNode ruNode;

    public RemoveConcreteCommand(RuNode selectedRuNode, RuNode ruNode){
        this.selectedRuNode = selectedRuNode;
        this.ruNode = ruNode;
    }

    @Override
    public void doCommand() {
        ((RuNodeComposite)this.ruNode).removeChild(selectedRuNode);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        ((RuNodeComposite) this.ruNode).getChildren().size();
    }

    @Override
    public void undoCommand() {
        ((RuNodeComposite)this.ruNode).addChild(selectedRuNode);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        ((RuNodeComposite) this.ruNode).getChildren().size();
    }


    @Override
    public String toString() {
        return "RemoveConcreteCommand{" +
                "selectedRuNode=" + selectedRuNode +
                ", ruNode=" + ruNode +
                '}';
    }
}
