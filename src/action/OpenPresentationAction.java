package action;

import application.MainFrame;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenPresentationAction extends AbstractRudokAction {

    public OpenPresentationAction() {

        putValue(NAME, "Open presentation");
        putValue(SHORT_DESCRIPTION, "Open presentation");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Presentation presentation = null;
                try {
                    presentation = (Presentation) os.readObject();
                    presentation.setPresentationFile(jfc.getSelectedFile());

                    Workspace workspace = ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode());
                    workspace.setChanged(true);

                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                //((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode()).addChild(project);
                //System.out.println(((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode()).getChildren().size());

                ((Project) ((MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode()).addChild(presentation);

                MainFrame.getInstance().addTabToTabbedPane(presentation);

                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
    }

}
