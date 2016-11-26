package sintacticAnalizer;

public class NonTerminalSymbol implements GrammaticalSymbol {
	private String symbol;

	public NonTerminalSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol(){
		return this.symbol;
	}

	public String getHash(){
		return symbol;
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
