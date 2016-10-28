package Test;

import java.util.HashMap;

import tables.AttrTable;
import tables.Entry;
import tables.SymbolTable;
import extra.HexadecimalValues;
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
	private AttrTable tablePR;
	private SymbolTable symbolTable;
	private HashMap<String, Integer> hex;
	
	public JavascriptLexicalAnalizer(SourceFile source, DFA automaton, AttrTable tablePR, SymbolTable symbolTable) {
		super(source, automaton);
		this.tablePR = tablePR;
		this.symbolTable = symbolTable;
		this.hex = HexadecimalValues.get();
	}

	@Override
	public Token getNewToken() throws Exception {			
		getAutomaton().restart();
		String concat = "";
		int number = 0;
		Token token = null;
		State currentState;
		
		int ascii = getSource().read();
		if(ascii == -1)
			return new Token(TokenType.$, null);
		
		char c = (char)ascii;
		
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
					int index;
					if((index = this.tablePR.find(concat)) != -1){
						token = new Token(TokenType.PR, "TS("+index+") "+ concat);
					}
					else if(this.symbolTable.search(concat) != null){
						//locallizar identificadores
						token = new Token(TokenType.ID, concat);
					}
					else{
						this.symbolTable.add(new Entry(concat));
						token = new Token(TokenType.ID, concat);
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
									
			}
		}
	
		return token;
	}
	

}
