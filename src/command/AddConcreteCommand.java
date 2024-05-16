package command;

import application.MainFrame;
import model.workspace.nodes.RuNode;
import model.workspace.nodes.RuNodeComposite;

import javax.swing.*;

public class AddConcreteCommand extends AbstractCommand{

    private RuNode selectedRuNode;
    private RuNode ruNode;


    public AddConcreteCommand(RuNode selectedRuNode, RuNode ruNode){
        this.selectedRuNode = selectedRuNode;
        this.ruNode = ruNode;
    }

    @Override
    public void doCommand() {

        if(!((RuNodeComposite)selectedRuNode).getChildren().contains(ruNode)){
            ((RuNodeComposite)selectedRuNode).addChild(ruNode);
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        ((RuNodeComposite)selectedRuNode).removeChild(ruNode);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

    }

    @Override
    public String toString() {
        return "AddConcreteCommand{" +
                "selectedRuNode=" + selectedRuNode +
                ", ruNode=" + ruNode +
                '}';
    }
}
