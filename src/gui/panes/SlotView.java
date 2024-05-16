package gui.panes;

import model.workspace.Slot;
import model.workspace.SlotType;

import javax.swing.*;
import java.awt.*;

public class SlotView extends JPanel {

    private Slot slot;

    private static int offset = 5;

    public SlotView(Slot slot){
        this.slot = slot;

    }

    public void paint(Graphics2D graphics2D, boolean parameter){



        int x = slot.getPoint().x;
        int y = slot.getPoint().y;
        int width = slot.getDimension().width;
        int height = slot.getDimension().height;

        if(!parameter){

            graphics2D.setColor(slot.getColor());
            graphics2D.setStroke(slot.getSerializableStrokeAdapter().getStroke());
            //graphics2D.setPaint(Color.BLUE);
            graphics2D.drawRect(x, y, width, height);

            graphics2D.setPaint(Color.BLACK);

            //this.setOpaque(true);
            //this.setBackground(Color.BLACK);
            graphics2D.fillRect(slot.getPoint().x, slot.getPoint().y, slot.getDimension().width, slot.getDimension().height);

            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));

        }else{

            if(slot.getSlotType() == SlotType.slot_tekst){
                //graphics2D.drawString(slot.getText(), x, y);

                int xx = x;

                for(String str : slot.getStrings()){
                    if(str.charAt(0) == '*'){

                        String substring = str.substring(1, str.length()-1);
                        System.out.println(substring);
                        graphics2D.setFont(new Font("default", Font.BOLD, 16));

                        graphics2D.drawString(substring, xx, y);
                        xx += substring.length() + 35;

                    }else if(str.charAt(0)=='?'){

                        String substring = str.substring(1, str.length()-1);
                        System.out.println(substring);
                        graphics2D.setFont(new Font("default", Font.ITALIC, 16));
                        graphics2D.drawString(substring, xx, y);
                        xx += substring.length() + 35;

                    }else if(str.charAt(0)=='!'){

                        String substring = str.substring(1, str.length()-1);
                        System.out.println(substring);
                        graphics2D.drawString(substring, xx, y);
                        graphics2D.drawLine(xx, y + 2, xx + getFontMetrics(getFont()).stringWidth(str), y + 2);
                        xx += substring.length() + 35;

                    }else{

                        String substring = str.substring(1, str.length()-1);
                        System.out.println(substring);
                        graphics2D.drawString(str, xx, y);
                        xx += substring.length() + 35;
                    }
                }


            }else{

                Image img = new ImageIcon(slot.getImagePath()).getImage();

                System.out.println(slot.getImagePath());

                graphics2D.drawImage(img, x, y, null);
                repaint();
                revalidate();

            }

        }



    }

    public Slot getSlot() {
        return slot;
    }

}
