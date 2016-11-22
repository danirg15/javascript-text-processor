package sintacticAnalizer;

public class NonTerminalSymbol implements RuleSymbol {
	private String symbol;

	public NonTerminalSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol(){
		return this.symbol;
	}

}
