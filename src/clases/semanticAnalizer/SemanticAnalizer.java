package semanticAnalizer;

import symbolTable.SymbolTable;

public class SemanticAnalizer {
	private static int offset;
	private static SymbolTable GST;
	
	public static void setGlobalOffset(int n) {
		offset = n;
	}
	
	public static int getGlobalOffset() {		
		return offset;
	}

	public static SymbolTable getGST() {
		return GST;
	}

	public static void setGST(SymbolTable gST) {
		GST = gST;
	}
	
	
	
}
