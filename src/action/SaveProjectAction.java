package action;

import application.MainFrame;
import errors.ErrorFactory;
import gui.tree.model.MyTreeNode;
import model.workspace.Project;
import model.workspace.Workspace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SaveProjectAction extends AbstractRudokAction{


    public SaveProjectAction(){

        putValue(NAME, "save project");
        putValue(SHORT_DESCRIPTION, "save project");

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjectFileFilter());

        if(MainFrame.getInstance().getMyTree().getLastSelectedPathComponent() == null ||
                ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode() instanceof Workspace){
            ErrorFactory.getInstance().generateError("Morate selektovati projekat!");
            return;
        }

        //Project project=AppCore.getInstance().getWorkspaceTree().getCurrentProject();
        Project project = (Project)((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();

        File projectFile=project.getProjectFile();

        if (!project.isChanged()){
            System.out.println("usao u return za project action");
            return;
        }

        if (project.getProjectFile()==null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                projectFile=jFileChooser.getSelectedFile();

            }else{
                return;
            }

        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(project);
            project.setProjectFile(projectFile);
            project.setChanged(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
