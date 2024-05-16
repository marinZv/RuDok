package gui.panes;

import model.workspace.Project;
import observer.Subscriber;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyTabbedPane extends JTabbedPane implements Subscriber {

    Project project;

    public MyTabbedPane(){

        super();
    }

    @Override
    public void addTab(String title, Icon icon, Component component, String tip) {
        super.addTab(title, icon, component, tip);
        int count = this.getTabCount() - 1;
        setTabComponentAt(count, new CloseButtonTab(component, title, icon));
    }

    @Override
    public void addTab(String title, Icon icon, Component component){
        super.addTab(title, icon, component);
    }

    @Override
    public void addTab(String title, Component component){
        super.addTab(title, component);
    }

    public void addTabNoExit(String title, Icon icon, Component component, String tip){
        addTab(title,icon,component,tip);
    }

    public void addTabNoExit(String title, Icon icon, Component component){
        addTab(title, icon, component, null);
    }

    public void addTabNoExit(String title, Component component){
        addTab(title, null, component);
    }

    public class CloseButtonTab extends JPanel{

        private Component tab;

        public CloseButtonTab(final Component tab, String title, Icon icon){
            this.tab = tab;
            setOpaque(false);
            FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
            setLayout(flowLayout);
            JLabel label = new JLabel(title);
            label.setIcon(icon);
            add(label);
            JButton button = new JButton(MetalIconFactory.getInternalFrameCloseIcon(16));
            button.setMargin(new Insets(0, 0,0,0));
            button.addMouseListener(new CloseListener(tab));
            add(button);
        }
    }

    public class CloseListener implements MouseListener{

        private Component tab;

        public CloseListener(Component tab){
            this.tab = tab;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() instanceof JButton){
                System.out.println("Usao sam u if");
                JButton button = (JButton) e.getSource();
                JTabbedPane tabbedPane = (JTabbedPane) button.getParent().getParent().getParent();
                tabbedPane.remove(tab);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


    @Override
    public void update(Object notification) {

    }

}
