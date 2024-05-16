package action;

import application.MainFrame;
import gui.tree.model.MyTreeNode;
import model.workspace.Project;
import model.workspace.Workspace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class OpenWorkspaceAction extends AbstractRudokAction{

    public OpenWorkspaceAction(){
        putValue(NAME, "open workspace");
        putValue(SHORT_DESCRIPTION, "open workspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new WorkspaceFileFilter());

        BufferedReader bufferedReader = null;

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            try {
                bufferedReader = new BufferedReader(new FileReader(jfc.getSelectedFile()));



                String line = null;

                while ((line = bufferedReader.readLine())!= null){

                    System.out.println(line);

                    ObjectInputStream os = new ObjectInputStream(new FileInputStream(line));

                    Project project = null;

                    project = (Project) os.readObject();

                    ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode()).addChild(project);

                    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

                }


            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


        }

    }
}
