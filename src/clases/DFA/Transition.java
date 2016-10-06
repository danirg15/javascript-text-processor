package DFA;

public class Transition {
	private State initialState;
	private Symbol symbol;
	private State targetState;
	private SemanticAction action;
	
	public Transition(State input, Symbol symbol, State output, SemanticAction action) {
		this.initialState = input;
		this.symbol = symbol;
		this.targetState = output;
		this.action = action;
	}

	public State getInitialState() {
		return initialState;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public State getTargetState() {
		return targetState;
	}
	
	public SemanticAction getAction(){
		return action;
	}

	@Override
	public String toString() {
		return "\t\t" + initialState.getName() + " -- " + symbol + " Action:" +action+ " -->  " + targetState.getName() + "\n\t";
	} 
	

}
