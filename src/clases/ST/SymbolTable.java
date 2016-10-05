package ST;

import java.util.HashMap;

public class SymbolTable {

	private HashMap<String, Entry> table;
	
	public SymbolTable(){
		this.table = new HashMap<String, Entry>();
	}
	
	public Entry search(String lex){
		return this.table.get(lex);
	}
	
	public void add(Entry e){
		if(this.table.containsKey(e.name)){
			
		}
		
	}
	
}
