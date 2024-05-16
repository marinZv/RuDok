package controller;

import application.MainFrame;
import dialogs.ThemeDialog;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditThemeController implements ActionListener {

    ThemeDialog themeDialog;

    public EditThemeController(ThemeDialog themeDialog) {
        this.themeDialog = themeDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode ruNode = ((MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();

        if(!(ruNode instanceof Presentation)){
            return;
        }

        if(e.getActionCommand().equalsIgnoreCase("open")){
            JFileChooser jfChooser = new JFileChooser(FileSystemView.getFileSystemView());

            FileFilter filter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
            jfChooser.setFileFilter(filter);

            if(jfChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                ((Presentation)ruNode).setTheme(jfChooser.getSelectedFile().getAbsolutePath());

                ((Presentation) ruNode).setChanged(true);
                ((Project)((Presentation) ruNode).getParent()).setChanged(true);
                ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode()).setChanged(true);

            }

            themeDialog.setVisible(false);

        }
    }

}
