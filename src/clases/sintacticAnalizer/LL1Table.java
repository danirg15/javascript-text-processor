package sintacticAnalizer;

import java.util.HashMap;

public class LL1Table {
	private HashMap<String, HashMap<String,SintacticRule>> table;
	
	public LL1Table (){
		this.table = new HashMap<String, HashMap<String, SintacticRule>>();
	}
	
	public void addRule(NonTerminalSymbol nonTerminal, TerminalSymbol terminal, SintacticRule rule){
		if(!this.table.containsKey(nonTerminal.getHash())){
			this.table.put(nonTerminal.getHash(), new HashMap<String, SintacticRule>());
		}
		
		this.table.get(nonTerminal.getHash()).put(terminal.getToken().getHash(), rule);
	}
	
	public SintacticRule getRule(NonTerminalSymbol nonTerminalSymbol , TerminalSymbol terminalSymbol){
		if(!this.table.containsKey(nonTerminalSymbol.getHash())){
			System.err.println("No existe "+ nonTerminalSymbol.toString() +"en la tabla del A. Sintactico");
			System.exit(-1);
		}
		
		return this.table.get(nonTerminalSymbol.getHash()).get(terminalSymbol.getToken().getHash());		
	}

	@Override
	public String toString() {	
		return "LL1Table [table=\n\n" + table + "]";
	}
	
	
}
