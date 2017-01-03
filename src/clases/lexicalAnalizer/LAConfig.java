package lexicalAnalizer;

import automata.DFA;
import automata.FinalState;
import automata.Match;
import automata.NonFinalState;
import automata.Action;
import automata.Symbol;
import automata.Transition;
import automata.TransitionMatrix;

public class LAConfig {
	
	public static DFA get() throws Exception{
		//Estados
		NonFinalState E0 = new NonFinalState("E0");
		NonFinalState E1 = new NonFinalState("E1");
		NonFinalState E2 = new NonFinalState("E2");
		NonFinalState E3 = new NonFinalState("E3");
		NonFinalState E4 = new NonFinalState("E4");
		NonFinalState E5 = new NonFinalState("E5");
		NonFinalState E6 = new NonFinalState("E6");
		NonFinalState E7 = new NonFinalState("E7");
		NonFinalState E8 = new NonFinalState("E8");
		NonFinalState E9 = new NonFinalState("E9");
		NonFinalState E10 = new NonFinalState("E10");
		
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
		FinalState 	  E25 = new FinalState("E25");
		FinalState 	  E26 = new FinalState("E26");
		FinalState 	  E27 = new FinalState("E27");
		FinalState 	  E28 = new FinalState("E28");
		FinalState 	  E29 = new FinalState("E29");
		FinalState 	  E30 = new FinalState("E30");
		FinalState 	  E31 = new FinalState("E31");
		FinalState 	  E32 = new FinalState("E32");
		
		NonFinalState[] estadosNoFinales = {E0, E1, E2, E3, E4, E5, E6, E7, E8, E9, E10};
		FinalState[] estadosFinales = {
			E11,E12,E13,E14,E15,E16,E17,E18,E19,E20,E21,E22,E23,E24,E25,E26,E27,E28,E29,E30,E31,E32
		};
		
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
		Symbol ampersand = 	new Symbol('&', Match.STD);
		Symbol punto_coma = new Symbol(';', Match.STD);

		Symbol del = 		new Symbol('*', Match.DELIM);
		Symbol l = 			new Symbol('*', Match.LETTER); 
		Symbol d = 			new Symbol('*', Match.DIGIT);	
		Symbol OC = 		new Symbol('*', Match.OTHER_CHAR);
		Symbol CR = 		new Symbol('*', Match.CR);
		Symbol carHex = 	new Symbol('*', Match.HEX_CHAR);
		Symbol caracter_excepto_comilla = 	new Symbol('*', Match.CHAR_EXCEPT_QUOTE);
		Symbol caracter = 	new Symbol('*', Match.ALL_CHARS);
		Symbol digitNotZero = new Symbol('*', Match.DIGIT_EXCEPT_ZERO);
		
		
		
		Symbol[] alphabet = {
				llave1,llave2,parent1,parent2,coma,exclam,mayor,menor,
				interr,dos_puntos,asign,mas,menos,barra,comilla,
				underscore, del, l, d, OC, CR, cero, x, carHex, caracter,
				caracter_excepto_comilla, digitNotZero, ampersand, punto_coma
		};
		
		//Matriz de transiciones
		TransitionMatrix matrix = new TransitionMatrix(estadosNoFinales, estadosFinales, alphabet);
		
			//delimitador
			matrix.addTransition(new Transition(E0, del, E0, Action.A));
			//llave1
			matrix.addTransition(new Transition(E0, llave1, E11, Action.R));
			//llave2
			matrix.addTransition(new Transition(E0, llave2, E12, Action.S));
			//parent1
			matrix.addTransition(new Transition(E0, parent1, E13, Action.T));
			//parent2
			matrix.addTransition(new Transition(E0, parent2, E14, Action.U));
			//mas
			matrix.addTransition(new Transition(E0, mas, E15, Action.V));
			//menos
			matrix.addTransition(new Transition(E0, menos, E16, Action.W));
			//asignacion
			matrix.addTransition(new Transition(E0, asign, E17, Action.X));
			//dos puntos
			matrix.addTransition(new Transition(E0, dos_puntos, E18, Action.Y));
			//interrogacion
			matrix.addTransition(new Transition(E0, interr, E19, Action.Z));
			//mayor
			matrix.addTransition(new Transition(E0, mayor, E20, Action.AA));
			//menor
			matrix.addTransition(new Transition(E0, menor, E21, Action.BB));
			//coma
			matrix.addTransition(new Transition(E0, coma, E22, Action.CC));
			//exclmacion
			matrix.addTransition(new Transition(E0, exclam, E23, Action.DD));
			//salto de linea
			matrix.addTransition(new Transition(E0, CR, E24, Action.EE));
			//punto y coma
			matrix.addTransition(new Transition(E0, punto_coma, E32, Action.GG));
			
			//and
			matrix.addTransition(new Transition(E0, ampersand, E10, Action.A));
			matrix.addTransition(new Transition(E10, ampersand, E26, Action.C));
			
			
			//decimales
			matrix.addTransition(new Transition(E0, digitNotZero, E2, Action.G));
			matrix.addTransition(new Transition(E2, d, E2, Action.H));
			matrix.addTransition(new Transition(E2, OC, E28, Action.I));
			
			//Identificadores y palabras reservadas
			matrix.addTransition(new Transition(E0, l, E1, Action.D));
			matrix.addTransition(new Transition(E1, l, E1, Action.E));
			matrix.addTransition(new Transition(E1, d, E1, Action.E));
			matrix.addTransition(new Transition(E1, underscore, E1, Action.E));
			matrix.addTransition(new Transition(E1, OC, E27, Action.F));
			
			//Hex, Oct, Numero 0
			matrix.addTransition(new Transition(E0, cero, E3, Action.J));
			matrix.addTransition(new Transition(E3, d, E6, Action.O));//debe ser todo deigito menor 0
			matrix.addTransition(new Transition(E3, x, E4, Action.A));
			matrix.addTransition(new Transition(E3, OC, E29, Action.K));
			
			matrix.addTransition(new Transition(E4, carHex, E5, Action.L));
			matrix.addTransition(new Transition(E5, carHex, E5, Action.M));
			matrix.addTransition(new Transition(E5, OC, E30, Action.N));
			
			matrix.addTransition(new Transition(E6, d, E6, Action.P));
			matrix.addTransition(new Transition(E6, OC, E31, Action.Q));
			
			//Comentario
			matrix.addTransition(new Transition(E0, barra, E7, Action.A));
			matrix.addTransition(new Transition(E7, barra, E8, Action.A));
			matrix.addTransition(new Transition(E8, CR, E24, Action.EE));
			//matrix.addTransition(new Transition(E8, CR, E0, SemanticAction.EE));
			matrix.addTransition(new Transition(E8, caracter, E8, Action.A));
			
			//String
			matrix.addTransition(new Transition(E0, comilla, E9, Action.A));
			matrix.addTransition(new Transition(E9, caracter_excepto_comilla, E9, Action.B));
			matrix.addTransition(new Transition(E9, comilla, E25, Action.FF));
			
			
			//Automata AFD
			DFA afd = new DFA(E0, matrix);
			
			return afd;
	}
	

}
