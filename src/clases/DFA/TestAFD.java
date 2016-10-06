package DFA;

import AL.ExampleLexicalAnalizer;
import AL.SourceFile;


public class TestAFD {

	
	public static void main(String[] args) throws Exception{
		NonFinalState a = new NonFinalState("estado1");
		FinalState b = new FinalState("estado2");
		NonFinalState[] nofinales = {a};
		FinalState[] finales = {b};
		
		//Symbol s1 = new Symbol('*', Match.DIGIT);
	    //Symbol s2 =	new Symbol('*', Match.LETTER);
		Symbol s3 = new Symbol('a', Match.STD);
		Symbol s4 = new Symbol('b', Match.STD);
		
		Symbol[] alph = { s3, s4 };
		
		TransitionMatrix matrix = new TransitionMatrix(nofinales, finales, alph);
		
		matrix.addTransition(new Transition(a, s4, b, SemanticAction.B));
		matrix.addTransition(new Transition(a, s3, a, SemanticAction.A));
		//matrix.addTransition(new Transition(a, s2, b, SemanticAction.B));
		
		
		
		DFA afd = new DFA(a, matrix);

	
		System.out.println(afd.toString());
	
		
		////////////////////TEST////////////////////////////
		
			
		
		
		SourceFile sf = new SourceFile("/Users/dani/Documents/workspace/PDL/src/clases/text");
		
		sf.open();
		
		ExampleLexicalAnalizer an = new ExampleLexicalAnalizer(sf, afd);
		
		an.getNewToken();
		an.getNewToken();
		//an.getNewToken();
		
		
		
		sf.close();
	
				
		
	}
	
}
