package semanticAnalizer;

import symbolTable.Entry;
import symbolTable.SymbolTable;

public class SemanticAnalizer {
	public static boolean dec_zone = false;
	public static boolean switch_flag = false;
	public static boolean function_flag = false;
	public static SymbolTable currentTS = null;
	public static SymbolTable GST = null;
	public static SymbolTable LST = null;
	public static int currentTS_offset = 0;
	public static int GST_offset = 0;
	public static int LST_offset = 0;
	
	public static Entry findInAllTS(String lex) {
		if(LST.search(lex) != null) {
			return LST.search(lex);
		}
		else if(GST.search(lex) != null) {
			return GST.search(lex);
		}
		else {
			return null;
		}
	}
		
}
