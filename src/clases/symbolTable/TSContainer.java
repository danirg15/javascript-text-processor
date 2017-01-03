package symbolTable;

import java.io.IOException;
import java.util.HashMap;

import extra.WriteToFile;


public class TSContainer {
	private static HashMap<Integer, SymbolTable> tables = new HashMap<Integer, SymbolTable>();
	private static int id_counter = 1;
	private static WriteToFile writeToFile = new WriteToFile();
	
	
	public SymbolTable create(String name) {
		SymbolTable t = new SymbolTable(id_counter, name);
		tables.put(id_counter, t);
		id_counter++;
		return t;
	}
	
	public void destroy(int id) throws IOException {
		writeToFile.symbolTable(tables.get(id));
		tables.remove(id);
	}
	
	
}
