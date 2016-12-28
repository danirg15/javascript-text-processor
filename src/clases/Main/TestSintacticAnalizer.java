package Main;

import lexicalAnalizer.JSLexicalAnalizer;
import lexicalAnalizer.LAConfig;
import sintacticAnalizer.NonTerminalSymbol;
import sintacticAnalizer.SAConfig2;
import sintacticAnalizer.SintacticAnalizer;
import tables.AttrTable;
import tables.SymbolTable;
import automata.DFA;
import extra.SourceFile;

public class TestSintacticAnalizer {

	public static void main(String[] args) throws Exception{			
		//TablaAtributos -> palabras reservadas
		AttrTable tablaPR = new AttrTable();
		tablaPR.add("int");//0
		tablaPR.add("function");//1
		tablaPR.add("var");//2
		tablaPR.add("return");//3
		tablaPR.add("chars");//4
		tablaPR.add("write");//5
		tablaPR.add("prompt");//6
		tablaPR.add("switch");//7
		tablaPR.add("case");//8
		tablaPR.add("bool");//9
		tablaPR.add("if");//10
		tablaPR.add("break");//11
		
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
		NonTerminalSymbol axiom = new NonTerminalSymbol("P'");	
		SintacticAnalizer sa = new SintacticAnalizer(axiom, SAConfig2.getLL1Table(), lexAnalizer);
		
		sa.analize();
		
		
		//Para obtener ejecutable, exportar como runnable jar, y elegir entry point
		//Luego desde CLI > java -jar main.jar arg1 arg2


		sf.close();
			
		
		//System.out.println(args.length);
	}
	
	
	
}



