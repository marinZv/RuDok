package view;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog {

    public InfoDialog(){
        super(MainFrame.getInstance());
        initialise();
    }

    private void initialise(){

        setSize(400, 500);
        setTitle("Student info");

        JLabel imePrezimeLabel = new JLabel("Milan Marinkovic");
        JLabel indeksLabel = new JLabel("RN 79/21");

        ImagePanel imagePanel = new ImagePanel(new ImageIcon("InfoImage.jpg").getImage());

        JPanel boxPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);

        boxPanel.add(imePrezimeLabel);
        boxPanel.add(indeksLabel);
        boxPanel.add(imagePanel);

        add(boxPanel);

        setLocationRelativeTo(null);
        setVisible(true);

    }

}
