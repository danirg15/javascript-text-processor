package automata;

import java.util.ArrayList;

public class DFA {
	private NonFinalState initialState;
	private State currentState;
	private TransitionMatrix transitionMatrix;

	public DFA(NonFinalState initialState, TransitionMatrix transitionMatrix) {
		this.initialState = initialState;
		this.currentState = initialState;
		this.transitionMatrix = transitionMatrix;
	}
	
	
	public State transit(char c){
		Transition t;
		
		if((t = getTransitionWithSymbol(this.currentState, c)) != null){
			this.currentState = t.getTargetState();
			return this.currentState;
		}
				
		return null;
	}
	
	public Transition getTransitionWithSymbol(State fromState, char c){
		ArrayList<Transition> transitions = this.transitionMatrix.getTransitions(fromState);
		
		for(Transition t : transitions){
			if(t.getSymbol().match(c)){
				return t;
			}
		}
		
		return null;
	}

	public void restart(){
		this.currentState = this.initialState;
	}
	
	public State getCurrentState(){
		return this.currentState;
	}
	
//	public boolean isInFinalState(){
//		return (this.currentState instanceof FinalState); 
//	}

	@Override
	public String toString() {
		return "AFD [currentState=" + currentState.getName() +"]\n"+ transitionMatrix;
	}


}
