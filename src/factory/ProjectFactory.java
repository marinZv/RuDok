package factory;

import model.workspace.Project;
import model.workspace.nodes.RuNode;

public class ProjectFactory extends AbstractRuNodeFactory{

    @Override
    public RuNode createRuNode() {
        return new Project();
    }
}
