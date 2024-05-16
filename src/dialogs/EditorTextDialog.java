package dialogs;

import application.MainFrame;
import model.workspace.Slot;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorTextDialog extends JDialog {

    private JToolBar textToolbar;
    private JTextPane textPane;
    private JButton boldButton;
    private JButton italicButton;
    private JButton underlineButton;
    private JButton saveButton;
    private Slot slot;

    public EditorTextDialog(Slot slot) {

        super(MainFrame.getInstance());

        //pack();
        //setLocationRelativeTo(MainFrame.getInstance());

        this.slot = slot;

        this.setSize(600, 500);
        this.setName("Edit text of slot");

        this.setLayout(new BorderLayout());

        textToolbar = new JToolBar();
        textPane = new JTextPane();

        createButtons();
        addActionsOnSaveButton();
        fillTextToolbar();

        add(textToolbar, BorderLayout.NORTH);
        add(textPane, BorderLayout.CENTER);
    }


    public void createButtons() {

        boldButton = new JButton(new StyledEditorKit.BoldAction());
        italicButton = new JButton(new StyledEditorKit.ItalicAction());
        underlineButton = new JButton(new StyledEditorKit.UnderlineAction());
        saveButton = new JButton("save");

    }


    public void fillTextToolbar() {

        textToolbar.add(boldButton);
        textToolbar.add(italicButton);
        textToolbar.add(underlineButton);
        textToolbar.add(saveButton);

    }

    public void addActionsOnSaveButton() {

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String stringBold = "*";
                String stringItalic = "?";
                String stringUnderline = "!";
                String regularString = "%";
                String finalString = "";


                AttributeSet set;

                for(int i = 0; i < textPane.getText().length(); i++){

                    set = textPane.getStyledDocument().getCharacterElement(i).getAttributes();

                    if(StyleConstants.isBold(set)){

                        stringBold += String.valueOf(textPane.getText().charAt(i));

                        if(i + 1 >= textPane.getText().length()){
                            stringBold += "*";
                            finalString += stringBold;
                            slot.addToStrings(stringBold);
                            //System.out.println(stringBold);
                            stringBold = "*";
                        }else{
                            set = textPane.getStyledDocument().getCharacterElement(i + 1).getAttributes();
                            if(!StyleConstants.isBold(set)){
                                stringBold += "*";
                                finalString += stringBold;
                                slot.addToStrings(stringBold);
                                //System.out.println(stringBold);
                                stringBold = "*";
                            }
                        }

                    }else if(StyleConstants.isItalic(set)){

                        stringItalic += String.valueOf(textPane.getText().charAt(i));

                        if(i + 1 >= textPane.getText().length()){
                            stringItalic += "?";
                            finalString += stringItalic;
                            slot.addToStrings(stringItalic);
                            stringItalic = "?";
                        }else{
                            set = textPane.getStyledDocument().getCharacterElement(i + 1).getAttributes();
                            if(!StyleConstants.isItalic(set)){
                                stringItalic += "?";
                                finalString += stringItalic;
                                slot.addToStrings(stringItalic);
                                stringItalic = "?";
                            }
                        }

                    }else if(StyleConstants.isUnderline(set)){

                        stringUnderline += String.valueOf(textPane.getText().charAt(i));

                        if(i + 1 >= textPane.getText().length()){
                            stringUnderline += "!";
                            finalString += stringUnderline;
                            slot.addToStrings(stringUnderline);
                            stringUnderline = "!";
                        }else{
                            set = textPane.getStyledDocument().getCharacterElement(i + 1).getAttributes();
                            if(!StyleConstants.isUnderline(set)){
                                stringUnderline += "!";
                                finalString += stringUnderline;
                                slot.addToStrings(stringUnderline);
                                stringUnderline = "!";
                            }
                        }

                    }else{

                        regularString += String.valueOf(textPane.getText().charAt(i));

                        if(i + 1 >= textPane.getText().length()){
                            regularString += "%";
                            finalString += regularString;
                            slot.addToStrings(regularString);
                            regularString = "%";
                        }else{
                            set = textPane.getStyledDocument().getCharacterElement(i + 1).getAttributes();
                            if(StyleConstants.isUnderline(set) || StyleConstants.isItalic(set) || StyleConstants.isBold(set)){
                                regularString += "%";
                                finalString += regularString;
                                slot.addToStrings(regularString);
                                regularString = "%";
                            }
                        }

                    }

                }

                //System.out.println(finalString);
                //System.out.println("bla");
                slot.setText(finalString);
            }
        });

    }

}
