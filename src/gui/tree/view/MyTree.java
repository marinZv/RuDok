package gui.tree.view;

import gui.panes.TabMouseListener;
import gui.tree.controller.MyTreeCellEditor;
import gui.tree.controller.MyTreeCellRenderer;
import gui.tree.controller.MyTreeSelectionListener;
import gui.tree.model.MyTreeModel;

import javax.swing.*;

public class MyTree extends JTree {

    public MyTree(MyTreeModel myTreeModel){

        setModel(myTreeModel);
        addTreeSelectionListener(new MyTreeSelectionListener());
        setCellEditor(new MyTreeCellEditor(this, new MyTreeCellRenderer()));
        setCellRenderer(new MyTreeCellRenderer());
        addMouseListener(new TabMouseListener());
        setEditable(true);
    }


}
