package sintacticAnalizer;

public class Rule {
	private NonTerminalSymbol symbol;
	private RuleSymbol[] derivation;
	
	public Rule(NonTerminalSymbol symbol, RuleSymbol[] derivation) {
		this.symbol = symbol;
		this.derivation = derivation;
	}

	public NonTerminalSymbol getSymbol() {
		return symbol;
	}

	public RuleSymbol[] getDerivation() {
		return derivation;
	}
}
