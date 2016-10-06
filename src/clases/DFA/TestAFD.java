package DFA;

import AL.ExampleLexicalAnalizer;
import AL.SourceFile;


public class TestAFD {

	
	public static void main(String[] args) throws Exception{
		NonFinalState a = new NonFinalState("estado1");
		FinalState b = new FinalState("estado2");
		NonFinalState[] nofinales = {a};
		FinalState[] finales = {b};
		
		Symbol s1 = new Symbol('*', Match.DIGIT);
	    Symbol s2 =	new Symbol('*', Match.LETTER);
		Symbol s3 = new Symbol('a', Match.STD);
		
		Symbol[] alph = { s1, s2, s3 };
		
		TransitionMatrix matrix = new TransitionMatrix(nofinales, finales, alph);
		
		matrix.addTransition(new Transition(a, s1, b));
		matrix.addTransition(new Transition(a, s3, a));
		matrix.addTransition(new Transition(a, s2, b));
		
		
		
		DFA afd = new DFA(a, matrix);

	
		System.out.println(afd.toString());
	
		
		////////////////////TEST////////////////////////////
		
		
		System.out.println("\nTransita al estado: " + afd.transit(a, 'q'));
		
		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/text");
		
		sf.open();
		
		ExampleLexicalAnalizer an = new ExampleLexicalAnalizer(sf, afd);
		
		System.out.println(an.getNewToken());
		
		
		sf.close();
	
				
		
	}
	
}
