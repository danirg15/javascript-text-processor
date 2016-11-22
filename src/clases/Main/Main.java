package Main;

import java.util.Stack;

import lexicalAnalizer.JSLexicalAnalizer;
import lexicalAnalizer.LAConfig;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;
import tables.AttrTable;
import tables.SymbolTable;
import extra.SourceFile;
import automata.DFA;
import automata.FinalState;
import automata.Match;
import automata.NonFinalState;
import automata.SemanticAction;
import automata.Symbol;
import automata.Transition;
import automata.TransitionMatrix;

public class Main {

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
		
		
		//sSystem.out.println(afd.toString() + "\n--------------------------------------------------------------");
	
		////////////////////TEST////////////////////////////
		
		//Fichero Fuente
//		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/programa.js");
//		sf.open();
//		sf.read();
//				
//		//Analizador del lenguaje
//		JSLexicalAnalizer analizer = new JSLexicalAnalizer(sf, afd, tablaPR, TS);
//	
//		//Cada llamada devuelve un token
//		Token t = null;
//		while((t = analizer.getNewToken()) != null){
//			System.out.println(t);
//			
//			if(t.getType() == TokenType.$) break;//EOF		
//		}
//		
//		sf.close();
		
		
		Stack s = new Stack();
		s.add("1");
		s.add("2");
		s.add("3");
		
		System.out.println(s.toString());
		System.out.println(s.pop());
		System.out.println(s.toString());
	}
	
	
	
}


