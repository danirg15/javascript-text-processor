package sintacticAnalizer;

import lexicalAnalizer.Token;


public class TerminalSymbol implements RuleSymbol {
	private Token token;
	
	public TerminalSymbol(Token token){
		this.token = token;
	}

	public Token getToken() {
		return token;
	}	
	
	public boolean equals(Object o){
		if((o instanceof TerminalSymbol)  &&
			this.token.equals(((TerminalSymbol)o).getToken())){
			return true;
		}
		return false;
	}
}
