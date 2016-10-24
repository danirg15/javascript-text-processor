package Test;

import extra.SourceFile;
import automata.DFA;
import automata.FinalState;
import automata.Match;
import automata.NonFinalState;
import automata.SemanticAction;
import automata.Symbol;
import automata.Transition;
import automata.TransitionMatrix;
import ST.AttrTable;

public class TestCarreteras {

	public static void main(String[] args) throws Exception{
		//Estados
		NonFinalState E0 = new NonFinalState("E0");
		NonFinalState E1 = new NonFinalState("E1");
		NonFinalState E2 = new NonFinalState("E2");
		NonFinalState E3 = new NonFinalState("E3");
		NonFinalState E4 = new NonFinalState("E4");
		NonFinalState E5 = new NonFinalState("E5");
		NonFinalState E6 = new NonFinalState("E6");
		
		FinalState 	  E7 = new FinalState("E7");
		FinalState 	  E8 = new FinalState("E8");
		FinalState 	  E9 = new FinalState("E9");
		FinalState 	  E10 = new FinalState("E10");
		FinalState 	  E11 = new FinalState("E11");
		FinalState 	  E12 = new FinalState("E12");
		
		NonFinalState[] estadosNoFinales = {E0, E1, E2, E3, E4, E5, E6};
		FinalState[] estadosFinales = {E7, E8, E9, E10, E11, E12};
		
		//Alfabeto
		Symbol del = 		new Symbol('*', Match.DELIM);	
		Symbol OC = 		new Symbol('*', Match.OTHER_CHAR);
		Symbol CR = 		new Symbol('*', Match.CR);
		Symbol car = 		new Symbol('*', Match.CHAR_EXCEPT_QUOTE);
		Symbol l = 			new Symbol('*', Match.LETTER); 
		Symbol d = 			new Symbol('*', Match.DIGIT);	
	    Symbol guion =		new Symbol('-', Match.STD); 	
		Symbol coma =		new Symbol(',', Match.STD);	
		Symbol comilla = 	new Symbol('"', Match.STD);
		
		Symbol[] alphabet = { del, OC, CR, l, guion, d, coma, comilla, car };
		
		//Matriz de transiciones
		TransitionMatrix matrix = new TransitionMatrix(estadosNoFinales, estadosFinales, alphabet);
		
			//delimitador
			matrix.addTransition(new Transition(E0, del, E0, SemanticAction.A));
			
			//fin de linea
			matrix.addTransition(new Transition(E0, CR, E7, SemanticAction.D));
			
			//Comentario
			matrix.addTransition(new Transition(E0, comilla, E4, SemanticAction.A));
			matrix.addTransition(new Transition(E4, car, E4, SemanticAction.B));
			matrix.addTransition(new Transition(E4, comilla, E12, SemanticAction.C));
			
			//kilometros
			matrix.addTransition(new Transition(E0, d, E5, SemanticAction.B));
			matrix.addTransition(new Transition(E5, d, E5, SemanticAction.B));
			matrix.addTransition(new Transition(E5, coma, E6, SemanticAction.B));
			matrix.addTransition(new Transition(E6, d, E10, SemanticAction.E));
			matrix.addTransition(new Transition(E5, OC, E11, SemanticAction.F)); //Problema, OC siempre tiene que estar al final
			
			//carretera y incidencia y municipio
			matrix.addTransition(new Transition(E0, l, E1, SemanticAction.B));
			matrix.addTransition(new Transition(E1, l, E1, SemanticAction.B));
			matrix.addTransition(new Transition(E1, guion, E2, SemanticAction.B));
			matrix.addTransition(new Transition(E2, d, E3, SemanticAction.B));
			matrix.addTransition(new Transition(E3, d, E3, SemanticAction.B));
			matrix.addTransition(new Transition(E3, OC, E9, SemanticAction.G));
			matrix.addTransition(new Transition(E1, OC, E8, SemanticAction.H));
			
			
		
		AttrTable.add("Amarillo");
		AttrTable.add("Negro");
		AttrTable.add("Rojo");
		
		AttrTable.add("Madrid");
		AttrTable.add("Barcelona");
			
		
		//Automata AFD
		DFA afd = new DFA(E0, matrix);
		System.out.println(afd.toString() + "\n--------------------------------------------------------------");
	
		
		////////////////////TEST////////////////////////////
		
		//Fichero Fuente
		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/carreteras");
		sf.open();
				
		//Analizador del lenguaje, cada lenguaje debe implementar su propia clase usando la interfaz LexicalAnalizer
		CarreterasLexicalAnalizer analizer = new CarreterasLexicalAnalizer(sf, afd);
	
		//Cada llamada devuelve un token o null si no hay token
		System.out.println(analizer.getNewToken());
		System.out.println(analizer.getNewToken());
		System.out.println(analizer.getNewToken());
		System.out.println(analizer.getNewToken());
		System.out.println(analizer.getNewToken());
		System.out.println(analizer.getNewToken());
		
		
		
		sf.close();
		
	}
	
	
	
}


