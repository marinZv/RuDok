package factory;

import model.workspace.Slide;
import model.workspace.nodes.RuNode;

public class SlideFactory extends AbstractRuNodeFactory{

    @Override
    public RuNode createRuNode() {
        return new Slide();
    }
}
