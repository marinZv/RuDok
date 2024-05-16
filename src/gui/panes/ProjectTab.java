package gui.panes;

import model.workspace.Presentation;
import observer.Subscriber;

import javax.swing.*;
import java.awt.*;

public class ProjectTab extends JPanel implements Subscriber {

    private Presentation presentation;
    private JPanel topPanel;
    private JLabel authorLabel;
    private PresentationView presentationView;

    public ProjectTab(Presentation presentation){
        this.presentation = presentation;
        this.setLayout(new BorderLayout());
        this.presentation.addSubscriber(this);

        authorLabel = new JLabel("Author: " + presentation.getAuthor());
        topPanel = new JPanel();
        topPanel.add(authorLabel);
        add(topPanel, BorderLayout.NORTH);

        presentationView = new PresentationView(presentation);
        add(presentationView, BorderLayout.CENTER);

    }

    @Override
    public void update(Object notification) {
        authorLabel.setText("Author: " + ((Presentation)notification).getAuthor());
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public PresentationView getPresentationView() {
        return presentationView;
    }

    public JLabel getAuthorLabel() {
        return authorLabel;
    }

    public void removeAuthorLabel(){
        this.remove(this.topPanel);
    }

    public void addAuthorLabel(){
        this.add(this.topPanel);
    }

}
