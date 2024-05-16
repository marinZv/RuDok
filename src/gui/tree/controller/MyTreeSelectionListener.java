package gui.tree.controller;

import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.nodes.RuNode;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MyTreeSelectionListener implements TreeSelectionListener {

    public MyTreeSelectionListener(){

    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        MyTreeNode node = (MyTreeNode) path.getLastPathComponent();

        if((RuNode)node.getRuNode() instanceof Presentation){
            System.out.println(((Presentation)(RuNode)node.getRuNode()).getAuthor());
            System.out.println(((Presentation)(RuNode)node.getRuNode()).getTheme());
        }
    }
}
