package factory;

import model.workspace.nodes.RuNode;
import model.workspace.nodes.RuNodeComposite;

public abstract class AbstractRuNodeFactory {

    public RuNode getNodeForTree(RuNode selected){
        RuNode ruNode = createRuNode();
        ruNode.setParent(selected);
        ruNode.setName(ruNode.toString() + (((RuNodeComposite)selected).getChildren().size() + 1));

        return ruNode;
    }

    public abstract RuNode createRuNode();

}
