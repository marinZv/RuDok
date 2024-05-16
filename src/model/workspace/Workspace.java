package model.workspace;

import model.workspace.nodes.RuNode;
import model.workspace.nodes.RuNodeComposite;

import java.io.File;

public class Workspace extends RuNodeComposite {


    private File workspaceFile;
    private boolean changed = false;

    public Workspace(String name, RuNode parent) {
        super(name, null);
    }

    @Override
    public void addChild(RuNode node) {
        if(node instanceof Project){
            Project project = (Project) node;
            this.getChildren().add(node);
        }
    }

    @Override
    public void removeChild(RuNode node) {
        if(node instanceof Project){
            Project project = (Project) node;
            if(this.getChildren().contains(project)){
                this.getChildren().remove(project);
            }
        }
    }

    @Override
    public String toString(){
        return "Workspace";
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public File getWorkspaceFile() {
        return workspaceFile;
    }

    public void setWorkspaceFile(File workspaceFile) {
        this.workspaceFile = workspaceFile;
    }
}
