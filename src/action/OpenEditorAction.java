package action;

import application.MainFrame;
import dialogs.EditorMultimediaDialog;
import dialogs.EditorTextDialog;
import gui.panes.ProjectTab;
import model.workspace.Slide;
import model.workspace.Slot;
import model.workspace.SlotType;
import model.workspace.nodes.RuNode;

import java.awt.event.ActionEvent;
import java.util.List;

public class OpenEditorAction extends AbstractRudokAction{

    public OpenEditorAction(){

        putValue(NAME, "Open editor");
        putValue(SHORT_DESCRIPTION, "Open editor");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<RuNode> slides = ((ProjectTab) MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().getPresentation().getChildren();

        for(RuNode s : slides){

            for(Slot slot : ((Slide)s).getSlots()){

                if(slot.isSelected()){

                    if(slot.getSlotType() == SlotType.slot_tekst){

                        EditorTextDialog editorTextDialog = new EditorTextDialog(slot);
                        editorTextDialog.setLocationRelativeTo(MainFrame.getInstance());
                        editorTextDialog.setVisible(true);
                    }else{

                        EditorMultimediaDialog editorMultimediaDialog = new EditorMultimediaDialog(slot);
                        editorMultimediaDialog.setLocationRelativeTo(MainFrame.getInstance());
                        editorMultimediaDialog.setVisible(true);

                    }

                }

            }

        }

    }
}
