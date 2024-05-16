package gui.panes;

import application.MainFrame;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.nodes.RuNode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TabMouseListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

        if(MainFrame.getInstance().getMyTree().getLastSelectedPathComponent() == null){
            return;
        }

        RuNode ruNode = (RuNode) ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();


        if(e.getClickCount() == 2){
            if(ruNode instanceof Project){
                Project project = (Project)ruNode;
                MainFrame.getInstance().clearTabbedPane();
                for(RuNode p : project.getChildren()){
                    Presentation presentation = (Presentation) p;
                    MainFrame.getInstance().addTabToTabbedPane(presentation);
                }
                MainFrame.getInstance().getProjectNameLabel().setText(project.getName());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
