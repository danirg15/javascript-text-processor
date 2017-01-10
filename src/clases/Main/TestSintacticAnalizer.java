package Main;

import common.AttrTable;
import common.SourceFile;
import common.WriteToFile;
import lexicalAnalizer.LexicalAnalizer;
import lexicalAnalizer.LAConfig;
import sintacticAnalizer.NonTerminalSymbol;
import sintacticAnalizer.SinAConfig;
import sintacticAnalizer.SintacticAnalizer;
import automata.DFA;

public class TestSintacticAnalizer {
	


	public static void main(String[] args) throws Exception {	
//		System.out.println("Args: " + args.length);
//		
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
		tablaPR.add("switch");//
		tablaPR.add("case");//8
		tablaPR.add("bool");//9
		tablaPR.add("if");//10
		tablaPR.add("break");//11
		
		//
		WriteToFile.cleanFiles();
				
		
		//Automata AFD
		DFA afd = LAConfig.get();
		
		//Fichero Fuente
		//SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/programa.js");
		SourceFile sf = new SourceFile(args[0]);
		
		sf.open();
		sf.read();
				
		//Analizador Lexico
		LexicalAnalizer lexAnalizer = new LexicalAnalizer(sf, afd, tablaPR);
				
		
		//Analizador Sintactico
		NonTerminalSymbol axiom = new NonTerminalSymbol("P'");	
		SintacticAnalizer sa = new SintacticAnalizer(axiom, SinAConfig.getLL1Table(), lexAnalizer);
		
		try {
			sa.analize();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Ejecución detenida por errores, ver fichero errores.txt");
		}
		
		
		//Para obtener ejecutable, exportar como runnable jar, y elegir entry point
		//Luego desde CLI > java -jar main.jar arg1 arg2


		sf.close();
			
				
		
	}
	
	
	
}



