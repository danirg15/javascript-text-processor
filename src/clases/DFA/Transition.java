package DFA;

public class Transition {
	private State initialState;
	private Symbol symbol;
	private State targetState;
	
	public Transition(State input, Symbol symbol, State output) {
		this.initialState = input;
		this.symbol = symbol;
		this.targetState = output;
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

	@Override
	public String toString() {
		return "\t\t" + initialState.getName() + " -- " + symbol + " -->  " + targetState.getName() + "\n\t";
	} 
	

}
