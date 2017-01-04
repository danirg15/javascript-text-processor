package sintacticAnalizer;

import java.util.Stack;

import common.WriteToFile;

import semanticAnalizer.SemanticAction;
import lexicalAnalizer.LexicalAnalizer;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class SintacticAnalizer {
	private NonTerminalSymbol axiom;
	private Stack<Object> stack;
	private static Stack<GrammaticalSymbol> aux_stack;
	
	private LL1Table tableLL1;
	private LexicalAnalizer LexA;
	private Token EOFToken;
	private String parse = "";
	private WriteToFile writeToFile = new WriteToFile();
	
	public SintacticAnalizer(NonTerminalSymbol axiom, LL1Table tableLL1, LexicalAnalizer LexA){
		this.axiom = axiom;
		this.tableLL1 = tableLL1;
		this.LexA = LexA;
		this.EOFToken = new Token(TokenType.$, null);
		
		aux_stack = new Stack<GrammaticalSymbol>();
		this.stack = new Stack<Object>();
		this.stack.push(new TerminalSymbol(EOFToken)); //$
		this.stack.push(axiom);
	}
	
	public static Stack<GrammaticalSymbol> getAuxStack() {
		if(aux_stack == null) {
			System.err.println("Error aux_stack no inicializada");
		}
		return aux_stack;
	}
	
	public static void popAuxStack(int n) {
		for(int i = 0; i < n; i++){
			aux_stack.pop();
		}
	}
	
	
	public void analize() throws Exception{
		GrammaticalSymbol a = null;
		GrammaticalSymbol p = new TerminalSymbol(this.LexA.getNewToken());
		Object X = this.stack.lastElement();
		GrammaticalSymbol EOF = new TerminalSymbol(EOFToken); //$
		
		//Algoritmo http://www-lt.ls.fi.upm.es/compiladores/procesadores/Documentos/ll.pdf
		while(!X.equals(EOF) /*&& !aux_stack.lastElement().equals(this.axiom)*/) {
			a = p;
			
			if(X instanceof TerminalSymbol){
				if(((TerminalSymbol) X).match(a)){
					Object o = this.stack.pop();
					aux_stack.push((GrammaticalSymbol) o);
					
					Token t = this.LexA.getNewToken();
					
					p = new TerminalSymbol(t);//Next Token
					
					if(t.getType() == TokenType.ID) {
						for(int i = stack.size()-1; i >= 0 ;i--) {
							if(stack.elementAt(i) instanceof TerminalSymbol){
								stack.setElementAt(new TerminalSymbol(t), i);
								break;
							}
						}
					}
					
					
				}
				else{
					System.err.println("Error semantico 1 -> Linea " + LexicalAnalizer.currentLine);
					System.exit(-1);
				}
			}
			else if(X instanceof NonTerminalSymbol){
				
				SintacticRule rule = this.tableLL1.getRule((NonTerminalSymbol) X, (TerminalSymbol) a);
				
				if(rule != null){
					System.out.print(rule);
					this.parse += " " + rule.getId();
					
					Object o = this.stack.pop();
					aux_stack.push((GrammaticalSymbol) o);
					
					//Mete en la pila los simbolos inversamente
					Object derivations[] = rule.getDerivation();
					for(int i = derivations.length-1; i>=0; i--){	
						Object s = derivations[i];
						
						if(s instanceof TerminalSymbol &&
						  ((TerminalSymbol)s).getToken().getType() == TokenType.LAMBDA) {
							continue;
						}
						
						this.stack.push(s);
					}
				
				}
				else{
					System.err.println("Error semantico 2 -> Linea " + LexicalAnalizer.currentLine);
					System.exit(-1);
				}
			}
			else if(X instanceof SemanticAction) {
				((SemanticAction) X).exec();
				this.stack.pop();
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

