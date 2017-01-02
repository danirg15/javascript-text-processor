package Main;

import lexicalAnalizer.JSLexicalAnalizer;
import lexicalAnalizer.LAConfig;
import sintacticAnalizer.NonTerminalSymbol;
import sintacticAnalizer.SAConfig;
import sintacticAnalizer.SintacticAnalizer;
import symbolTable.SymbolTable;
import symbolTable.TSContainer;
import automata.DFA;
import extra.AttrTable;
import extra.SourceFile;
import extra.WriteToFile;

public class TestMain {

	public static void main(String[] args) throws Exception{	
		
		if( args.length < 1 ) {
			System.out.println("USO: java -jar analizador path_fichero_fuente");
			System.exit(-1);
		}
		
		
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
		
		//
		WriteToFile.cleanFiles();
		
		//Tabla de simbolos
		TSContainer ts_container = new TSContainer();
		SymbolTable TS = ts_container.create("Global");
		
		//Automata AFD
		DFA afd = LAConfig.get();
		
		//Fichero Fuente
		SourceFile sf = new SourceFile(args[0]);
		sf.open();
		sf.read();
				
		//Analizador Lexico
		JSLexicalAnalizer lexAnalizer = new JSLexicalAnalizer(sf, afd, tablaPR, TS);
				
		
		//Analizador Sintactico
		NonTerminalSymbol axiom = new NonTerminalSymbol("P'");	
		SintacticAnalizer sa = new SintacticAnalizer(axiom, SAConfig.getLL1Table(), lexAnalizer);
		
		sa.analize();
		
		
		//Para obtener ejecutable, exportar como runnable jar, y elegir entry point
		//Luego desde CLI > java -jar main.jar arg1 arg2


		sf.close();
					
	}
	
	
	
}



