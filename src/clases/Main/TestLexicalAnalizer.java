package Main;

import common.AttrTable;
import common.SourceFile;
import common.WriteToFile;

import lexicalAnalizer.LexicalAnalizer;
import lexicalAnalizer.LAConfig;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;
import automata.DFA;

public class TestLexicalAnalizer {

	public static void main(String args[]) throws Exception{
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
//		TSContainer ts_container = new TSContainer();
//		SymbolTable TS = ts_container.create("Global");
		
		//Automata AFD
		DFA afd = LAConfig.get();
		
		
		//Fichero Fuente
		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/programa.js");
		sf.open();
		sf.read();
				
		//Analizador del lenguaje
		LexicalAnalizer analizer = new LexicalAnalizer(sf, afd, tablaPR);
	
		//Cada llamada devuelve un token
		Token t = null;
		while((t = analizer.getNewToken()) != null){
			System.out.println(t);
			
			if(t.getType() == TokenType.$) break;//EOF		
		}
		
		sf.close();
	}
	
}
