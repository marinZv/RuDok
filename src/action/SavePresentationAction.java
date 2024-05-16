package action;

import application.MainFrame;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SavePresentationAction extends AbstractRudokAction{

    public SavePresentationAction(){

        putValue(NAME,"Save presentation");
        putValue(SHORT_DESCRIPTION, "Save presentation");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjectFileFilter());


        //Project project=AppCore.getInstance().getWorkspaceTree().getCurrentProject();
        Presentation presentation = (Presentation) ((MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();
        File presentationFile=presentation.getPresentationFile();

        if (!presentation.isChanged()){
            return;
        }

        if (presentation.getPresentationFile()==null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                presentationFile=jFileChooser.getSelectedFile();

            }else{
                return;
            }

        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(presentationFile));
            os.writeObject(presentation);
            //project.setProjectFile(projectFile);
            //project.setChanged(false);

            presentation.setPresentationFile(presentationFile);
            presentation.setChanged(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
