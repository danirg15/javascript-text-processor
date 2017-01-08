package lexicalAnalizer;

import java.io.IOException;
import java.util.HashMap;

import common.AttrTable;
import common.HexadecimalValues;
import common.SourceFile;
import common.WriteToFile;
import errorManager.ErrorManager;
import errorManager.ErrorTypes;
import semanticAnalizer.SemanticAnalizer;
import symbolTable.Entry;
import automata.DFA;
import automata.FinalState;
import automata.State;
import automata.Transition;


public class LexicalAnalizer {
	private SourceFile source;
	private DFA automaton;
	private AttrTable tablePR;
	private HashMap<String, Integer> hex = HexadecimalValues.get();
	private WriteToFile writeToFile;
	public static int currentLine = 0;
	
	public LexicalAnalizer(SourceFile source, DFA automaton, AttrTable tablePR) {
		this.source = source;
		this.automaton = automaton;
		this.tablePR = tablePR;
		this.writeToFile = new WriteToFile();
	}
	

	public Token getNewToken() throws Exception {			
		this.automaton.restart();
		String concat = "";
		int number = 0;
		Token token = null;
		State currentState = this.automaton.getCurrentState();
		
		int ascii = this.source.getCurrentChar();
		if(ascii == -1){
			Token t = new Token(TokenType.$, null);
			this.writeToFile.token(tablePR, t);
			return t;
		}
			
		char c = (char)ascii;
				
		while(!(currentState instanceof FinalState)){			
			//Obtiene la que seria la proxima transicion desde el estado actual
			Transition tran = this.automaton.getTransitionWithSymbol(currentState, c);
			
			//Si no hay ninguna transicion es porque el automatca no reconoce el simbolo
			if(tran == null){
				ErrorManager.notify(ErrorTypes.LEX, "No se reconoce el token " + concat + c);
				break;//generar error
			}
				
			this.automaton.transit(c);
			currentState = this.automaton.getCurrentState();
			
			//Ejecuta Accion Semantica
			switch(tran.getSemanticAction()){
				case A:
					int tmp =  this.source.read();
					
					if(tmp == -1)
						return new Token(TokenType.$, null);
					
					c = (char) tmp;
					
					break;
					
				case B: 
					concat += c;
					c = (char) this.source.read();
					break;
			
				case C:
					token = new Token(TokenType.AND, null);
					c = (char) this.source.read();
					break;
					
				case D:
					concat = c + "";
					c = (char) this.source.read();
					break;
				
				case E:
					concat += c;
					c = (char) this.source.read();
					break;
					
				case F:					
					
					int index;
					if((index = this.tablePR.find(concat)) != -1){ //Es palabra reservada
						token = new Token(TokenType.PR, index+"");
					}
					else if(SemanticAnalizer.dec_zone == true) { //Se esta declarando una variable
						if(SemanticAnalizer.currentTS.search(concat) != null){
							ErrorManager.notify(ErrorTypes.LEX, "La variable '"+ concat +"' ya ha sido declarada");
							token = new Token(TokenType.ID, concat);
						}
						else {
							SemanticAnalizer.currentTS.add(new Entry(concat));
							token = new Token(TokenType.ID, concat);
						}
					}
					else if(SemanticAnalizer.findInAllTS(concat) == null) { //Si se usa una variable no declarada			
						ErrorManager.notify(ErrorTypes.LEX, "La variable '"+ concat +"' no ha sido declarada");
						token = new Token(TokenType.ID, concat);
					}
					else {
						token = new Token(TokenType.ID, concat);
					}
								
					break;
					
				case G:
					number = Integer.valueOf(c+"");
					c = (char) this.source.read();
					break;
					
				case H:
					number = number * 10 + Integer.valueOf(c + "");		
					c = (char) this.source.read();
					break;
					
				case I:
					checkNumberOverflow(number);
					token = new Token(TokenType.ENT, number+"");
					break;
					
				case J:
					number = 0;
					c = (char) this.source.read();
					break;
				
				case K:
					token = new Token(TokenType.ENT, 0 + "");
					break;
					
				case L:
					number = Integer.valueOf(hex.get(c+""));
					c = (char) this.source.read();
					break;
					
				case M:
					number = number * 16 + Integer.valueOf(hex.get(c+""));
					c = (char) this.source.read();
					break;
					
				case N:
					checkNumberOverflow(number);
					token = new Token(TokenType.ENT, number + "");
					break;
					
				case O:
					number = Integer.valueOf(c+"");
					c = (char) this.source.read();
					break;
				
				case P:
					number = number * 8 + Integer.valueOf(c+"");
					c = (char) this.source.read();
					break;
				
				case Q:
					checkNumberOverflow(number);
					token = new Token(TokenType.ENT, number + "");
					break;
				
				case R:
					token = new Token(TokenType.LLAVE, "1");
					c = (char) this.source.read();
					break;
				
				case S:
					token = new Token(TokenType.LLAVE, "2");
					c = (char) this.source.read();
					break;
					
				case T:
					token = new Token(TokenType.PARENT, "1");
					c = (char) this.source.read();
					break;
					
				case U: 
					token = new Token(TokenType.PARENT, "2");
					c = (char) this.source.read();
					break;
					
				case V:
					token = new Token(TokenType.MAS, null);
					c = (char) this.source.read();
					break;
					
				case W:
					token = new Token(TokenType.MENOS, null);
					c = (char) this.source.read();
					break;
					
				case X:
					token = new Token(TokenType.ASIGN, null);
					c = (char) this.source.read();
					break;
					
				case Y:
					token = new Token(TokenType.DOS_PUNTOS, null);
					c = (char) this.source.read();
					break;
					
				case Z:
					token = new Token(TokenType.INTERR, null);
					c = (char) this.source.read();
					break;
					
				case AA:
					token = new Token(TokenType.MAYOR, null);
					c = (char) this.source.read();
					break;
					
				case BB:
					token = new Token(TokenType.MENOR, null);
					c = (char) this.source.read();
					break;
					
				case CC:
					token = new Token(TokenType.COMA, null);
					c = (char) this.source.read();
					break;
					
				case DD:
					token = new Token(TokenType.EXCLA, null);
					c = (char) this.source.read();
					break;
					
				case EE:
					token = new Token(TokenType.CR, null);
					currentLine++;
					c = (char) this.source.read();
					break;
					
				case FF:
					token = new Token(TokenType.STRING, concat);
					c = (char) this.source.read();
					break;
				
				case GG: 
					token = new Token(TokenType.PUNTO_COMA, null);
					c = (char) this.source.read();
					break;				
			}
		}
		
		this.writeToFile.token(tablePR, token);
	
		return token;
	}
	
	private void checkNumberOverflow(int number) throws IOException{
		if(number > 32767){
			ErrorManager.notify(ErrorTypes.LEX, "El numero "+ number + " no se puede representar con 2 bytes");
		}
	}
	
}
