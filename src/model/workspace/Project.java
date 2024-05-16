package model.workspace;

import model.workspace.nodes.RuNode;
import model.workspace.nodes.RuNodeComposite;

import java.io.File;
import java.io.Serializable;

public class Project extends RuNodeComposite implements Serializable {

    private File projectFile;
    private boolean changed;

    public Project(){
        projectFile = null;
        changed = false;
    }

    public Project(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode node) {
        if(node instanceof Presentation){
            Presentation presentation = (Presentation) node;
            this.getChildren().add(presentation);
            //notifySubscribers(this);
        }
    }

    @Override
    public void removeChild(RuNode node) {
        if(node instanceof Presentation){
            Presentation presentation = (Presentation) node;
            if(this.getChildren().contains(presentation)){
                this.getChildren().remove(presentation);
                //notifySubscribers(this);
            }
        }
    }

    @Override
    public String toString(){
        return "Project";
    }


    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
