package AFD;

import java.util.ArrayList;

public class AFD {
	
	private State currentState;
	private TransitionMatrix transitionMatrix;

	public AFD(NonFinalState initialState, TransitionMatrix transitionMatrix) {
		this.currentState = initialState;
		this.transitionMatrix = transitionMatrix;
	}
	
	
	public State transit(NonFinalState fromState, char c){
		ArrayList<Transition> transitions = this.transitionMatrix.getTransitions(fromState);
		
		for(Transition t : transitions){
			if(t.getSymbol().match(c)){
				this.currentState = t.getTargetState();
				return this.currentState;
			}
		}
		
		return null;
	}


	@Override
	public String toString() {
		return "AFD [currentState=" + currentState.getName() +"]\n"+ transitionMatrix;
	}


}
