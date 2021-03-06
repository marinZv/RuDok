package controller;

public class ActionManager {

    private NewAction newAction;
    private InfoAction infoAction;

    public ActionManager(){
        initialise();
    }

    private void initialise(){
        newAction = new NewAction();
        infoAction = new InfoAction();
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }
}
