package Test;

import extra.SourceFile;
import analizer.LexicalAnalizer;
import analizer.Token;
import analizer.TokenType;
import automata.DFA;
import automata.FinalState;
import automata.State;
import automata.Transition;
import ErrorModule.ErrorGen;
import ST.AttrTable;

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
			if(tran == null){
				System.err.println("Error in : " + concat);
				break;//generar error
			}
				
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
					int i = concat.indexOf("-");
					int num = Integer.valueOf(concat.charAt(i+1)+"");//Primer numero de la carretera
										
					if(num >= 1 && num <= 6)		
						token = new Token(TokenType.CARRETERA, concat);
					else
						ErrorGen.throwError("El primer digito de la carretera debe estar entre 1 y 6");
					
					break;
					
				case H:
					int pos = AttrTable.find(concat);
					
					if(pos != -1)
						token = new Token(null, "tabAttr("+pos+")");
					else
						ErrorGen.throwError("No se encuentra "+concat+" en la tabla de atributos");
					
					break;
			}
		}
	
		return token;
	}
	

}
