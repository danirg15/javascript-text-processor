package sintacticAnalizer;

import java.util.HashMap;

public class LL1Table {
	private HashMap<NonTerminalSymbol, HashMap<TerminalSymbol,Rule>> table;
	
	public LL1Table (){
		this.table = new HashMap<NonTerminalSymbol, HashMap<TerminalSymbol, Rule>>();
	}
	
	public void addRow(NonTerminalSymbol nonTerminal, HashMap<TerminalSymbol,Rule> row){
		this.table.put(nonTerminal, row);
	}
	
	public Rule getRule(NonTerminalSymbol nonTerminalSymbol , RuleSymbol symbol){
		return this.table.get(nonTerminalSymbol).get(symbol);		
	}
}
