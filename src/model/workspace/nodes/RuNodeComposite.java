package model.workspace.nodes;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode {

    private List<RuNode> children;

    public RuNodeComposite(){
        this.children = new ArrayList<>();
    }

    public RuNodeComposite(String name, RuNode parent){
        super(name,parent);
        this.children = new ArrayList<>();
    }

    public RuNodeComposite(String name, RuNode parent, List<RuNode> children){
        super(name,parent);
        this.children = children;
    }

    public abstract void addChild(RuNode node);
    public abstract void removeChild(RuNode node);

    public List<RuNode> getChildren() {
        return children;
    }

    //
    public void setChildren(List<RuNode> children) {
        this.children = children;
    }
    //


}
