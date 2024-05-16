package action;

import application.MainFrame;
import command.AddConcreteCommand;
import errors.ErrorFactory;
import factory.AbstractRuNodeFactory;
import factory.FactoryGenerator;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractRudokAction {


    public NewAction(){
        putValue(NAME, "New");
        putValue(SMALL_ICON, loadIcon("newIcon.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*RuNode ruNode;
        if(MainFrame.getInstance().getMyTree().getLastSelectedPathComponent() == null){
            RuError error = MainFrame.getInstance().getErrorFactory().createErrorMessage(RuErrorType.ns_add);
            error.showMessageError();
            return;
        }else{
            ruNode = ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();
        }

        if(ruNode instanceof Workspace){
            Workspace workspace = (Workspace) ruNode;
            Project project = new Project("Project ", workspace);
            workspace.addChild(project);
            int length = workspace.getChildren().size();
            workspace.getChildren().get(workspace.getChildren().indexOf(project)).setName("Project " + length);
        }

        if(ruNode instanceof Project){
            Project project = (Project)ruNode;
            Presentation presentation = new Presentation("Presentation", project);
            project.addChild(presentation);
            int length = project.getChildren().size();
            project.getChildren().get(project.getChildren().indexOf(presentation)).setName("Presentation " + length);
        }

        if(ruNode instanceof Presentation){
             Presentation presentation = (Presentation) ruNode;
             Slide slide = new Slide("Slide", presentation);
             presentation.addChild(slide);
             int length = presentation.getChildren().size();
             presentation.getChildren().get(presentation.getChildren().indexOf(slide)).setName("Slide " + length);
        }

        if(ruNode instanceof Slide){
            RuError error = MainFrame.getInstance().getErrorFactory().createErrorMessage(RuErrorType.sl_add);
            error.showMessageError();
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        */

        if(MainFrame.getInstance().getMyTree().getLastSelectedPathComponent() == null){

            ErrorFactory.getInstance().generateError("Nemoguce dodavanje, cvor nije selektovan!");

            return;
        }


        RuNode ruNode = ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();


        AbstractRuNodeFactory factory = FactoryGenerator.returnNodeFactory(ruNode);

        if(factory == null){

            ErrorFactory.getInstance().generateError("Nije moguce dodavanje u slajd!");

            return;
        }


        MyTreeNode child = new MyTreeNode(factory.getNodeForTree(ruNode));
        //System.out.println(child.getName());

        //((RuNodeComposite)ruNode).addChild(child.getRuNode());

        MainFrame.getInstance().getCommandManager().addCommand(new AddConcreteCommand(ruNode, child.getRuNode()));

        if(ruNode instanceof Project){
            System.out.println("usao u set changed za project");
            ((Project)ruNode).setChanged(true);
        }else if(ruNode instanceof Presentation){
            ((Presentation)ruNode).setChanged(true);
        }

        ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode()).setChanged(true);


        //dodavanje presentation tabova nakon dodavanje u stablo
        /*
        if(ruNode instanceof Project){
            MainFrame.getInstance().addTabToTabbedPane((Presentation) child.getRuNode());
        }
         */

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

    }
}
