package controller;

import application.MainFrame;
import dialogs.AuthorDialog;
import errors.ErrorFactory;
import errors.RuError;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAuthorController implements ActionListener {

    AuthorDialog authorDialog;

    public EditAuthorController(AuthorDialog authorDialog){
        this.authorDialog = authorDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode ruNode = (RuNode) ((MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();
        RuError error = null;

        if((ruNode instanceof Presentation) && (e.getActionCommand().equalsIgnoreCase("ok"))){
            if(!authorDialog.getTfName().getText().isEmpty()){
                ((Presentation) ruNode).setAuthor(authorDialog.getTfName().getText());
                authorDialog.setVisible(false);

                ((Presentation) ruNode).setChanged(true);
                ((Project)((Presentation) ruNode).getParent()).setChanged(true);
                ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode()).setChanged(true);

            }else{

                ErrorFactory.getInstance().generateError("Nemoguce promeniti ime autora, prazno polje!");
                return;

                //error = MainFrame.getInstance().getErrorFactory().createErrorMessage(RuErrorType.empty_autor);
               // error.showMessageError();
            }
        }
    }

}
