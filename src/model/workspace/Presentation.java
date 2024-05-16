package model.workspace;

import application.MainFrame;
import gui.tree.model.MyTreeNode;
import model.workspace.nodes.RuNode;
import model.workspace.nodes.RuNodeComposite;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Presentation extends RuNodeComposite implements Serializable {

    private String author;
    private String theme;

    private List<RuNode> projects;

    private File presentationFile;

    private boolean changed = false;

    public Presentation(){
        projects = new ArrayList<>();
    }

    /*public Presentation(String name, RuNode parent) {
        super(name, parent);
    }
    */

    @Override
    public void addChild(RuNode node) {
        if (node instanceof Slide) {
            Slide slide = (Slide) node;
            this.getChildren().add(slide);
            notifySubscribers(this);
        }
    }

    @Override
    public void removeChild(RuNode node) {
        if(node instanceof Slide){
            Slide slide = (Slide) node;
            if(this.getChildren().contains(slide)){
                this.getChildren().remove(slide);
                notifySubscribers(this);
            }
        }
    }

    @Override
    public String toString(){
        return "Presentation";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscribers(this);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
        notifySubscribers(this);
    }

    public List<RuNode> getProjects() {
        return projects;
    }

    public void addSharedProjects(RuNode project){
        projects.add(project);
    }

    public void addSharedPresentationToProjects(){

        Workspace workspace = (Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode();

        for(RuNode ch : workspace.getChildren()){

            for(RuNode p : this.projects){

                if(ch.getName().equals(p.getName())){
                    ((RuNodeComposite)ch).addChild(this);
                }
            }

        }

        notifySubscribers(this);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

    }


    public File getPresentationFile() {
        return presentationFile;
    }

    public void setPresentationFile(File presentationFile) {
        this.presentationFile = presentationFile;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
