package DFA;

public class Transition {
	private State initialState;
	private Symbol symbol;
	private State targetState;
	private SemanticAction semanticAction;
	
	public Transition(State input, Symbol symbol, State output, SemanticAction semanticAction) {
		this.initialState = input;
		this.symbol = symbol;
		this.targetState = output;
		this.semanticAction = semanticAction;
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
	
	public SemanticAction getSemanticAction(){
		return semanticAction;
	}

	@Override
	public String toString() {
		return "\t\t" + initialState.getName() + " -- " + symbol + " Action:" +semanticAction+ " -->  " + targetState.getName() + "\n\t";
	} 
	

}
