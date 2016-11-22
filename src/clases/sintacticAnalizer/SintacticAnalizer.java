package sintacticAnalizer;

import java.util.Stack;

import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class SintacticAnalizer {
	private Stack<RuleSymbol> stack;
	private LL1Table table;
	private Token tokens[];
	private Token EOFToken;
	
	public SintacticAnalizer(LL1Table table, Token tokens[]){//? Nos pasan todos los tokens juntos. No deberia el analizador
															//ir pidiendo uno a uno
		this.table = table;
		this.tokens = tokens;
		this.EOFToken = new Token(TokenType.$, null);
		
		this.stack = new Stack<RuleSymbol>();
		this.stack.push(new TerminalSymbol(EOFToken));
	}
	
	public void analize(){
		int tokensInx = 0;
		RuleSymbol a;
		RuleSymbol p = new TerminalSymbol(this.tokens[tokensInx]);
		RuleSymbol X = null;
		RuleSymbol EOF = new TerminalSymbol(EOFToken);
		
		while(!X.equals(EOF)) {
			X = this.stack.lastElement();
			a = p;
			
			if(X instanceof TerminalSymbol){
				if(X.equals(a)){
					this.stack.pop();
					tokensInx++;
					p = new TerminalSymbol(this.tokens[tokensInx]);
				}
				else{
					System.err.println("Error semantico 1");
				}
			}
			else{
				Rule rule = this.table.getRule((NonTerminalSymbol) X, a);
				
				if(rule != null){
					this.stack.pop();
					RuleSymbol derivations[] = rule.getDerivation();
					for(int i = derivations.length-1; i>=0; i++){
						this.stack.push(derivations[i]);
					}
				
				}
				else{
					System.err.println("Error semantico 2");
				}
			}
		}//while
		
		if(X.equals(EOF)){
			System.out.println("Acepta");
		}
		else{
			System.out.println("Error, No Acepta");
		}
	}
	
}

