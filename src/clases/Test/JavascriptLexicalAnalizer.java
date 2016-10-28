package Test;

import java.util.HashMap;

import tables.AttrTable;
import extra.SourceFile;
import analizer.LexicalAnalizer;
import analizer.Token;
import analizer.TokenType;
import automata.DFA;
import automata.FinalState;
import automata.State;
import automata.Transition;
import ErrorModule.ErrorGen;

public class JavascriptLexicalAnalizer extends LexicalAnalizer{
	
	private AttrTable attrTable;
	private HashMap<String, Integer> hex = new HashMap<String, Integer>();
	

	public JavascriptLexicalAnalizer(SourceFile source, DFA automaton, AttrTable attrTable) {
		super(source, automaton);
		// TODO Auto-generated constructor stub
		this.attrTable = attrTable;
		
		hex.put("0", 0);
		hex.put("1", 1);
		hex.put("2", 2);
		hex.put("3", 3);
		hex.put("4", 4);
		hex.put("5", 5);
		hex.put("6", 6);
		hex.put("7", 7);
		hex.put("8", 8);
		hex.put("9", 9);
		hex.put("A", 10);
		hex.put("B", 11);
		hex.put("C", 12);
		hex.put("D", 13);
		hex.put("E", 14);
		hex.put("F", 15);
	}

	@Override
	public Token getNewToken() throws Exception {			
		getAutomaton().restart();
		String concat = "";
		int number = 0;
		Token token = null;
		State currentState;
		
		char c = (char) getSource().read();
		currentState = getAutomaton().getCurrentState();
		
		while(!(currentState instanceof FinalState)){			
			//Obtiene la que seria la proxima transicion desde el estado actual
			Transition tran = getAutomaton().getTransitionWithSymbol(currentState, c);
			
			//Si no hay ninguna transicion es porque el automatca no reconoce el simbolo
			if(tran == null){
				System.err.println("Error in : " + concat + c);
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
					token = new Token(TokenType.LLAVE, "1");
					break;
			
				case C:
					token = new Token(TokenType.LLAVE, "2");
					break;
					
				case D:
					token = new Token(TokenType.PARENT, "1");
					break;
				
				case E:
					token = new Token(TokenType.PARENT, "2");
					break;
					
				case F:
					token = new Token(TokenType.COMA, null);
					break;
					
				case G:
					token = new Token(TokenType.EXCLA, null);
					break;
					
				case H:
					token = new Token(TokenType.MAYOR, null);
					break;
					
				case I:
					token = new Token(TokenType.MENOR, null);
					break;
					
				case J:
					token = new Token(TokenType.INTERR, null);
					break;
				
				case K:
					token = new Token(TokenType.DOS_PUNTOS, null);
					break;
					
				case L:
					token = new Token(TokenType.ASIGN, null);
					break;
					
				case M:
					token = new Token(TokenType.MENOS, null);
					break;
					
				case N:
					token = new Token(TokenType.MAS, null);
					break;
					
				case O:
					number = Integer.valueOf(c+"");
					c = (char) getSource().read();
					break;
				
				case P:
					number = number * 10 + Integer.valueOf(c+"");
					c = (char) getSource().read();
					break;
				
				case Q:
					token = new Token(TokenType.ENT, number+"");
					break;
				
				case R:
					concat = String.valueOf(c);  
					c = (char) getSource().read();
					break;
				
				case S:
					concat += c;
					c = (char) getSource().read();
					break;
					
				case T:
					//comprueba tabla de atributos y simbolo
					//Falta completar
					
					if(this.attrTable.find(concat) != -1){
						token = new Token(TokenType.PR, concat);
					}
					else{
						//locallizar identificadores
						token = new Token(null, concat);
					}
					
					
					break;
					
				case U: 
					number = Integer.valueOf(c+"");
					c = (char) getSource().read();
					break;
				
				case UU:
					number = number * 8 + Integer.valueOf(c+"");
					c = (char) getSource().read();
					break;
				
				case V:
					token = new Token(TokenType.ENT, number+"");
					c = (char) getSource().read();
					break;
					
				case XX:
					number = Integer.valueOf(hex.get(c+""));
					c = (char) getSource().read();
					break;
					
				case W:
					number = number * 16 + Integer.valueOf(hex.get(c+""));
					c = (char) getSource().read();
					break;
					
				case X:
					token = new Token(TokenType.ENT, number+"");
					break;
					
				case AA:
					concat += String.valueOf(c);
					c = (char) getSource().read();
					break;
					
				case AB:
					token = new Token(TokenType.STRING, concat);
					break;
					
				case Z:
					break;
					
			}
		}
	
		return token;
	}
	

}
