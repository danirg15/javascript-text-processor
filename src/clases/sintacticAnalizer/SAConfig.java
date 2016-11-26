package sintacticAnalizer;

import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class SAConfig {
	
	public static LL1Table getLL1Table(){
		
		LL1Table table = new LL1Table();
		
		NonTerminalSymbol E = new NonTerminalSymbol("E");
		NonTerminalSymbol Eprima = new NonTerminalSymbol("E'");
		NonTerminalSymbol T = new NonTerminalSymbol("T");
		NonTerminalSymbol Tprima = new NonTerminalSymbol("T'");
		NonTerminalSymbol F = new NonTerminalSymbol("F");
				
		TerminalSymbol lambda = new TerminalSymbol(new Token(TokenType.LAMBDA, null));
		
		TerminalSymbol id = new TerminalSymbol(new Token(TokenType.ID, null));
		TerminalSymbol mas = new TerminalSymbol(new Token(TokenType.MAS, null));
		TerminalSymbol eof = new TerminalSymbol(new Token(TokenType.$, null));
		
		GrammaticalSymbol r1der[] = {T,Eprima}; 
		SintacticRule r1 = new SintacticRule(1, E, r1der); //E -> TE'
		
		GrammaticalSymbol r2der[] = {F,Tprima}; 
		SintacticRule r2 = new SintacticRule(2, T, r2der); //T -> FT'
		
		GrammaticalSymbol r3der[] = {id}; 
		SintacticRule r3 = new SintacticRule(3, F, r3der); //F -> id
		
		GrammaticalSymbol r4der[] = {mas, T, Eprima}; 
		SintacticRule r4 = new SintacticRule(4, Eprima, r4der); //E' -> +TE'
		
		GrammaticalSymbol r5der[] = {lambda}; 
		SintacticRule r5 = new SintacticRule(5, Tprima, r5der);// T' -> lambda
		
		GrammaticalSymbol r6der[] = {lambda}; 
		SintacticRule r6 = new SintacticRule(6, Eprima, r6der);//E' -> lambda
		
		GrammaticalSymbol r7der[] = {lambda}; 
		SintacticRule r7 = new SintacticRule(7, Tprima, r7der);//T' -> lambda
		
		table.addRule(E, id, r1);
		
		
		table.addRule(T, id, r2);
		table.addRule(F, id, r3);
		
		table.addRule(Eprima, mas, r4);
		table.addRule(Tprima, mas, r5);
		
		table.addRule(Eprima, eof, r6);
		table.addRule(Tprima, eof, r7);
		
		
		return table;
	}

}
