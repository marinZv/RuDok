package gui.tree.model;

import jdk.nashorn.api.tree.Tree;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;
import model.workspace.nodes.RuNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Iterator;

public class MyTreeNode extends DefaultMutableTreeNode {

    private String name;
    private RuNode ruNode;

    public MyTreeNode(RuNode ruNode){
        super();
        this.ruNode = ruNode;
    }

    @Override
    public TreeNode getParent() {
        return new MyTreeNode(ruNode.getParent());
    }

    @Override
    public TreeNode getChildAt(int index) {
        return new MyTreeNode(((RuNodeComposite)ruNode).getChildren().get(index));
    }

    @Override
    public int getChildCount() {
        return ((RuNodeComposite)ruNode).getChildren().size();
    }

    @Override
    public int getIndex(TreeNode aChild) {
        return ((RuNodeComposite)ruNode).getChildren().indexOf(((MyTreeNode)aChild).getRuNode());
    }

    @Override
    public boolean getAllowsChildren() {
        return ruNode instanceof RuNodeComposite;
    }

    @Override
    public boolean isLeaf() {
        return !(ruNode instanceof RuNodeComposite);
    }

    public RuNode getRuNode() {
        return ruNode;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return ruNode.getName();
    }
}
