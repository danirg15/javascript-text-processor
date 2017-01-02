package symbolTable;

import java.io.IOException;
import java.util.HashMap;

import extra.WriteToFile;


public class TSContainer {
	private HashMap<Integer, SymbolTable> tables;
	private int id_counter;
	private WriteToFile writeToFile;
	
	public TSContainer() {
		this.tables = new HashMap<Integer, SymbolTable>();
		this.id_counter = 1;
		this.writeToFile = new WriteToFile();
	}
	
	public SymbolTable create(String name) {
		SymbolTable t = new SymbolTable(id_counter, name);
		this.tables.put(id_counter, t);
		this.id_counter++;
		return t;
	}
	
	public void destroy(int id) throws IOException {
		this.writeToFile.symbolTable(this.tables.get(id));
		this.tables.remove(id);
	}
	
	
}
