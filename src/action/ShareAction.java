package action;

import application.MainFrame;
import dialogs.ShareDialog;
import errors.ErrorFactory;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;

import java.awt.event.ActionEvent;

public class ShareAction extends AbstractRudokAction{

    private ShareDialog shareDialog;

    public ShareAction(){
        putValue(NAME, "Share");
        putValue(SHORT_DESCRIPTION, "Share");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(MainFrame.getInstance().getMyTree().getLastSelectedPathComponent() == null){
            ErrorFactory.getInstance().generateError("Morate selektovati prezentaciju");
            return;
        }else if(!(((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode() instanceof Presentation)){
            ErrorFactory.getInstance().generateError("Morate selektovati prezentaciju");
            return;
        }

        Presentation presentation = (Presentation) ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();

        shareDialog = new ShareDialog(presentation);
        shareDialog.setLocationRelativeTo(MainFrame.getInstance());
        shareDialog.setVisible(true);

        //System.out.println(((MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode().getName());
    }
}
