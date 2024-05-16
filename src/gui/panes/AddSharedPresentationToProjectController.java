package gui.panes;

import application.MainFrame;
import command.AddConcreteCommand;
import dialogs.ShareDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSharedPresentationToProjectController implements ActionListener {

    private ShareDialog shareDialog;

    public AddSharedPresentationToProjectController(ShareDialog shareDialog){
        this.shareDialog = shareDialog;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        shareDialog.getPresentation().addSharedProjects(shareDialog.getSelectedProject());
        shareDialog.getPresentation().addSharedPresentationToProjects();
        MainFrame.getInstance().getCommandManager().addCommand(new AddConcreteCommand(shareDialog.getSelectedProject(), shareDialog.getPresentation()));

        shareDialog.setVisible(false);
    }
}
