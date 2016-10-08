package DFA;

import AL.ExampleLexicalAnalizer;
import AL.SourceFile;


public class TestAFD {

	
	public static void main(String[] args) throws Exception{
		
		//Estados
		NonFinalState E1 = new NonFinalState("E1");
		NonFinalState E2 = new NonFinalState("E2");
		NonFinalState E3 = new NonFinalState("E3");
		FinalState 	  E4 = new FinalState("E4");
		
		NonFinalState[] estadosNoFinales = {E1, E2, E3};
		FinalState[] estadosFinales = {E4};
		
		//Alfabeto
		Symbol del = new Symbol('*', Match.DELIM);	//Simbolo de delimitador
		Symbol s1 = new Symbol('*', Match.LETTER); 	//Simbolo que acepta letras
	    Symbol s2 =	new Symbol('-', Match.STD); 	//Simbolo que acepta caracter '-'
		Symbol s3 = new Symbol('*', Match.DIGIT);	//Simbolo que acepta digitos
		Symbol s4 = new Symbol('X', Match.STD);		//Simbolo que acepta caracter 'X'
		
		Symbol[] alphabet = { s1, s2, s3, s4, del };
		
		//Matriz de transiciones
		TransitionMatrix matrix = new TransitionMatrix(estadosNoFinales, estadosFinales, alphabet);
		
		matrix.addTransition(new Transition(E1, del, E1, SemanticAction.A));
		matrix.addTransition(new Transition(E1, s1, E2, SemanticAction.B));
		matrix.addTransition(new Transition(E2, s2, E3, SemanticAction.B));
		matrix.addTransition(new Transition(E3, s3, E3, SemanticAction.B));
		matrix.addTransition(new Transition(E3, s4, E4, SemanticAction.C));
		
		//Automata AFD
		DFA afd = new DFA(E1, matrix);
		System.out.println(afd.toString() + "\n--------------------------------------------------------------");
	
		
		////////////////////TEST////////////////////////////
		
		//Fichero Fuente
		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/text");
		sf.open();
				
		//Analizador del lenguaje, cada lenguaje debe implementar su propia clase usando la interfaz LexicalAnalizer
		ExampleLexicalAnalizer analizer = new ExampleLexicalAnalizer(sf, afd);
	
		//Cada llamada devuelve un token o null si no hay token
		System.out.println(analizer.getNewToken());
		System.out.println(analizer.getNewToken());
		System.out.println(analizer.getNewToken());
		
		//Devuelve null porque ya no hay más tokens
		System.out.println(analizer.getNewToken());

		
		sf.close();
		
	}
	
}
