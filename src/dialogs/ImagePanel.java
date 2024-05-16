package dialogs;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private String themePath;

    public ImagePanel(String themePath){
        this.themePath = themePath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image img = new ImageIcon(themePath).getImage();
        /*
        g.drawImage(img, (int)(this.getSize().getWidth() - img.getWidth(null))/2,
                (int)(this.getSize().getHeight() - img.getHeight(null))/2, null);
        */


        super.paintComponent(g);
        Dimension d = getSize();
        g.drawImage(img, 0, 0, d.width, d.height, this);
        System.out.println("Odradjen paint Component");
    }

    public void setImageURL(String themePath){
        this.themePath = themePath;
    }
}
