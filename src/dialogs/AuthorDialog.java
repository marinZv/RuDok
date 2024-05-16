package dialogs;

import application.MainFrame;
import controller.EditAuthorController;
import errors.RuError;
import errors.RuErrorType;
import gui.tree.model.MyTreeNode;
import model.workspace.Presentation;
import model.workspace.nodes.RuNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorDialog extends JDialog{

    private JTextField tfName;

    public AuthorDialog(){
        super(MainFrame.getInstance());
        initalise();
    }

    private void initalise(){
        setSize(400, 300);
        setTitle("Author");

        JPanel boxPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);

        JLabel lblName = new JLabel("New author name: ");
        lblName.setPreferredSize(new Dimension(120,20));
        tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(120,20));

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new EditAuthorController(this));

        JPanel panelName = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelName.add(lblName);
        panelName.add(tfName);

        boxPanel.add(panelName);
        boxPanel.add(btnOK);

        add(boxPanel,BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }

    public JTextField getTfName() {
        return tfName;
    }
}
