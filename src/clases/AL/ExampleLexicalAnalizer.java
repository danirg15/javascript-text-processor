package AL;

import DFA.DFA;
import DFA.State;
import DFA.Transition;

public class ExampleLexicalAnalizer extends LexicalAnalizer{ 
	
	
	public ExampleLexicalAnalizer(SourceFile source, DFA automaton) {
		super(source, automaton);
	}

	@Override
	public Token getNewToken() throws Exception {	
		getAutomaton().restart();
		String tmp = "";
		Token token = null;
		State currentState;
		
		
		while(token == null){
			currentState = getAutomaton().getCurrentState();
			char c = (char) getSource().read();
					
			//Obtiene la que seria la proxima transicion desde el estado actual
			Transition tran = getAutomaton().getTransitionWithSymbol(currentState, c);
			
			//Si no hay ninguna transicion es porque el automatca no reconoce el simbolo
			if(tran == null)
				break;
			
			//Ejecuta Accion Semantica
			switch(tran.getSemanticAction()){
				case A:
					//ignora delimitiador
					break;
					
				case B: 
					tmp += c;
					getAutomaton().transit(c);
					break;
			
				case C:
					tmp += c;
					token = new Token(null, tmp);
			}
		}
	
		return token;
	}
	
	
}