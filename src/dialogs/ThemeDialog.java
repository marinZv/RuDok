package dialogs;

import application.MainFrame;
import controller.EditThemeController;

import javax.swing.*;
import java.awt.*;

public class ThemeDialog extends JDialog{

    public ThemeDialog(){
        super(MainFrame.getInstance());
        initialise();
    }

    TextField tf;

    private void initialise(){

        setSize(400,300);
        setTitle("Theme");

        JPanel boxPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);

        JLabel lblName = new JLabel("Edit theme name: ");
        lblName.setPreferredSize(new Dimension(120, 20));
        tf = new TextField();
        tf.setPreferredSize(new Dimension(120, 20));

        JPanel panelName = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        panelName.setLayout(flowLayout);
        panelName.add(lblName);
        panelName.add(tf);

        JButton btnOpen = new JButton("Open");
        btnOpen.addActionListener(new EditThemeController(this));

        boxPanel.add(panelName);
        boxPanel.add(btnOpen);

        add(boxPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        RuNode ruNode = ((MyTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent()).getRuNode();
//
//        if(!(ruNode instanceof Presentation)){
//            return;
//        }
//
//        if(e.getActionCommand().equalsIgnoreCase("open")){
//            JFileChooser jfChooser = new JFileChooser(FileSystemView.getFileSystemView());
//
//            FileFilter filter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
//            jfChooser.setFileFilter(filter);
//
//            if(jfChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
//                ((Presentation)ruNode).setTheme(jfChooser.getSelectedFile().getAbsolutePath());
//            }
//
//            setVisible(false);
//
//        }
//    }
}
