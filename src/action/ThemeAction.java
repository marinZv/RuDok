package action;

import dialogs.ThemeDialog;

import java.awt.event.ActionEvent;

public class ThemeAction extends  AbstractRudokAction{

    public ThemeAction(){
        putValue(NAME, "Theme");
        putValue(SMALL_ICON, loadIcon("theme.png"));
        putValue(SHORT_DESCRIPTION, "Change name of theme");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ThemeDialog themeDialog = new ThemeDialog();
        themeDialog.setVisible(true);


    }
}
