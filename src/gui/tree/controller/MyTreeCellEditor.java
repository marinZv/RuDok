package gui.tree.controller;

import application.MainFrame;
import command.ChangeNameCommand;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MyTreeCellEditor  extends DefaultTreeCellEditor implements ActionListener {

    private JTextField edit=null;

    public MyTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {

        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }



    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        return false;
    }



    public void actionPerformed(ActionEvent e){

        RuNode ruNode = ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();

        if(!(ruNode instanceof Workspace)){
            //ruNode.setName(e.getActionCommand());

            MainFrame.getInstance().getCommandManager().addCommand(new ChangeNameCommand(ruNode, e.getActionCommand()));


            if(ruNode instanceof Project){

                ((Project)ruNode).setChanged(true);

            }else if(ruNode instanceof Presentation){

                ((Presentation)ruNode).setChanged(true);
                ((Project)((Presentation)ruNode).getParent()).setChanged(true);

            }


            ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode()).setChanged(true);

            MainFrame.getInstance().getMyTree().clearSelection();
        }
    }

}