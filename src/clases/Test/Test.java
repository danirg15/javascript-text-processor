package Test;

import tables.AttrTable;
import extra.SourceFile;
import analizer.Token;
import automata.DFA;
import automata.FinalState;
import automata.Match;
import automata.NonFinalState;
import automata.SemanticAction;
import automata.Symbol;
import automata.Transition;
import automata.TransitionMatrix;

public class Test {

	public static void main(String[] args) throws Exception{
		//Estados
		NonFinalState E0 = new NonFinalState("E0");
		NonFinalState E1 = new NonFinalState("E1");
		NonFinalState E2 = new NonFinalState("E2");
		NonFinalState E3 = new NonFinalState("E3");
		NonFinalState E4 = new NonFinalState("E4");
		NonFinalState E5 = new NonFinalState("E5");
		NonFinalState E6 = new NonFinalState("E6");
		NonFinalState E7 = new NonFinalState("E7");
		NonFinalState E27 = new NonFinalState("E27");
		NonFinalState E28 = new NonFinalState("E28");
		NonFinalState E29 = new NonFinalState("E29");
		
		FinalState 	  E8 = new FinalState("E8");
		FinalState 	  E9 = new FinalState("E9");
		FinalState 	  E10 = new FinalState("E10");
		FinalState 	  E11 = new FinalState("E11");
		FinalState 	  E12 = new FinalState("E12");
		FinalState 	  E13 = new FinalState("E13");
		FinalState 	  E14 = new FinalState("E14");
		FinalState 	  E15 = new FinalState("E15");
		FinalState 	  E16 = new FinalState("E16");
		FinalState 	  E17 = new FinalState("E17");
		FinalState 	  E18 = new FinalState("E18");
		FinalState 	  E19 = new FinalState("E19");
		FinalState 	  E20 = new FinalState("E20");
		FinalState 	  E21 = new FinalState("E21");
		FinalState 	  E22 = new FinalState("E22");
		FinalState 	  E23 = new FinalState("E23");
		FinalState 	  E24 = new FinalState("E24");
		FinalState 	  E26 = new FinalState("E26");
		
		NonFinalState[] estadosNoFinales = {E0, E1, E2, E3, E4, E5, E6, E7, E27, E28, E29};
		FinalState[] estadosFinales = {E8, E9, E10, E11, E12, E13, E14, E15, E16, E17, E18, E19, E20, E21, E22, E23, E24,  E26};
		
		//Alfabeto
		Symbol llave1 = 	new Symbol('{', Match.STD);
		Symbol llave2 = 	new Symbol('}', Match.STD);
		Symbol parent1 = 	new Symbol('(', Match.STD);
		Symbol parent2 = 	new Symbol(')', Match.STD);
		Symbol coma =		new Symbol(',', Match.STD);	
		Symbol exclam = 	new Symbol('!', Match.STD);	
		Symbol mayor = 		new Symbol('>', Match.STD);	
		Symbol menor = 		new Symbol('<', Match.STD);	
		Symbol interr = 	new Symbol('?', Match.STD);	
		Symbol dos_puntos = new Symbol(':', Match.STD);	
		Symbol asign = 		new Symbol('=', Match.STD);	
		Symbol mas = 		new Symbol('+', Match.STD);	
		Symbol menos = 		new Symbol('-', Match.STD);	
		Symbol barra = 		new Symbol('/', Match.STD);	
		Symbol comilla = 	new Symbol('"', Match.STD);
		Symbol underscore = new Symbol('_', Match.STD);
		Symbol cero = 		new Symbol('0', Match.STD);
		Symbol x = 			new Symbol('x', Match.STD);

		Symbol del = 		new Symbol('*', Match.DELIM);
		Symbol l = 			new Symbol('*', Match.LETTER); 
		Symbol d = 			new Symbol('*', Match.DIGIT);	
		Symbol OC = 		new Symbol('*', Match.OTHER_CHAR);
		Symbol CR = 		new Symbol('*', Match.CR);
		Symbol carHex = 	new Symbol('*', Match.HEX_CHAR);
		Symbol caracter = 	new Symbol('*', Match.CHAR);
		Symbol digitNotZero = new Symbol('*', Match.DIGIT_EXCEPT_ZERO);
		
		Symbol[] alphabet = {
				llave1,llave2,parent1,parent2,coma,exclam,mayor,menor,
				interr,dos_puntos,asign,mas,menos,barra,comilla,
				underscore, del, l, d, OC, CR, cero, x, carHex, caracter,
				digitNotZero
		};
		
		//Matriz de transiciones
		TransitionMatrix matrix = new TransitionMatrix(estadosNoFinales, estadosFinales, alphabet);
		
			//delimitador
			matrix.addTransition(new Transition(E0, del, E0, SemanticAction.A));
			//llave1
			matrix.addTransition(new Transition(E0, llave1, E8, SemanticAction.B));
			//llave2
			matrix.addTransition(new Transition(E0, llave2, E9, SemanticAction.C));
			//parent1
			matrix.addTransition(new Transition(E0, parent1, E10, SemanticAction.D));
			//parent2
			matrix.addTransition(new Transition(E0, parent2, E11, SemanticAction.E));
			//coma
			matrix.addTransition(new Transition(E0, coma, E12, SemanticAction.F));
			//exclmacion
			matrix.addTransition(new Transition(E0, exclam, E13, SemanticAction.G));
			//mayor
			matrix.addTransition(new Transition(E0, mayor, E14, SemanticAction.H));
			//menor
			matrix.addTransition(new Transition(E0, menor, E15, SemanticAction.I));
			//interrogacion
			matrix.addTransition(new Transition(E0, interr, E16, SemanticAction.J));
			//dos puntos
			matrix.addTransition(new Transition(E0, dos_puntos, E17, SemanticAction.K));
			//asignacion
			matrix.addTransition(new Transition(E0, asign, E18, SemanticAction.L));
			//menos
			matrix.addTransition(new Transition(E0, menos, E19, SemanticAction.M));
			//mas
			matrix.addTransition(new Transition(E0, mas, E20, SemanticAction.N));
			
			//decimales
			matrix.addTransition(new Transition(E0, digitNotZero, E2, SemanticAction.O));
			matrix.addTransition(new Transition(E2, d, E2, SemanticAction.P));
			matrix.addTransition(new Transition(E2, OC, E21, SemanticAction.Q));
			
			//Identificadores y palabras reservadas
			matrix.addTransition(new Transition(E0, l, E1, SemanticAction.R));
			matrix.addTransition(new Transition(E1, l, E1, SemanticAction.S));
			matrix.addTransition(new Transition(E1, d, E1, SemanticAction.S));
			matrix.addTransition(new Transition(E1, underscore, E1, SemanticAction.S));
			matrix.addTransition(new Transition(E1, OC, E22, SemanticAction.T));
			
			//Hex y Oct
			matrix.addTransition(new Transition(E0, cero, E3, SemanticAction.A));
			matrix.addTransition(new Transition(E3, d, E29, SemanticAction.U));
			matrix.addTransition(new Transition(E29, d, E29, SemanticAction.UU));
			matrix.addTransition(new Transition(E29, OC, E24, SemanticAction.V));
			matrix.addTransition(new Transition(E3, x, E27, SemanticAction.A));
			matrix.addTransition(new Transition(E27, carHex, E28, SemanticAction.XX));
			matrix.addTransition(new Transition(E28, carHex, E28, SemanticAction.W));
			matrix.addTransition(new Transition(E28, OC, E23, SemanticAction.X));
			
			//Comentario
			matrix.addTransition(new Transition(E0, barra, E5, SemanticAction.A));
			matrix.addTransition(new Transition(E5, barra, E6, SemanticAction.A));
			matrix.addTransition(new Transition(E6, CR, E0, SemanticAction.A));
			matrix.addTransition(new Transition(E6, caracter, E6, SemanticAction.A));
			
			//String
			matrix.addTransition(new Transition(E0, comilla, E7, SemanticAction.A));
			matrix.addTransition(new Transition(E7, caracter, E7, SemanticAction.AA));
			matrix.addTransition(new Transition(E7, comilla, E26, SemanticAction.AB));
			
			
			
			
		AttrTable tablaAtt = new AttrTable();
		
		tablaAtt.add("int");
		tablaAtt.add("function");
		tablaAtt.add("var");
		tablaAtt.add("return");
		
			
		
		//Automata AFD
		DFA afd = new DFA(E0, matrix);
		System.out.println(afd.toString() + "\n--------------------------------------------------------------");
	
		
		////////////////////TEST////////////////////////////
		
		//Fichero Fuente
		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/programa.js");
		sf.open();
				
		//Analizador del lenguaje, cada lenguaje debe implementar su propia clase usando la interfaz LexicalAnalizer
		JavascriptLexicalAnalizer analizer = new JavascriptLexicalAnalizer(sf, afd, tablaAtt);
	
		//Cada llamada devuelve un token o null si no hay token
		Token t = null;
		while((t = analizer.getNewToken()) != null){
			System.out.println(t);
		}
		
		sf.close();
		
	}
	
	
	
}


