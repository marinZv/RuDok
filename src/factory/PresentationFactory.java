package factory;

import model.workspace.Presentation;
import model.workspace.nodes.RuNode;

public class PresentationFactory extends AbstractRuNodeFactory{

    @Override
    public RuNode createRuNode() {
        return new Presentation();
    }

}
