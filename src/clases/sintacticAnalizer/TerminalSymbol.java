package sintacticAnalizer;

import lexicalAnalizer.Token;
import semanticAnalizer.Attribute;


public class TerminalSymbol implements GrammaticalSymbol {
	private Token token;
	private Attribute attribute;
	
	public TerminalSymbol(Token token){
		this.token = token;
		this.attribute = new Attribute();
	}

	public Token getToken() {
		return token;
	}	
	
	public Attribute getAttribute() {
		return attribute;
	}

//	public void setAttribute(Attribute attribute) {
//		this.attribute = attribute;
//	}

	public boolean equals(Object o){
		if((o instanceof TerminalSymbol)  &&
				this.token.equals(((TerminalSymbol)o).getToken())){
			return true;
		}
		return false;
	}
	
	public boolean match(Object o){
		if((o instanceof TerminalSymbol)  &&
				this.token.match(((TerminalSymbol)o).getToken())){
			return true;
		}
		return false;
	}
	

	

	@Override
	public String toString() {
		if(token.getAttr() == null) {
			return token.getType().name();
		}
		
		return token.getType().name() +"("+ token.getAttr()+")";
	}
	
	
}
