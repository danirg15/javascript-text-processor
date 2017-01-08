package symbolTable;

import java.util.HashMap;

public class SymbolTable {
	private int id;
	private String name;
	private HashMap<String, Entry> table;
	
	public SymbolTable(int id, String name){
		this.id = id;
		this.name = name;
		this.table = new HashMap<String, Entry>();
	}
	
	
	
	public HashMap<String, Entry> getTable() {
		return table;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void add(Entry e){
		if(!this.table.containsKey(e.getLex())){
			this.table.put(e.getLex(), e);
		}
	}
	
	public Entry search(String name){
		return this.table.get(name);
	}
	
	public void insertType(String lex, Types type) {
		this.search(lex).setType(type);
	}
	
	public void insertRetType(String lex, Types type) {
		this.search(lex).setReturnedType(type);
	}
	
	public void insertOffset(String lex, int offset) {
		this.search(lex).setOffset(offset);
	}
	
	public void increaseArgs(String lex) {
		Entry e = this.search(lex);
		e.setnArgs( e.getnArgs() + 1 );
	}
	
	public Types findType(String lex) {
		return this.search(lex).getType();
	}
	
}