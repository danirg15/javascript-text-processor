package sintacticAnalizer;

import semanticAnalizer.Attribute;

public class NonTerminalSymbol implements GrammaticalSymbol {
	private String symbol;
	private Attribute attribute;

	public NonTerminalSymbol(String symbol) {
		this.symbol = symbol;
		this.attribute = new Attribute();
	}

	public String getSymbol(){
		return this.symbol;
	}

	public String getHash(){
		return symbol;
	}
		
	
	public Attribute getAttribute() {
		return attribute;
	}

//	public void setAttribute(Attribute attribute) {
//		this.attribute = attribute;
//	}
	

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return symbol;
	}

	@Override
	public boolean match(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
}
