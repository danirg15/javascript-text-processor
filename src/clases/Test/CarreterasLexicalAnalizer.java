package Test;

import AL.LexicalAnalizer;
import AL.SourceFile;
import AL.Token;
import AL.TokenType;
import DFA.DFA;
import DFA.FinalState;
import DFA.State;
import DFA.Transition;

public class CarreterasLexicalAnalizer extends LexicalAnalizer{

	public CarreterasLexicalAnalizer(SourceFile source, DFA automaton) {
		super(source, automaton);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Token getNewToken() throws Exception {	
		getAutomaton().restart();
		String concat = "";
		Token token = null;
		State currentState;
		
		char c = (char) getSource().read();
		currentState = getAutomaton().getCurrentState();
		
		while(!(currentState instanceof FinalState)){
			
			//Obtiene la que seria la proxima transicion desde el estado actual
			Transition tran = getAutomaton().getTransitionWithSymbol(currentState, c);
			
			//Si no hay ninguna transicion es porque el automatca no reconoce el simbolo
			if(tran == null)
				break;//generar error
			
			getAutomaton().transit(c);
			currentState = getAutomaton().getCurrentState();
			
			//Ejecuta Accion Semantica
			switch(tran.getSemanticAction()){
				case A:
					c = (char) getSource().read();
					break;
					
				case B: 
					concat += c;
					c = (char) getSource().read();
					break;
			
				case C:
					token = new Token(TokenType.CAD, concat);
					break;
					
				case D:
					token = new Token(TokenType.CR, null);
					break;
				
				case E:
					concat += c;
					token = new Token(TokenType.KM, concat);
					break;
					
				case F:
					token = new Token(TokenType.KM, concat);
					break;
				
				case G:
					token = new Token(TokenType.CARRETERA, concat);
					break;
					
				case H:
					token = new Token(null, concat);
					break;
			}
		}
	
		return token;
	}
	

}
