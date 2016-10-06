package AL;

import DFA.DFA;
import DFA.State;
import DFA.Transition;

public class ExampleLexicalAnalizer extends LexicalAnalizer{ 
	String tok = "";
	
	public ExampleLexicalAnalizer(SourceFile source, DFA automaton) {
		super(source, automaton);
	}

	@Override
	public Token getNewToken() throws Exception {		
		State currentState = getAutomaton().getCurrentState();
		char c = (char) getSource().read();
				
		Transition tran = getAutomaton().getTransitionWithSymbol(currentState, c);
		
		if(tran == null) 
			return null;
		
	
		System.out.println("Red: " + c);
		
		
		
		switch(tran.getAction()){
			case A: 
				tok += c;
				getAutomaton().transit(currentState, c);
				
				break;
		
			case B:
				tok += c;
				System.out.println("gen token: "+ tok);
				
				break;
				
		}
	
		return null;
	}
	
	
	public void step(){
		
	}
	
}