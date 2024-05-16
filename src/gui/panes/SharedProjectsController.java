package gui.panes;

import dialogs.ShareDialog;
import model.workspace.nodes.RuNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SharedProjectsController implements ActionListener {

    ShareDialog shareDialog;

    public SharedProjectsController(ShareDialog shareDialog){
        this.shareDialog = shareDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(RuNode ch : shareDialog.getWorkspace().getChildren()){

            if(e.getActionCommand().equals(ch.getName())){
                shareDialog.setSelectedProject(ch);
            }

        }

        System.out.println(shareDialog.getSelectedProject().getName());
    }


}