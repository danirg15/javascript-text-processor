package sintacticAnalizer;

import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class SAConfig2 {
	
	public static LL1Table getLL1Table(){
		
		LL1Table table = new LL1Table();
		
		NonTerminalSymbol P = 		new NonTerminalSymbol("P");
		NonTerminalSymbol B = 		new NonTerminalSymbol("B");
		NonTerminalSymbol S = 		new NonTerminalSymbol("S");
		NonTerminalSymbol Sprima = 	new NonTerminalSymbol("S'");
		NonTerminalSymbol X = 		new NonTerminalSymbol("X");
		NonTerminalSymbol L = 		new NonTerminalSymbol("L");
		NonTerminalSymbol Q = 		new NonTerminalSymbol("Q");
		NonTerminalSymbol E = 		new NonTerminalSymbol("E");
		NonTerminalSymbol Eprima = 	new NonTerminalSymbol("E'");
		NonTerminalSymbol R = 		new NonTerminalSymbol("R");
		NonTerminalSymbol Rprima = 	new NonTerminalSymbol("R'");
		NonTerminalSymbol U = 		new NonTerminalSymbol("U");
		NonTerminalSymbol Uprima = 	new NonTerminalSymbol("U'");
		NonTerminalSymbol V = 		new NonTerminalSymbol("V");
		NonTerminalSymbol Y = 		new NonTerminalSymbol("Y");
		NonTerminalSymbol J = 		new NonTerminalSymbol("J");
		NonTerminalSymbol F = 		new NonTerminalSymbol("F");
		NonTerminalSymbol H = 		new NonTerminalSymbol("H");
		NonTerminalSymbol A = 		new NonTerminalSymbol("A");
		NonTerminalSymbol K = 		new NonTerminalSymbol("K");
		NonTerminalSymbol C = 		new NonTerminalSymbol("C");
		NonTerminalSymbol Z = 		new NonTerminalSymbol("Z");
		NonTerminalSymbol Zprima = 	new NonTerminalSymbol("Z'");
		NonTerminalSymbol T = 		new NonTerminalSymbol("T");
		NonTerminalSymbol W = 		new NonTerminalSymbol("W");
		NonTerminalSymbol N = 		new NonTerminalSymbol("N");
		NonTerminalSymbol Nprima = 	new NonTerminalSymbol("N'");
		
	
		TerminalSymbol lambda = 	new TerminalSymbol(new Token(TokenType.LAMBDA, null));
		TerminalSymbol eof = 		new TerminalSymbol(new Token(TokenType.$, null));
		TerminalSymbol id = 		new TerminalSymbol(new Token(TokenType.ID, null));
		TerminalSymbol par1 = 		new TerminalSymbol(new Token(TokenType.PARENT, "1"));
		TerminalSymbol par2 = 		new TerminalSymbol(new Token(TokenType.PARENT, "2"));
		TerminalSymbol llave1 = 	new TerminalSymbol(new Token(TokenType.LLAVE, "1"));
		TerminalSymbol llave2 = 	new TerminalSymbol(new Token(TokenType.LLAVE, "2"));
		TerminalSymbol asign = 		new TerminalSymbol(new Token(TokenType.ASIGN, null));
		TerminalSymbol coma = 		new TerminalSymbol(new Token(TokenType.COMA, null));
		TerminalSymbol mayor = 		new TerminalSymbol(new Token(TokenType.MAYOR, null));
		TerminalSymbol CR_ = 		new TerminalSymbol(new Token(TokenType.CR, null));
		TerminalSymbol mas = 		new TerminalSymbol(new Token(TokenType.MAS, null));
		TerminalSymbol menos = 		new TerminalSymbol(new Token(TokenType.MENOS, null));
		TerminalSymbol entero = 	new TerminalSymbol(new Token(TokenType.ENT, null));
		TerminalSymbol cadena = 	new TerminalSymbol(new Token(TokenType.STRING, null));
		TerminalSymbol and = 		new TerminalSymbol(new Token(TokenType.AND, null));
		TerminalSymbol dos_puntos = new TerminalSymbol(new Token(TokenType.DOS_PUNTOS, null));
		TerminalSymbol interr = 	new TerminalSymbol(new Token(TokenType.INTERR, null));
		
		TerminalSymbol int_ = 		new TerminalSymbol(new Token(TokenType.PR, "0"));
		TerminalSymbol function_ = 	new TerminalSymbol(new Token(TokenType.PR, "1"));
		TerminalSymbol var_ = 		new TerminalSymbol(new Token(TokenType.PR, "2"));
		TerminalSymbol return_ = 	new TerminalSymbol(new Token(TokenType.PR, "3"));
		TerminalSymbol char_ = 		new TerminalSymbol(new Token(TokenType.PR, "4"));
		TerminalSymbol write_ =	 	new TerminalSymbol(new Token(TokenType.PR, "5"));
		TerminalSymbol prompt_ = 	new TerminalSymbol(new Token(TokenType.PR, "6"));
		TerminalSymbol switch_ =	new TerminalSymbol(new Token(TokenType.PR, "7"));
		TerminalSymbol case_ = 		new TerminalSymbol(new Token(TokenType.PR, "8"));
		TerminalSymbol bool_ = 		new TerminalSymbol(new Token(TokenType.PR, "9"));
		TerminalSymbol default_ = 	new TerminalSymbol(new Token(TokenType.PR, "10"));
		TerminalSymbol if_ = 		new TerminalSymbol(new Token(TokenType.PR, "11"));
		
		
		
		
		
		
		
	
		//P
		GrammaticalSymbol r4der[] = {lambda}; 
		SintacticRule r4 = new SintacticRule(4, P, r4der); //P -> lambda
		
		GrammaticalSymbol r1der[] = {B,Z,P}; 
		SintacticRule r1 = new SintacticRule(1, P, r1der); //P -> BZP
		
		GrammaticalSymbol r2der[] = {F,Z,P}; 
		SintacticRule r2 = new SintacticRule(2, P, r2der); //P -> FZP
		
		GrammaticalSymbol r3der[] = {Z,P}; 
		SintacticRule r3 = new SintacticRule(3, P, r3der); //P -> ZP
		
		
		table.addRule(P, eof, r4);	 		//P -> BZP
		table.addRule(P, var_, r1); 		//P -> BZP
		table.addRule(P, id, r1); 			//P -> BZP
		table.addRule(P, switch_, r1); 		//P -> BZP
		table.addRule(P, return_, r1); 		//P -> BZP
		table.addRule(P, write_, r1); 		//P -> BZP
		table.addRule(P, prompt_, r1); 		//P -> BZP
		table.addRule(P, function_, r2); 	//P -> FZP
		table.addRule(P, CR_, r3); 			//P -> ZP
		table.addRule(P, if_, r1); 			//P -> BZP
		
		//B
		GrammaticalSymbol r5der[] = {var_, T, id}; 
		SintacticRule r5 = new SintacticRule(5, B, r5der); //B -> var T id
		
		GrammaticalSymbol r7der[] = {S}; 
		SintacticRule r7 = new SintacticRule(7, B, r7der); //B -> S
		
		GrammaticalSymbol r6der[] = {switch_, par1, E, par2, Z, llave1, Z, W, llave2}; 
		SintacticRule r6 = new SintacticRule(6, B, r6der); //B -> switch(E) Z { Z W }
		
		GrammaticalSymbol r57der[] = {if_, par1, E, par2, S}; 
		SintacticRule r57 = new SintacticRule(57, B, r57der); //B -> if ( E ) S
		
		
		table.addRule(B, var_, r5);			//B -> var T id
		table.addRule(B, id, r7);			//B -> S
		table.addRule(B, switch_, r6); 		//B -> switch(E) Z { Z W }
		table.addRule(B, return_, r7);		//B -> S
		table.addRule(B, write_, r7);		//B -> S
		table.addRule(B, prompt_, r7);		//B -> S
		table.addRule(B, if_, r57);		
		
		
		//S
		GrammaticalSymbol r9der[] = {id, Sprima}; 
		SintacticRule r9 = new SintacticRule(9, S, r9der); //S -> id S'
		
		GrammaticalSymbol r8der[] = {return_, X}; 
		SintacticRule r8 = new SintacticRule(8, S, r8der); //S -> return X
		
		GrammaticalSymbol r10der[] = {write_, par1, E, par2}; 
		SintacticRule r10 = new SintacticRule(10, S, r10der); //S -> write ( E )

		GrammaticalSymbol r11der[] = {prompt_, par1, id, par2}; 
		SintacticRule r11 = new SintacticRule(11, S, r11der); //S -> prompt ( id )

		
		table.addRule(S, id, r9);		//S -> id S'
		table.addRule(S, return_, r8);	//S -> return  X
		table.addRule(S, write_, r10);	//S -> write ( E ) 
		table.addRule(S, prompt_, r11);	//S -> prompt ( id )
		
		
		//S'
		GrammaticalSymbol r13der[] = {par1, L, par2}; 
		SintacticRule r13 = new SintacticRule(13, Sprima, r13der); //S' -> ( L )
		
		GrammaticalSymbol r12der[] = {asign, E}; 
		SintacticRule r12 = new SintacticRule(12, Sprima, r12der); //S' -> = E
		
		
		table.addRule(Sprima, par1, r13);
		table.addRule(Sprima, asign, r12);
		
		
		//X
		GrammaticalSymbol r14der[] = {E}; 
		SintacticRule r14 = new SintacticRule(14, X, r14der); //X -> E
		
		GrammaticalSymbol r15der[] = {lambda}; 
		SintacticRule r15 = new SintacticRule(15, X, r15der); //X -> lambda
		
		
		table.addRule(X, id, r14);
		table.addRule(X, par1, r14);
		table.addRule(X, entero, r14);
		table.addRule(X, cadena, r14);
		table.addRule(X, CR_, r15);
		
		
		//L
		GrammaticalSymbol r16der[] = {E,Q}; 
		SintacticRule r16 = new SintacticRule(16, L, r16der); //L -> E Q
		
		GrammaticalSymbol r17der[] = {lambda}; 
		SintacticRule r17 = new SintacticRule(17, L, r17der); //L -> lambda
		
		table.addRule(L, id, r16);
		table.addRule(L, par1, r16);
		table.addRule(L, par2, r17);
		table.addRule(L, entero, r16);
		table.addRule(L, cadena, r16);
		
		
		//Q
		GrammaticalSymbol r19der[] = {lambda}; 
		SintacticRule r19 = new SintacticRule(19, Q, r19der); //Q -> lambda
		
		GrammaticalSymbol r18der[] = {coma, E, Q}; 
		SintacticRule r18 = new SintacticRule(18, Q, r18der); //Q -> ,EQ
		
		table.addRule(Q, par2, r19);
		table.addRule(Q, coma, r18);
		
		
		//E
		GrammaticalSymbol r23der[] = {R,Eprima}; 
		SintacticRule r23 = new SintacticRule(23, E, r23der); //E -> RE'
		
		table.addRule(E, id, r23);
		table.addRule(E, par1, r23);
		table.addRule(E, entero, r23);
		table.addRule(E, cadena, r23);
		
		//E'
		GrammaticalSymbol r25der[] = {lambda}; 
		SintacticRule r25 = new SintacticRule(25, Eprima, r25der); //E' -> lambda
		
		GrammaticalSymbol r24der[] = {and, R, Eprima}; 
		SintacticRule r24 = new SintacticRule(24, Eprima, r24der); //E' -> && R E'
		
		table.addRule(Eprima, par2, r25);
		table.addRule(Eprima, and, r24);
		table.addRule(Eprima, CR_, r25);
		table.addRule(Eprima, coma, r25);
		
		//R
		GrammaticalSymbol r26der[] = {U, Rprima}; 
		SintacticRule r26 = new SintacticRule(26, R, r26der); //R -> U R'
		
		table.addRule(R, id, r26);
		table.addRule(R, par1, r26);
		table.addRule(R, entero, r26);
		table.addRule(R, cadena, r26);
		
		//R'
		GrammaticalSymbol r27der[] = {lambda}; 
		SintacticRule r27 = new SintacticRule(27, Rprima, r27der); //R' -> lambda
		
		GrammaticalSymbol r28der[] = {mayor, U, Rprima}; 
		SintacticRule r28 = new SintacticRule(28, Rprima, r28der); //R' -> > U R'
		
		table.addRule(Rprima, par2, r27);
		table.addRule(Rprima, mayor, r28);
		table.addRule(Rprima, coma, r27);
		table.addRule(Rprima, and, r27);
		table.addRule(Rprima, CR_, r27);
		
		
		//U
		GrammaticalSymbol r29der[] = {V, Uprima}; 
		SintacticRule r29 = new SintacticRule(29, U, r29der); //U -> VU'
		
		table.addRule(U, id, r29);
		table.addRule(U, par1, r29);
		table.addRule(U, entero, r29);
		table.addRule(U, cadena, r29);
		
		
		//U'
		GrammaticalSymbol r30der[] = {mas, V, Uprima}; 
		SintacticRule r30 = new SintacticRule(30, Uprima, r30der); //U' -> + V U'
		
		GrammaticalSymbol r31der[] = {menos, V, Uprima}; 
		SintacticRule r31 = new SintacticRule(31, Uprima, r31der); //U' -> - V U'
		
		GrammaticalSymbol r32der[] = {lambda}; 
		SintacticRule r32 = new SintacticRule(32, Uprima, r32der); //U' -> lambda
		
		
		table.addRule(Uprima, par2, r32);
		table.addRule(Uprima, mas, r30);
		table.addRule(Uprima, menos, r31);
		table.addRule(Uprima, CR_, r32);
		table.addRule(Uprima, and, r32);
		table.addRule(Uprima, mayor, r32);
		table.addRule(Uprima, coma, r32);
		
		
		//V
		GrammaticalSymbol r33der[] = {entero}; 
		SintacticRule r33 = new SintacticRule(33, V, r33der); //V -> entero
		
		GrammaticalSymbol r34der[] = {cadena}; 
		SintacticRule r34 = new SintacticRule(34, V, r34der); //V -> cadena
		
		GrammaticalSymbol r35der[] = {id, Y}; 
		SintacticRule r35 = new SintacticRule(35, V, r35der); //V -> id Y
		
		GrammaticalSymbol r36der[] = {par1, E, par2, J}; 
		SintacticRule r36 = new SintacticRule(36, V, r36der); //V -> ( E ) J
		
		
		table.addRule(V, id, r35);
		table.addRule(V, par1, r36);
		table.addRule(V, entero, r33);
		table.addRule(V, cadena, r34);
		
		
		//Y
		GrammaticalSymbol r37der[] = {par1, L, par2}; 
		SintacticRule r37 = new SintacticRule(37, Y, r37der); //Y -> ( L )
		
		GrammaticalSymbol r38der[] = {lambda}; 
		SintacticRule r38 = new SintacticRule(38, Y, r38der); //Y -> lambda
		
		
		table.addRule(Y, par1, r37);
		table.addRule(Y, par2, r38);
		table.addRule(Y, CR_, r38);
		table.addRule(Y, coma, r38);
		table.addRule(Y, and, r38);
		table.addRule(Y, mayor, r38);
		table.addRule(Y, mas, r38);
		table.addRule(Y, menos, r38);
		
		
		//J
		GrammaticalSymbol r39der[] = {interr, par1, E, par2, dos_puntos, par1, E, par2}; 
		SintacticRule r39 = new SintacticRule(39, J, r39der); //J -> ? (E) : (E)
		
		GrammaticalSymbol r40der[] = {lambda}; 
		SintacticRule r40 = new SintacticRule(40, J, r40der); //J -> lambda
		
		table.addRule(J, par2, r40);
		table.addRule(J, interr, r39);
		table.addRule(J, CR_, r40);
		
		
		//F
		GrammaticalSymbol r45der[] = {function_, H, id, par1, A, par2, Z, llave1, Z, C, llave2}; 
		SintacticRule r45 = new SintacticRule(45, F, r45der); //F -> function H id(A) Z { Z C }
		
		table.addRule(F, function_, r45);
		
		//H
		GrammaticalSymbol r46der[] = {T}; 
		SintacticRule r46 = new SintacticRule(46, H, r46der); //H -> T
		
		GrammaticalSymbol r47der[] = {lambda}; 
		SintacticRule r47 = new SintacticRule(47, H, r47der); //H -> lambda
		
		table.addRule(H, id, r47);
		table.addRule(H, char_, r46);
		table.addRule(H, bool_, r46);
		table.addRule(H, int_, r46);
		
		//A
		GrammaticalSymbol r48der[] = {T, id, K}; 
		SintacticRule r48 = new SintacticRule(48, A, r48der); //A -> T id K
		
		GrammaticalSymbol r49der[] = {lambda}; 
		SintacticRule r49 = new SintacticRule(49, A, r49der); //A -> lambda
		
		table.addRule(A, par2, r49);
		table.addRule(A, char_, r48);
		table.addRule(A, bool_, r48);
		table.addRule(A, int_, r48);
		
		//K
		GrammaticalSymbol r50der[] = {coma, T , id, K}; 
		SintacticRule r50 = new SintacticRule(50, K, r50der); //K -> , T id K
		
		GrammaticalSymbol r51der[] = {lambda}; 
		SintacticRule r51 = new SintacticRule(51, K, r51der); //K -> lambda
		
		
		table.addRule(K, par2, r51);
		table.addRule(K, coma, r50);
		
		//C
		GrammaticalSymbol r52der[] = {B, Z, C}; 
		SintacticRule r52 = new SintacticRule(52, C, r52der); //C -> BZC
		
		GrammaticalSymbol r53der[] = {lambda}; 
		SintacticRule r53 = new SintacticRule(53, C, r53der); //C -> lambda
		
		table.addRule(C, var_, r52);
		table.addRule(C, id, r52);
		table.addRule(C, switch_, r52);
		table.addRule(C, return_, r52);
		table.addRule(C, write_, r52);
		table.addRule(C, prompt_, r52);
		table.addRule(C, llave2, r53);
		table.addRule(C, if_, r52);
		
		
		//Z
		GrammaticalSymbol r54der[] = {CR_, Zprima}; 
		SintacticRule r54 = new SintacticRule(54, Z, r54der); //Z -> cr Z'
		
		table.addRule(Z, CR_, r54);
		
		//Z'
		GrammaticalSymbol r55der[] = {CR_, Zprima}; 
		SintacticRule r55 = new SintacticRule(55, Zprima, r55der); //Z' -> cr Z'
		
		GrammaticalSymbol r56der[] = {lambda}; 
		SintacticRule r56 = new SintacticRule(56, Zprima, r56der); //Z' -> lambda
		
		
		table.addRule(Zprima, llave2, r56);
		table.addRule(Zprima, llave1, r56);
		table.addRule(Zprima, eof, r56);
		table.addRule(Zprima, var_, r56);
		table.addRule(Zprima, id, r56);
		table.addRule(Zprima, switch_, r56);
		table.addRule(Zprima, return_, r56);
		table.addRule(Zprima, write_, r56);
		table.addRule(Zprima, prompt_, r56);
		table.addRule(Zprima, function_, r56);
		table.addRule(Zprima, case_, r56);
		table.addRule(Zprima, CR_, r55);
		table.addRule(Zprima, default_, r56);

		
		//T
		GrammaticalSymbol r20der[] = {char_}; 
		SintacticRule r20 = new SintacticRule(20, T, r20der); //T -> char
		
		GrammaticalSymbol r21der[] = {int_}; 
		SintacticRule r21 = new SintacticRule(21, T, r21der); //T -> int
		
		GrammaticalSymbol r22der[] = {bool_}; 
		SintacticRule r22 = new SintacticRule(22, T, r22der); //T -> bool
		
		table.addRule(T, char_, r20);
		table.addRule(T, int_, r21);
		table.addRule(T, bool_, r22);
		
		
		//W  
		GrammaticalSymbol r41der[] = {N, default_, dos_puntos, S, Z}; 
		SintacticRule r41 = new SintacticRule(41, W, r41der); //W -> N default : S Z
		
		table.addRule(W, case_, r41);
		
		//N 
		GrammaticalSymbol r42der[] = {case_, entero, dos_puntos, S, Z, Nprima}; 
		SintacticRule r42 = new SintacticRule(42, N, r42der); //N -> case entero : S Z N’

		table.addRule(N, case_, r42);
	
		//N'
		GrammaticalSymbol r43der[] = {N}; 
		SintacticRule r43 = new SintacticRule(43, Nprima, r43der); //N' -> N
		
		GrammaticalSymbol r44der[] = {lambda}; 
		SintacticRule r44 = new SintacticRule(44, Nprima, r44der); //N' -> lambda
		
		table.addRule(Nprima, case_, r43);
		table.addRule(Nprima, default_, r44);

		
		
		
		return table;
	}

}
















