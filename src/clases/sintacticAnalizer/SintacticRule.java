package sintacticAnalizer;

public class SintacticRule {
	private int id;
	private NonTerminalSymbol symbol;
	private GrammaticalSymbol[] derivation;
	
	public SintacticRule(int id, NonTerminalSymbol symbol, GrammaticalSymbol[] derivation) {
		this.id = id;
		this.symbol = symbol;
		this.derivation = derivation;
	}

	public NonTerminalSymbol getSymbol() {
		return symbol;
	}

	public GrammaticalSymbol[] getDerivation() {
		return derivation;
	}
	
	

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		String s = "Rule "+id+": " + symbol +" -> ";
		
		for(GrammaticalSymbol symbol : this.derivation){
			s += symbol + " ";
		}
		
		return s + "\n";
	}
	
	
}
