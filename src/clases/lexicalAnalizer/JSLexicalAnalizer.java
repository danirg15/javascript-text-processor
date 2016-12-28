package lexicalAnalizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import tables.AttrTable;
import tables.Entry;
import tables.SymbolTable;
import extra.HexadecimalValues;
import extra.SourceFile;
import automata.DFA;
import automata.FinalState;
import automata.State;
import automata.Transition;


public class JSLexicalAnalizer extends LexicalAnalizer{
	private AttrTable tablePR;
	private SymbolTable symbolsTable;
	private HashMap<String, Integer> hex;
	
	public JSLexicalAnalizer(SourceFile source, DFA automaton, AttrTable tablePR, SymbolTable symbolsTable) {
		super(source, automaton);
		this.tablePR = tablePR;
		this.symbolsTable = symbolsTable;
		this.hex = HexadecimalValues.get();
	}
	

	public void writeTokenToFile(Token token) throws IOException{
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try{
			File file = new File("./tokens.txt");

			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

		    
		    if(token.getAttr() != null){
		    	if(token.getType() == TokenType.PR){
		    		bw.write("<"+token.getType()+", "+ token.getAttr() +"> //"+this.tablePR.getAtIndex(Integer.parseInt(token.getAttr()))+"  \n");
		    	}else{
		    		bw.write("<"+token.getType()+", "+ token.getAttr() +">\n");
		    	}	
		    }
		    else{
		    	bw.write("<"+token.getType()+", >\n");
		    }
		    
		    bw.close();
			fw.close();
		} catch (IOException e) {
		   System.err.println("Error al escribir fichero ");
		   bw.close();
		   fw.close();
		}
	}
	

	@Override
	public Token getNewToken() throws Exception {			
		getAutomaton().restart();
		String concat = "";
		int number = 0;
		Token token = null;
		State currentState = getAutomaton().getCurrentState();
		
		int ascii = getSource().getCurrentChar();
		if(ascii == -1){
			Token t = new Token(TokenType.$, null);
			this.writeTokenToFile(t);
			return t;
		}
			
		char c = (char)ascii;
				
		while(!(currentState instanceof FinalState)){			
			//Obtiene la que seria la proxima transicion desde el estado actual
			Transition tran = getAutomaton().getTransitionWithSymbol(currentState, c);
			
			//Si no hay ninguna transicion es porque el automatca no reconoce el simbolo
			if(tran == null){
				System.err.println("Lexical Analizer. Error in : " + concat + c);
				break;//generar error
			}
				
			getAutomaton().transit(c);
			currentState = getAutomaton().getCurrentState();
			
			//Ejecuta Accion Semantica
			switch(tran.getSemanticAction()){
				case A:
					int tmp =  getSource().read();
					
					if(tmp == -1)
						return new Token(TokenType.$, null);
					
					c = (char) tmp;
					
					break;
					
				case B: 
					concat += c;
					c = (char) getSource().read();
					break;
			
				case C:
					token = new Token(TokenType.AND, null);
					c = (char) getSource().read();
					break;
					
				case D:
					concat = c + "";
					c = (char) getSource().read();
					break;
				
				case E:
					concat += c;
					c = (char) getSource().read();
					break;
					
				case F:					
					//comprueba tabla de atributos y simbolo
					//Falta completar
					int index;
					if((index = this.tablePR.find(concat)) != -1){
						token = new Token(TokenType.PR, index+"");
					}
					else if(this.symbolsTable.search(concat) != null){
						//locallizar identificadores
						token = new Token(TokenType.ID, concat);
					}
					else{
						this.symbolsTable.add(new Entry(concat));
						token = new Token(TokenType.ID, concat);
					}
					
					
					break;
					
				case G:
					number = Integer.valueOf(c+"");
					c = (char) getSource().read();
					break;
					
				case H:
					number = number * 10 + Integer.valueOf(c + "");		
					c = (char) getSource().read();
					break;
					
				case I:
					checkNumberOverflow(number);
					token = new Token(TokenType.ENT, number+"");
					break;
					
				case J:
					number = 0;
					c = (char) getSource().read();
					break;
				
				case K:
					token = new Token(TokenType.ENT, 0 + "");
					break;
					
				case L:
					number = Integer.valueOf(hex.get(c+""));
					c = (char) getSource().read();
					break;
					
				case M:
					number = number * 16 + Integer.valueOf(hex.get(c+""));
					c = (char) getSource().read();
					break;
					
				case N:
					checkNumberOverflow(number);
					token = new Token(TokenType.ENT, number + "");
					break;
					
				case O:
					number = Integer.valueOf(c+"");
					c = (char) getSource().read();
					break;
				
				case P:
					number = number * 8 + Integer.valueOf(c+"");
					c = (char) getSource().read();
					break;
				
				case Q:
					checkNumberOverflow(number);
					token = new Token(TokenType.ENT, number + "");
					break;
				
				case R:
					token = new Token(TokenType.LLAVE, "1");
					c = (char) getSource().read();
					break;
				
				case S:
					token = new Token(TokenType.LLAVE, "2");
					c = (char) getSource().read();
					break;
					
				case T:
					token = new Token(TokenType.PARENT, "1");
					c = (char) getSource().read();
					break;
					
				case U: 
					token = new Token(TokenType.PARENT, "2");
					c = (char) getSource().read();
					break;
					
				case V:
					token = new Token(TokenType.MAS, null);
					c = (char) getSource().read();
					break;
					
				case W:
					token = new Token(TokenType.MENOS, null);
					c = (char) getSource().read();
					break;
					
				case X:
					token = new Token(TokenType.ASIGN, null);
					c = (char) getSource().read();
					break;
					
				case Y:
					token = new Token(TokenType.DOS_PUNTOS, null);
					c = (char) getSource().read();
					break;
					
				case Z:
					token = new Token(TokenType.INTERR, null);
					c = (char) getSource().read();
					break;
					
				case AA:
					token = new Token(TokenType.MAYOR, null);
					c = (char) getSource().read();
					break;
					
				case BB:
					token = new Token(TokenType.MENOR, null);
					c = (char) getSource().read();
					break;
					
				case CC:
					token = new Token(TokenType.COMA, null);
					c = (char) getSource().read();
					break;
					
				case DD:
					token = new Token(TokenType.EXCLA, null);
					c = (char) getSource().read();
					break;
					
				case EE:
					token = new Token(TokenType.CR, null);
					c = (char) getSource().read();
					break;
					
				case FF:
					token = new Token(TokenType.STRING, concat);
					c = (char) getSource().read();
					break;
				
				case GG: 
					token = new Token(TokenType.PUNTO_COMA, null);
					c = (char) getSource().read();
					break;				
			}
		}
		
		this.writeTokenToFile(token);
	
		return token;
	}
	
	private void checkNumberOverflow(int number){
		if(number > 32767){
			System.err.println("El numero "+ number + " no se puede representar con 2 bytes");
			System.exit(-1);
		}
	}
	

}
