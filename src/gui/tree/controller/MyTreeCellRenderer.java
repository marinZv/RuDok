package gui.tree.controller;

import application.MainFrame;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

    public MyTreeCellRenderer(){

    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree,
                                                  Object value,
                                                  boolean sel,
                                                  boolean expanded,
                                                  boolean leaf,
                                                  int row,
                                                  boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (value instanceof MyTreeNode) {

            RuNode ruNode = ((MyTreeNode)value).getRuNode();

            if (ruNode instanceof Workspace) {
                URL imageURL = getClass().getResource("images/workspace.png");
                Icon icon = null;
                if (imageURL != null) {
                    icon = new ImageIcon(imageURL);
                }
                setIcon(icon);
            } else if (ruNode instanceof Project) {
                URL imageURL = getClass().getResource("images/project.png");
                Icon icon = null;
                if (imageURL != null) {
                    icon = new ImageIcon(imageURL);
                }
                setIcon(icon);
            } else if (ruNode instanceof Presentation) {
                URL imageURL = getClass().getResource("images/pres.png");
                Icon icon = null;
                if (imageURL != null) {
                    icon = new ImageIcon(imageURL);
                }
                setIcon(icon);
            } else if (ruNode instanceof Slide) {
                URL imageURL = getClass().getResource("images/sld.png");
                Icon icon = null;
                if (imageURL != null) {
                    icon = new ImageIcon(imageURL);
                }
                setIcon(icon);
            }
        }
        return this;
    }

}
