package sintacticAnalizer;

import java.util.Stack;
import java.util.concurrent.Callable;

import semanticAnalizer.SemanticAction;
import semanticAnalizer.SemanticAnalizer;
import semanticAnalizer.Types;
import symbolTable.TSContainer;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class SinAConfig {
	
	public static LL1Table getLL1Table(){
		
		LL1Table table = new LL1Table();
		
		NonTerminalSymbol Pprima = 		new NonTerminalSymbol("P'");
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
		NonTerminalSymbol M = 	new NonTerminalSymbol("M");
		
	
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
		TerminalSymbol punto_coma = new TerminalSymbol(new Token(TokenType.PUNTO_COMA, null));
		
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
		TerminalSymbol if_ = 		new TerminalSymbol(new Token(TokenType.PR, "10"));
		TerminalSymbol break_ = 	new TerminalSymbol(new Token(TokenType.PR, "11"));
		
			
		//P'
		SemanticAction s1_1 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				SemanticAnalizer.setGlobalOffset(0);
				
				return null;
			}			
		});
		
		SemanticAction s1_2 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				TSContainer ts_container = new TSContainer();
				ts_container.destroy(SemanticAnalizer.getGST().getId());
				SintacticAnalizer.getAuxStack().pop();
				
				return null;
			}			
		});
		
		
		Object r1der[] = {s1_1, P, s1_2}; 
		SintacticRule r1 = new SintacticRule(1, Pprima, r1der); //P' -> P
		
		GrammaticalSymbol r2der[] = {Z, P}; 
		SintacticRule r2 = new SintacticRule(2, Pprima, r2der); //P' -> Z P
		
		table.addRule(Pprima, var_, r1);
		table.addRule(Pprima, id, r1);
		table.addRule(Pprima, switch_, r1);
		table.addRule(Pprima, return_, r1);
		table.addRule(Pprima, write_, r1);
		table.addRule(Pprima, prompt_, r1);
		table.addRule(Pprima, if_, r1);
		table.addRule(Pprima, function_, r1);
		table.addRule(Pprima, CR_, r2);
		
		
		//P
		SemanticAction s2_1 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				Stack<GrammaticalSymbol> aux_stack = SintacticAnalizer.getAuxStack();
				int top = aux_stack.size() - 1;
				
				aux_stack.elementAt(top - 3).getAttribute().setType( aux_stack.elementAt(top).getAttribute().type() );
				SintacticAnalizer.popAuxStack(3);
				
				return null;
			}			
		});
		
	
		Object r3der[] = {B,Z,P, s2_1}; 
		SintacticRule r3 = new SintacticRule(3, P, r3der); //P -> BZP
		
		GrammaticalSymbol r4der[] = {F,Z,P}; 
		SintacticRule r4 = new SintacticRule(4, P, r4der); //P -> FZP
		
		GrammaticalSymbol r5der[] = {lambda}; 
		SintacticRule r5 = new SintacticRule(5, P, r5der); //P -> lambda
		
		
		table.addRule(P, var_, r3);
		table.addRule(P, if_, r3);
		table.addRule(P, switch_, r3);
		table.addRule(P, return_, r3);
		table.addRule(P, id, r3);
		table.addRule(P, write_, r3);
		table.addRule(P, prompt_, r3);
		table.addRule(P, function_, r4);
		table.addRule(P, eof, r5);
		
		
		//B
		SemanticAction s3_1 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				Stack<GrammaticalSymbol> aux_stack = SintacticAnalizer.getAuxStack();
				int top = aux_stack.size() - 1;
				
				aux_stack.elementAt(top - 1).getAttribute().setType( aux_stack.elementAt(top).getAttribute().type() );
				aux_stack.elementAt(top - 1).getAttribute().setReturnType( aux_stack.elementAt(top).getAttribute().returnType() );
				SintacticAnalizer.popAuxStack(1);
				
				return null;
			}			
		});
		
		
		GrammaticalSymbol r6der[] = {var_, T, id}; 
		SintacticRule r6 = new SintacticRule(6, B, r6der); //B -> var T id
		
		Object r7der[] = {S, s3_1}; 
		SintacticRule r7 = new SintacticRule(7, B, r7der); //B -> S
		
		GrammaticalSymbol r8der[] = {if_, par1, E, par2, S}; 
		SintacticRule r8 = new SintacticRule(8, B, r8der); //B -> if ( E ) S
		
		GrammaticalSymbol r9der[] = {switch_, par1, E, par2, Z, llave1, Z, W, llave2}; 
		SintacticRule r9 = new SintacticRule(9, B, r9der); //B -> switch(E) Z { Z W }
		
		
		table.addRule(B, var_, r6);	
		table.addRule(B, return_, r7);	
		table.addRule(B, id, r7);	
		table.addRule(B, write_, r7);	
		table.addRule(B, prompt_, r7);	
		table.addRule(B, if_, r8);	
		table.addRule(B, switch_, r9);	
			
		
		//S
		SemanticAction s4_1 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				Stack<GrammaticalSymbol> aux_stack = SintacticAnalizer.getAuxStack();
				int top = aux_stack.size() - 1;
				
				if(aux_stack.elementAt(top).getAttribute().type() != Types.ERROR){
					aux_stack.elementAt(top-2).getAttribute().setType(Types.OK);
					aux_stack.elementAt(top-2).getAttribute().setReturnType( aux_stack.elementAt(top).getAttribute().type() );					
				}
				else{
					aux_stack.elementAt(top-2).getAttribute().setType(Types.ERROR);
				}
				
				SintacticAnalizer.popAuxStack(2);
				
				return null;
			}			
		});
		
		Object r10der[] = {return_, X, s4_1}; 
		SintacticRule r10 = new SintacticRule(10, S, r10der); //S -> return X
		
		GrammaticalSymbol r11der[] = {id, Sprima}; 
		SintacticRule r11 = new SintacticRule(11, S, r11der); //S -> id S'
		
		GrammaticalSymbol r12der[] = {write_, par1, E, par2}; 
		SintacticRule r12 = new SintacticRule(12, S, r12der); //S -> write ( E )

		GrammaticalSymbol r13der[] = {prompt_, par1, id, par2}; 
		SintacticRule r13 = new SintacticRule(13, S, r13der); //S -> prompt ( id )

		
		table.addRule(S, id, r11);		//S -> id S'
		table.addRule(S, return_, r10);	//S -> return  X
		table.addRule(S, write_, r12);	//S -> write ( E ) 
		table.addRule(S, prompt_, r13);	//S -> prompt ( id )
		
		
		//S'
		GrammaticalSymbol r14der[] = {asign, E}; 
		SintacticRule r14 = new SintacticRule(14, Sprima, r14der); //S' -> = E
		
		GrammaticalSymbol r15der[] = {par1, L, par2}; 
		SintacticRule r15 = new SintacticRule(15, Sprima, r15der); //S' -> ( L )
		
		table.addRule(Sprima, par1, r15);
		table.addRule(Sprima, asign, r14);
		
		
		//X
		SemanticAction s5_1 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				Stack<GrammaticalSymbol> aux_stack = SintacticAnalizer.getAuxStack();
				int top = aux_stack.size() - 1;
				
				aux_stack.elementAt(top).getAttribute().setType(Types.VOID);
				
				return null;
			}			
		});
		
		GrammaticalSymbol r16der[] = {E}; 
		SintacticRule r16 = new SintacticRule(16, X, r16der); //X -> E
		
		Object r17der[] = {lambda, s5_1}; 
		SintacticRule r17 = new SintacticRule(17, X, r17der); //X -> lambda
		
		table.addRule(X, id, r16);
		table.addRule(X, par1, r16);
		table.addRule(X, entero, r16);
		table.addRule(X, cadena, r16);
		table.addRule(X, CR_, r17);
		table.addRule(X, punto_coma, r17);
		
		
		//L
		GrammaticalSymbol r18der[] = {E,Q}; 
		SintacticRule r18 = new SintacticRule(18, L, r18der); //L -> E Q
		
		GrammaticalSymbol r19der[] = {lambda}; 
		SintacticRule r19 = new SintacticRule(19, L, r19der); //L -> lambda
		
		table.addRule(L, id, r18);
		table.addRule(L, par1, r18);
		table.addRule(L, entero, r18);
		table.addRule(L, cadena, r18);
		table.addRule(L, par2, r19);
		
	
		//Q
		GrammaticalSymbol r20der[] = {coma, E, Q}; 
		SintacticRule r20 = new SintacticRule(20, Q, r20der); //Q -> ,EQ
		
		GrammaticalSymbol r21der[] = {lambda}; 
		SintacticRule r21 = new SintacticRule(21, Q, r21der); //Q -> lambda
		
		table.addRule(Q, coma, r20);
		table.addRule(Q, par2, r21);
		
		
		//T
		GrammaticalSymbol r22der[] = {char_}; 
		SintacticRule r22 = new SintacticRule(22, T, r22der); //T -> chars
		
		GrammaticalSymbol r23der[] = {int_}; 
		SintacticRule r23 = new SintacticRule(23, T, r23der); //T -> int
		
		GrammaticalSymbol r24der[] = {bool_}; 
		SintacticRule r24 = new SintacticRule(24, T, r24der); //T -> bool
		
		table.addRule(T, char_, r22);
		table.addRule(T, int_, r23);
		table.addRule(T, bool_, r24);
		
		
		//E
		GrammaticalSymbol r25der[] = {R,Eprima}; 
		SintacticRule r25 = new SintacticRule(25, E, r25der); //E -> RE'
		
		table.addRule(E, id, r25);
		table.addRule(E, par1, r25);
		table.addRule(E, entero, r25);
		table.addRule(E, cadena, r25);
		
		
		//E'
		GrammaticalSymbol r26der[] = {and, R, Eprima}; 
		SintacticRule r26 = new SintacticRule(26, Eprima, r26der); //E' -> && R E'
		
		GrammaticalSymbol r27der[] = {lambda}; 
		SintacticRule r27 = new SintacticRule(27, Eprima, r27der); //E' -> lambda
		
		table.addRule(Eprima, and, r26);
		table.addRule(Eprima, par2, r27);
		table.addRule(Eprima, CR_, r27);
		table.addRule(Eprima, coma, r27);
		table.addRule(Eprima, punto_coma, r27);
		
		
		//R
		GrammaticalSymbol r28der[] = {U, Rprima}; 
		SintacticRule r28 = new SintacticRule(28, R, r28der); //R -> U R'
		
		table.addRule(R, id, r28);
		table.addRule(R, par1, r28);
		table.addRule(R, entero, r28);
		table.addRule(R, cadena, r28);
		
		
		//R'
		GrammaticalSymbol r29der[] = {mayor, U, Rprima}; 
		SintacticRule r29 = new SintacticRule(29, Rprima, r29der); //R' -> > U R'
		
		GrammaticalSymbol r30der[] = {lambda}; 
		SintacticRule r30 = new SintacticRule(30, Rprima, r30der); //R' -> lambda
		
		table.addRule(Rprima, mayor, r29);
		table.addRule(Rprima, par2, r30);
		table.addRule(Rprima, coma, r30);
		table.addRule(Rprima, and, r30);
		table.addRule(Rprima, CR_, r30);
		table.addRule(Rprima, punto_coma, r30);
		
		
		//U
		GrammaticalSymbol r31der[] = {V, Uprima}; 
		SintacticRule r31 = new SintacticRule(31, U, r31der); //U -> V U'
		
		table.addRule(U, id, r31);
		table.addRule(U, par1, r31);
		table.addRule(U, entero, r31);
		table.addRule(U, cadena, r31);
		
		
		//U'
		GrammaticalSymbol r32der[] = {mas, V, Uprima}; 
		SintacticRule r32 = new SintacticRule(32, Uprima, r32der); //U' -> + V U'
		
		GrammaticalSymbol r33der[] = {menos, V, Uprima}; 
		SintacticRule r33 = new SintacticRule(33, Uprima, r33der); //U' -> - V U'
		
		GrammaticalSymbol r34der[] = {lambda}; 
		SintacticRule r34 = new SintacticRule(34, Uprima, r34der); //U' -> lambda
		
		table.addRule(Uprima, mas, r32);
		table.addRule(Uprima, menos, r33);
		table.addRule(Uprima, par2, r34);
		table.addRule(Uprima, CR_, r34);
		table.addRule(Uprima, and, r34);
		table.addRule(Uprima, mayor, r34);
		table.addRule(Uprima, coma, r34);
		table.addRule(Uprima, punto_coma, r34);
		
		
		//V
		GrammaticalSymbol r35der[] = {entero}; 
		SintacticRule r35 = new SintacticRule(35, V, r35der); //V -> entero
		
		GrammaticalSymbol r36der[] = {cadena}; 
		SintacticRule r36 = new SintacticRule(36, V, r36der); //V -> cadena
		
		GrammaticalSymbol r37der[] = {id, Y}; 
		SintacticRule r37 = new SintacticRule(37, V, r37der); //V -> id Y
		
		GrammaticalSymbol r38der[] = {par1, E, par2, J}; 
		SintacticRule r38 = new SintacticRule(38, V, r38der); //V -> ( E ) J
		
		table.addRule(V, entero, r35);
		table.addRule(V, cadena, r36);
		table.addRule(V, id, r37);
		table.addRule(V, par1, r38);
		
		
		//Y
		GrammaticalSymbol r39der[] = {par1, L, par2}; 
		SintacticRule r39 = new SintacticRule(39, Y, r39der); //Y -> ( L )
		
		GrammaticalSymbol r40der[] = {lambda}; 
		SintacticRule r40 = new SintacticRule(40, Y, r40der); //Y -> lambda
		
		table.addRule(Y, par1, r39);
		table.addRule(Y, par2, r40);
		table.addRule(Y, CR_, r40);
		table.addRule(Y, punto_coma, r40);
		table.addRule(Y, coma, r40);
		table.addRule(Y, and, r40);
		table.addRule(Y, mayor, r40);
		table.addRule(Y, mas, r40);
		table.addRule(Y, menos, r40);
		
		
		//J
		GrammaticalSymbol r41der[] = {interr, par1, E, par2, dos_puntos, par1, E, par2}; 
		SintacticRule r41 = new SintacticRule(41, J, r41der); //J -> ? (E) : (E)
		
		GrammaticalSymbol r42der[] = {lambda}; 
		SintacticRule r42 = new SintacticRule(42, J, r42der); //J -> lambda
		
		table.addRule(J, interr, r41);
		
		table.addRule(J, par2, r42);
		table.addRule(J, CR_, r42);
		table.addRule(J, coma, r42);
		table.addRule(J, and, r42);
		table.addRule(J, mayor, r42);
		table.addRule(J, mas, r42);
		table.addRule(J, menos, r42);
		table.addRule(J, punto_coma, r42);
		
		
		//F
		GrammaticalSymbol r43der[] = {function_, H, id, par1, A, par2, Z, llave1, Z, C, llave2}; 
		SintacticRule r43 = new SintacticRule(43, F, r43der); //F -> function H id(A) Z { Z C }
		
		table.addRule(F, function_, r43);
		
		//H
		GrammaticalSymbol r44der[] = {T}; 
		SintacticRule r44 = new SintacticRule(44, H, r44der); //H -> T
		
		GrammaticalSymbol r45der[] = {lambda}; 
		SintacticRule r45 = new SintacticRule(45, H, r45der); //H -> lambda
		
		table.addRule(H, char_, r44);
		table.addRule(H, bool_, r44);
		table.addRule(H, int_, r44);
		table.addRule(H, id, r45);
		
		//A
		GrammaticalSymbol r46der[] = {T, id, K}; 
		SintacticRule r46 = new SintacticRule(46, A, r46der); //A -> T id K
		
		GrammaticalSymbol r47der[] = {lambda}; 
		SintacticRule r47 = new SintacticRule(47, A, r47der); //A -> lambda
		
		table.addRule(A, par2, r47);
		table.addRule(A, char_, r46);
		table.addRule(A, bool_, r46);
		table.addRule(A, int_, r46);
		
		
		//K
		GrammaticalSymbol r48der[] = {coma, T , id, K}; 
		SintacticRule r48 = new SintacticRule(48, K, r48der); //K -> , T id K
		
		GrammaticalSymbol r49der[] = {lambda}; 
		SintacticRule r49 = new SintacticRule(49, K, r49der); //K -> lambda
		
		table.addRule(K, par2, r49);
		table.addRule(K, coma, r48);
		
		
		//C
		GrammaticalSymbol r50der[] = {B, Z, C}; 
		SintacticRule r50 = new SintacticRule(50, C, r50der); //C -> BZC
		
		GrammaticalSymbol r51der[] = {lambda}; 
		SintacticRule r51 = new SintacticRule(51, C, r51der); //C -> lambda
		
		table.addRule(C, var_, r50);
		table.addRule(C, id, r50);
		table.addRule(C, switch_, r50);
		table.addRule(C, return_, r50);
		table.addRule(C, write_, r50);
		table.addRule(C, prompt_, r50);
		table.addRule(C, if_, r50);
		table.addRule(C, llave2, r51);
		
		
		//Z
		SemanticAction s6_1 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				SintacticAnalizer.popAuxStack(2);				
				
				return null;
			}			
		});
		
		Object r52der[] = {CR_, Zprima, s6_1}; 
		SintacticRule r52 = new SintacticRule(52, Z, r52der); //Z -> cr Z'
		
		table.addRule(Z, CR_, r52);
		
		//Z'
		SemanticAction s7_1 = new SemanticAction(new Callable<Object>() {
			public Object call() throws Exception {
				
				SintacticAnalizer.popAuxStack(2);				
				
				return null;
			}			
		});
		
		Object r53der[] = {CR_, Zprima, s7_1}; 
		SintacticRule r53 = new SintacticRule(53, Zprima, r53der); //Z' -> cr Z'
		
		GrammaticalSymbol r54der[] = {lambda}; 
		SintacticRule r54 = new SintacticRule(54, Zprima, r54der); //Z' -> lambda
		
		
		table.addRule(Zprima, CR_, r53);
		
		table.addRule(Zprima, llave2, r54);
		table.addRule(Zprima, llave1, r54);
		table.addRule(Zprima, eof, r54);
		table.addRule(Zprima, var_, r54);
		table.addRule(Zprima, id, r54);
		table.addRule(Zprima, switch_, r54);
		table.addRule(Zprima, return_, r54);
		table.addRule(Zprima, write_, r54);
		table.addRule(Zprima, prompt_, r54);
		table.addRule(Zprima, function_, r54);
		table.addRule(Zprima, case_, r54);
		table.addRule(Zprima, break_, r54);
		table.addRule(Zprima, if_, r54);
		table.addRule(Zprima, entero, r54);
		table.addRule(Zprima, cadena, r54);
		table.addRule(Zprima, par1, r54);
		
		
		//W  
		GrammaticalSymbol r55der[] = {case_, entero, dos_puntos, N, W}; 
		SintacticRule r55 = new SintacticRule(55, W, r55der); //W -> case ent : N W
		
		GrammaticalSymbol r56der[] = {lambda}; 
		SintacticRule r56 = new SintacticRule(56, W, r56der); //W -> lambda
		
		table.addRule(W, case_, r55);
		table.addRule(W, llave2, r56);
		
		
		//N 
		GrammaticalSymbol r57der[] = {S, Nprima}; 
		SintacticRule r57 = new SintacticRule(57, N, r57der); //N -> S N'
		
		GrammaticalSymbol r58der[] = {break_, Z}; 
		SintacticRule r58 = new SintacticRule(58, N, r58der); //N -> break Z
		
		table.addRule(N, return_, r57);
		table.addRule(N, id, r57);
		table.addRule(N, write_, r57);
		table.addRule(N, prompt_, r57);
		table.addRule(N, break_, r58);
		
	
		//N'
		GrammaticalSymbol r59der[] = {punto_coma, N}; 
		SintacticRule r59 = new SintacticRule(59, Nprima, r59der); //N' -> ; N
		
		GrammaticalSymbol r60der[] = {Z, M}; 
		SintacticRule r60 = new SintacticRule(60, Nprima, r60der); //N' -> Z M
		
		table.addRule(Nprima, punto_coma, r59);
		table.addRule(Nprima, CR_, r60);
		
		
		//M
		GrammaticalSymbol r61der[] = {lambda}; 
		SintacticRule r61 = new SintacticRule(61, M, r61der); //M -> lambda
		
		GrammaticalSymbol r62der[] = {N}; 
		SintacticRule r62 = new SintacticRule(62, M, r62der); //M -> N
		
		table.addRule(M, case_, r61);
		table.addRule(M, llave2, r61);
		table.addRule(M, break_, r62);
		table.addRule(M, return_, r62);
		table.addRule(M, id, r62);
		table.addRule(M, write_, r62);
		table.addRule(M, prompt_, r62);
		
		
		
		return table;
	}

}
















