package dialogs;

import application.MainFrame;
import model.workspace.Slot;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorMultimediaDialog extends JDialog{

    private JToolBar multimediaToolbar;
    private JButton openButton;
    private JButton saveButton;
    private ImagePanel imagePanel;
    private String themePath;
    private JPanel panel;
    private Slot slot;

    public EditorMultimediaDialog(Slot slot){

        super(MainFrame.getInstance());
        setLocationRelativeTo(MainFrame.getInstance());

        this.slot = slot;

        this.setTitle("Editor mulitemedia");
        this.setSize(new Dimension(600, 400));

        this.setLayout(new BorderLayout());

        multimediaToolbar = new JToolBar();
        multimediaToolbar.setFloatable(false);

        createButtons();

        addActionOnOpenButton();
        addActionOnSaveButton();

        multimediaToolbar.add(openButton);
        multimediaToolbar.add(saveButton);

        this.add(multimediaToolbar, BorderLayout.NORTH);
    }


    public void createButtons(){

        openButton = new JButton("Open");
        saveButton = new JButton("Save");

    }

    public void addActionOnOpenButton(){

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getActionCommand().equalsIgnoreCase("open")){
                    JFileChooser jfChooser = new JFileChooser(FileSystemView.getFileSystemView());

                    FileFilter filter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
                    jfChooser.setFileFilter(filter);

                    if(jfChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                        themePath = jfChooser.getSelectedFile().getAbsolutePath();

                        System.out.println(themePath);

                        imagePanel = new ImagePanel(themePath);
                        addImage(imagePanel);
                        repaint();
                        revalidate();

                    }

                }

            }
        });

    }


    public void addActionOnSaveButton(){

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                slot.setImagePath(themePath);
                System.out.println(slot.getImagePath());

            }
        });

    }

    public void addImage(ImagePanel imagePanel){

        this.add(imagePanel, BorderLayout.CENTER);
        System.out.println("Dodat imagePanel");

    }


}
