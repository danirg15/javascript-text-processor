package tables;

import java.util.HashMap;

public class SymbolTable {

	private HashMap<String, Entry> table;
	
	public SymbolTable(){
		this.table = new HashMap<String, Entry>();
	}
	
	public void add(Entry e){
		if(!this.table.containsKey(e.getName())){
			this.table.put(e.getName(), e);
		}
	}
	
	public Entry search(String name){
		return this.table.get(name);
	}
	
}
