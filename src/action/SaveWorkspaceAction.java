package action;

import application.MainFrame;
import errors.ErrorFactory;
import gui.tree.model.MyTreeNode;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveWorkspaceAction extends AbstractRudokAction{

    public SaveWorkspaceAction(){

        putValue(NAME, "Save workspace");
        putValue(SHORT_DESCRIPTION, "Save workspace");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new WorkspaceFileFilter());


        Workspace workspace = ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode());
        System.out.println(workspace.getChildren().size());


        System.out.println("usao u action performed");

        if(!workspace.isChanged()){
            return;
        }


        System.out.println("usao u action performed ");

        if (workspace.getWorkspaceFile()==null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                workspace.setWorkspaceFile(jFileChooser.getSelectedFile());

                System.out.println("usao u saveWorkspaceAction");
            }
        }


        for(RuNode ch : workspace.getChildren()) {

            System.out.println("Usao u for");

            Project project = (Project) ch;

            if (project.getProjectFile() == null) {
                System.out.println("Ovde ne ulazi");
                ErrorFactory.getInstance().generateError("Morate sacuvati sve projekte!");
                return;
            }
        }

        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(workspace.getWorkspaceFile());

            printWriter = new PrintWriter(fileWriter);

            for(RuNode ch : workspace.getChildren()){


                Project project = (Project) ch;

                printWriter.println(project.getProjectFile().getAbsolutePath());

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {

            if(printWriter != null){
                printWriter.close();
            }
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }




        /*
        for(RuNode ch : workspace.getChildren()){

            System.out.println("Usao u for");

            Project project = (Project) ch;

            if(project.getProjectFile() == null){
                System.out.println("Ovde ne ulazi");
                ErrorFactory.getInstance().generateError("Morate sacuvati sve projekte!");
                return;
            }


            FileWriter fileWriter = null;
            //BufferedWriter bufferedWriter = null;
            PrintWriter printWriter = null;
            //FileOutputStream fileOutputStream = null;

            try {
                fileWriter = new FileWriter(workspace.getWorkspaceFile());

                //bufferedWriter = new BufferedWriter(fileWriter);
                printWriter = new PrintWriter(fileWriter);

                //System.out.println(project.getProjectFile());
                //System.out.println(workspace.getWorkspaceFile());

                //fileWriter.write(project.getProjectFile().getAbsolutePath());
                //fileWriter.write("/n");

                //bufferedWriter.write(project.getProjectFile().getAbsolutePath());
                //bufferedWriter.write("\n");
                //bufferedWriter.newLine();
                //bufferedWriter.append(project.getProjectFile().getAbsolutePath());
                //bufferedWriter.append("\n");

                printWriter.println(project.getProjectFile());
                //fileWriter.write(project.getProjectFile().getAbsolutePath());
                //fileWriter.write('\n');

                //fileOutputStream = new FileOutputStream(workspace.getWorkspaceFile());

                //bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                //bufferedWriter.write(project.getProjectFile().getAbsolutePath());
                //bufferedWriter.write("\n");
                //bufferedWriter.newLine();
                //bufferedWriter.flush();

            } catch (IOException ex) {
                ex.printStackTrace();
            }finally {

                try {
                    //bufferedWriter.close();
                    printWriter.close();
                    fileWriter.close();
                    //fileOutputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }

            System.out.println(project.getProjectFile());

        }

        System.out.println("Velicina workspace-a:" + workspace.getChildren().size());

        */
    }
}
