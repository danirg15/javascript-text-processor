package Main;

import lexicalAnalizer.JSLexicalAnalizer;
import lexicalAnalizer.LAConfig;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;
import sintacticAnalizer.NonTerminalSymbol;
import sintacticAnalizer.SAConfig;
import sintacticAnalizer.SAConfig2;
import sintacticAnalizer.SintacticAnalizer;
import sintacticAnalizer.TerminalSymbol;
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
		tablaPR.add("char");//4
		tablaPR.add("write");//5
		tablaPR.add("prompt");//6
		tablaPR.add("switch");//7
		tablaPR.add("case");//8
		tablaPR.add("bool");//9
		tablaPR.add("default");//10
		tablaPR.add("if");//11
		
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
		NonTerminalSymbol axiom = new NonTerminalSymbol("P");	
		SintacticAnalizer sa = new SintacticAnalizer(axiom, SAConfig2.getLL1Table(), lexAnalizer);
		
		sa.analize();


		sf.close();
		
//		NonTerminalSymbol T = new NonTerminalSymbol("T");
//		TerminalSymbol int_ = new TerminalSymbol(new Token(TokenType.PR, "0"));
//		
//		System.out.print( SAConfig2.getLL1Table().getRule(T, int_) );
		
		
		
	}
	
	
	
}



