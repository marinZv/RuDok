package factory;

import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import model.workspace.nodes.RuNode;

public class FactoryGenerator {

    private static final ProjectFactory projectFactory = new ProjectFactory();
    private static final PresentationFactory presentationFactory = new PresentationFactory();
    private static final SlideFactory slideFactory = new SlideFactory();

    public static AbstractRuNodeFactory returnNodeFactory(RuNode selected){

        if(selected instanceof Workspace){
            return projectFactory;
        }else if(selected instanceof Project){
            return presentationFactory;
        }else if(selected instanceof Presentation){
            return slideFactory;
        }

        return null;
    }

}
