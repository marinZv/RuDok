package gui.panes;

import application.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentationToolBar extends JToolBar implements ActionListener {

    private JRadioButton dashedStrokeRadioButton;
    private JRadioButton solidStrokeRadioButton;
    private ButtonGroup radioGroup;
    private String typeOfStroke;
    private JTextField textField;

    public PresentationToolBar(){

        //this.setFloatable(false);

        dashedStrokeRadioButton = new JRadioButton("Dashed stroke");
        solidStrokeRadioButton = new JRadioButton("Solid stroke");
        dashedStrokeRadioButton.addActionListener(this);
        solidStrokeRadioButton.addActionListener(this);
        typeOfStroke = new String();
        radioGroup = new ButtonGroup();
        radioGroup.add(dashedStrokeRadioButton);
        radioGroup.add(solidStrokeRadioButton);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(50,30));
        textField.setMaximumSize(new Dimension(50, 30));


        add(MainFrame.getInstance().getActionManager().getSlideShowAction());
        add(MainFrame.getInstance().getActionManager().getAddSlotAction());
        add(MainFrame.getInstance().getActionManager().getRemoveSlotAction());
        add(MainFrame.getInstance().getActionManager().getSelectSlotAction());
        add(MainFrame.getInstance().getActionManager().getMoveSlotAction());
        add(MainFrame.getInstance().getActionManager().getColorStrokeAction());
        add(this.dashedStrokeRadioButton);
        add(this.solidStrokeRadioButton);
        add(this.textField);


    }


    public JRadioButton getDashedStrokeRadioButton() {
        return dashedStrokeRadioButton;
    }

    public ButtonGroup getRadioGroup() {
        return radioGroup;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.typeOfStroke = ((JRadioButton)e.getSource()).getActionCommand();
        System.out.println(typeOfStroke);
    }

    public String getTypeOfStroke() {
        return typeOfStroke;
    }

    public JTextField getTextField() {
        return textField;
    }
}
