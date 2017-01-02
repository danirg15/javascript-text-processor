package sintacticAnalizer;

import java.util.Stack;

import extra.WriteToFile;
import lexicalAnalizer.JSLexicalAnalizer;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class SintacticAnalizer {
	private Stack<GrammaticalSymbol> stack;
	private LL1Table tableLL1;
	private JSLexicalAnalizer LexA;
	private Token EOFToken;
	private String parse = "";
	private WriteToFile writeToFile = new WriteToFile();
	
	public SintacticAnalizer(NonTerminalSymbol axiom, LL1Table tableLL1, JSLexicalAnalizer LexA){
		this.tableLL1 = tableLL1;
		this.LexA = LexA;
		this.EOFToken = new Token(TokenType.$, null);
		
		this.stack = new Stack<GrammaticalSymbol>();
		this.stack.push(new TerminalSymbol(EOFToken));
		this.stack.push(axiom);
	}
	
	public void analize() throws Exception{
		GrammaticalSymbol a = null;
		GrammaticalSymbol p = new TerminalSymbol(this.LexA.getNewToken());
		GrammaticalSymbol X = this.stack.lastElement();
		GrammaticalSymbol EOF = new TerminalSymbol(EOFToken); //$
		
		//Algoritmo http://www-lt.ls.fi.upm.es/compiladores/procesadores/Documentos/ll.pdf
		while(!X.equals(EOF)) {
			a = p;
			
			if(X instanceof TerminalSymbol){
				if(((TerminalSymbol) X).match(a)){
					this.stack.pop();
					p = new TerminalSymbol(this.LexA.getNewToken());//Next Token
				}
				else{
					System.err.println("Error semantico 1 -> Linea "+this.LexA.currentLine());
					System.exit(-1);
				}
			}
			else{
				
				SintacticRule rule = this.tableLL1.getRule((NonTerminalSymbol) X, (TerminalSymbol) a);
				
			
				if(rule != null){
					System.out.print(rule);
					this.parse += " " + rule.getId();
					
					this.stack.pop();
					
					//Mete en la pila los simbolos inversamente
					GrammaticalSymbol derivations[] = rule.getDerivation();
					for(int i = derivations.length-1; i>=0; i--){	
						GrammaticalSymbol s = derivations[i];
						
						if(s instanceof TerminalSymbol &&
						  ((TerminalSymbol)s).getToken().getType() == TokenType.LAMBDA) {
							continue;
						}
						
						this.stack.push(s);
					}
				
				}
				else{
					System.err.println("Error semantico 2 -> Linea " + this.LexA.currentLine());
					System.exit(-1);
				}
			}
			
			X = this.stack.lastElement();
		}//while
		
		if(a.equals(EOF)){
			System.out.println("Acepta, Parse: "+parse);
			this.writeToFile.parse(parse);
		}
		else{
			System.out.println("Error, No Acepta");
			System.exit(-1);
		}
	}
	
}

