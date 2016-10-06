package DFA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TransitionMatrix {

	private HashMap<NonFinalState, ArrayList<Transition>> transitions;
	
	private NonFinalState[] nonFinalStates;
	private FinalState[] finalStates;
	private Symbol[]	alphabet;
	
	public TransitionMatrix(NonFinalState[] nonFinalStates, FinalState[] finalStates, Symbol[] alphabet) {
		this.nonFinalStates = nonFinalStates;
		this.finalStates = finalStates;
		this.alphabet = alphabet;
		
		this.transitions = new HashMap<NonFinalState, ArrayList<Transition>>();
		for(NonFinalState state : nonFinalStates){
			this.transitions.put(state, new ArrayList<Transition>());
		}
	}	
	
	public void addTransition(Transition transition) throws Exception{
		if(!this.transitions.containsKey(transition.getInitialState()))
			throw new Exception("No existe el estado: "+transition.getInitialState().toString() + " en la matriz de transiciones");
		
		if(!alphabetHasSymbol(transition.getSymbol()))
			throw new Exception("No existe el simbolo '"+transition.getSymbol()+"' en el alfabeto");
		
		this.transitions.get(transition.getInitialState()).add(transition);
	}
	
	
	public ArrayList<Transition> getTransitions(State fromState){
		return this.transitions.get(fromState);
	}
	
	
	private boolean alphabetHasSymbol(Symbol s){		
		for(int i = 0; i < this.alphabet.length; i++){
			if(this.alphabet[i].equals(s))
				return true;
		}
		return false;
	}

	
	@Override
	public String toString() {
		String s = "\n [Alphabet]: "+Arrays.toString(alphabet)+
				   "\n [NonFinalStates]: {";
		
		for(NonFinalState state : this.nonFinalStates){
			s += state.getName() + ", ";
		}
		
		s += "}";
		
		s += "\n [FinalStates]: {";
		
		for(FinalState state : this.finalStates){
			s += state.getName() + ", ";
		}
		
		s += "}";
		s += "\n [Transitions]: \n";
		
		
		for(int i = 0; i < this.transitions.values().size(); i++){
			s += "\t " +this.transitions.values().toArray()[i].toString();			
		}
		
		return s;
	}

}
