package action;

import application.MainFrame;
import dialogs.AuthorDialog;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.nodes.RuNode;

import java.awt.event.ActionEvent;

public class AuthorAction extends AbstractRudokAction{

    public AuthorAction(){
        putValue(NAME, "Edit author");
        putValue(SHORT_DESCRIPTION,"Change name of autor:");
        putValue(SMALL_ICON, loadIcon("author.png"));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode ruNode = null;

        if(MainFrame.getInstance().getMyTree().getLastSelectedPathComponent() == null){
            //RuError error = MainFrame.getInstance().getErrorFactory().createErrorMessage(RuErrorType.ns_presentation);
            //error.showMessageError();
            return;
        }else{
            ruNode =  ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();
        }


        if(ruNode instanceof Presentation){
            AuthorDialog authorDialog = new AuthorDialog();
            authorDialog.setVisible(true);
        }else{
            return;
        }
    }
}
