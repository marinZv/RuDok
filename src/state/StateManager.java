package state;

import state.concrete.EditShowState;
import state.concrete.SlideShowState;

import java.io.Serializable;

public class StateManager implements Serializable {

    private SlideShowState slideShowState;
    private EditShowState editShowState;
    private State currentState;

    public StateManager(){
        initStates();
    }

    private void initStates(){
        slideShowState = new SlideShowState();
        editShowState =  new EditShowState();
        currentState = editShowState;
    }


    public void setEditShowState() {
        this.currentState = editShowState;
    }

    public void setSlideShowState() {
        this.currentState = slideShowState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
