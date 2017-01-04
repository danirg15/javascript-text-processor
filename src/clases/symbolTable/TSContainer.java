package symbolTable;

import java.io.IOException;
import java.util.HashMap;

import common.WriteToFile;


public class TSContainer {
	private static HashMap<Integer, SymbolTable> tables = new HashMap<Integer, SymbolTable>();
	private static int id_counter = 1;
	private static WriteToFile writeToFile = new WriteToFile();
	
	
	public static SymbolTable create(String name) {
		SymbolTable t = new SymbolTable(id_counter, name);
		tables.put(id_counter, t);
		id_counter++;
		return t;
	}
	
	public static void destroy(int id) throws IOException {
		writeToFile.symbolTable(tables.get(id));
		tables.remove(id);
	}
	
	
}
