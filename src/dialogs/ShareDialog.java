package dialogs;

import application.MainFrame;
import gui.panes.AddSharedPresentationToProjectController;
import gui.panes.SharedProjectsController;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import javax.swing.*;
import java.awt.*;

public class ShareDialog extends JDialog {

    private Presentation presentation;
    private Workspace workspace;
    private JPanel buttonsPanel;
    private RuNode selectedProject;
    private JButton buttonOk;

    public ShareDialog(Presentation presentation){
        super(MainFrame.getInstance());
        this.presentation = presentation;
        this.workspace = (Workspace) ((MyTreeNode)MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode();
        System.out.println(workspace);

        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setSize(new Dimension(300, 500));

        buttonsPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS);
        buttonsPanel.setLayout(boxLayout);
        fillButtonsPanel();

        buttonOk = new JButton("OK");
        buttonOk.addActionListener(new AddSharedPresentationToProjectController(this));
        buttonsPanel.add(buttonOk);
        add(buttonsPanel);

    }

    public void fillButtonsPanel(){

        for(RuNode ch : workspace.getChildren()){
            if(!((Project)ch).getChildren().contains(presentation)){

                JButton button = new JButton(ch.getName());
                button.addActionListener(new SharedProjectsController(this));
                buttonsPanel.add(button);
                buttonsPanel.add(Box.createVerticalStrut(5));

            }
        }
    }

    public RuNode getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(RuNode selectedProject) {
        this.selectedProject = selectedProject;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public Presentation getPresentation() {
        return presentation;
    }
}
