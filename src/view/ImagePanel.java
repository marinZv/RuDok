package view;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(Image image){
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, (int)(this.getSize().getWidth() - image.getWidth(null))/2,
                (int)(this.getSize().getHeight() - image.getHeight(null))/2, null);
    }
}
