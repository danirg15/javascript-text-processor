package sintacticAnalizer;

import semanticAnalizer.SemanticAction;

public class SintacticRule {
	private int id;
	private NonTerminalSymbol symbol;
	private Object[] derivation;
	
	public SintacticRule(int id, NonTerminalSymbol symbol, Object[] derivation) {
		this.id = id;
		this.symbol = symbol;
		this.derivation = derivation;
	}

	public NonTerminalSymbol getSymbol() {
		return symbol;
	}

	public Object[] getDerivation() {
		return derivation;
	}
	
	

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		String s = "Rule "+id+": " + symbol +" -> ";
		
		for(Object symbol : this.derivation){
			if(symbol instanceof SemanticAction){
				s += "SemAct" + " ";
			}else{
				s += symbol + " ";
			}
		}
		
		return s + "\n";
	}
	
	
}
