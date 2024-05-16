package action;

import application.MainFrame;
import command.RemoveConcreteCommand;
import errors.ErrorFactory;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveAction extends AbstractRudokAction {

    public RemoveAction(){
        putValue(NAME, "Remove");
        putValue(SMALL_ICON, loadIcon("remove.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode ruNode = null;

        if(MainFrame.getInstance().getMyTree().getLastSelectedPathComponent() == null){
           // RuError error = MainFrame.getInstance().getErrorFactory().createErrorMessage(RuErrorType.ns_delete);
            //error.showMessageError();
            ErrorFactory.getInstance().generateError("Nemoguce uklananje, Cvor nije selektovan!");
        }else{
            ruNode = ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();
        }

        if(ruNode instanceof Workspace){
            //RuError error = MainFrame.getInstance().getErrorFactory().createErrorMessage(RuErrorType.ws_delete);
            //error.showMessageError();
            return;
        }

        if(ruNode instanceof Project){
            Project project = (Project)ruNode;
            Workspace workspace = (Workspace) project.getParent();
            workspace.removeChild(project);
            MainFrame.getInstance().clearTabbedPane();

            workspace.setChanged(true);

            //project.setChanged(true);

        }

        if(ruNode instanceof Presentation){
            Presentation presentation = (Presentation) ruNode;
            Project project = (Project) presentation.getParent();
            int index = project.getChildren().indexOf(presentation);
            project.removeChild(presentation);

            if(MainFrame.getInstance().getMyTabbedPane().getTabCount() > 0){
                MainFrame.getInstance().getMyTabbedPane().remove(index);
            }

            presentation.setChanged(true);
        }

        if(ruNode instanceof Slide){
            Slide slide = (Slide)ruNode;
            Presentation presentation = (Presentation) slide.getParent();
            presentation.removeChild(slide);

        }

        MainFrame.getInstance().getCommandManager().addCommand(new RemoveConcreteCommand(ruNode, ruNode.getParent()));

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
