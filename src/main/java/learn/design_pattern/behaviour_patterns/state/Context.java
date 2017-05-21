package learn.design_pattern.behaviour_patterns.state;

import learn.design_pattern.behaviour_patterns.state.imp.StateA;
import learn.design_pattern.behaviour_patterns.state.imp.StateB;

/**
 * 环境
 * Created by Vigo on 17/4/19.
 */
public class Context {

    public final static State STATE_A = new StateA();

    public final static State STATE_B = new StateB();

    private State currentState;

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public void doRequest_A(){
        currentState.handle1();
    }

    public void doRequest_B(){
        currentState.handle2();
    }


}
