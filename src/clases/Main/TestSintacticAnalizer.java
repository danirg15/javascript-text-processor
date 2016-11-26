package Main;

import lexicalAnalizer.JSLexicalAnalizer;
import lexicalAnalizer.LAConfig;
import sintacticAnalizer.NonTerminalSymbol;
import sintacticAnalizer.SAConfig;
import sintacticAnalizer.SintacticAnalizer;
import tables.AttrTable;
import tables.SymbolTable;
import automata.DFA;
import extra.SourceFile;

public class TestSintacticAnalizer {

	public static void main(String[] args) throws Exception{			
		//TablaAtributos -> palabras reservadas
		AttrTable tablaPR = new AttrTable();
		tablaPR.add("int");
		tablaPR.add("function");
		tablaPR.add("var");
		tablaPR.add("return");
		tablaPR.add("bool");
		tablaPR.add("char");
		tablaPR.add("write");
		tablaPR.add("prompt");
		tablaPR.add("switch");
		tablaPR.add("case");
		
		//Tabla de simbolos
		SymbolTable TS = new SymbolTable();
		
		//Automata AFD
		DFA afd = LAConfig.get();
		
		//Fichero Fuente
		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/programa.js");
		sf.open();
		sf.read();
				
		//Analizador Lexico
		JSLexicalAnalizer lexAnalizer = new JSLexicalAnalizer(sf, afd, tablaPR, TS);
	
		
		//Analizador Sintactico
		NonTerminalSymbol axiom = new NonTerminalSymbol("E");	
		SintacticAnalizer sa = new SintacticAnalizer(axiom, SAConfig.getLL1Table(), lexAnalizer);
		
		sa.analize();


		sf.close();
	}
	
	
	
}



