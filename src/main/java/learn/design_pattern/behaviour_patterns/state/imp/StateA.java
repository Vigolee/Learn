package learn.design_pattern.behaviour_patterns.state.imp;

import learn.design_pattern.behaviour_patterns.state.Context;
import learn.design_pattern.behaviour_patterns.state.State;

/**
 * Created by Vigo on 17/4/19.
 */
public class StateA extends State{

    @Override
    public void handle1() {
        super.context.setCurrentState(Context.STATE_B);
        super.context.doRequest_B();
    }

    @Override
    public void handle2() {

    }
}
