package AFD;

import AL.Analizer;

public class TestAFD {

	
	public static void main(String[] args) throws Exception{
		NonFinalState a = new NonFinalState("estado1");
		FinalState b = new FinalState("estado2");
		NonFinalState[] nofinales = {a};
		FinalState[] finales = {b};
		
		Symbol s1 = new Symbol('*', MATCH_TYPE.DIGIT);
	    Symbol s2 =	new Symbol('*', MATCH_TYPE.LETTER);
		Symbol s3 = new Symbol('a', MATCH_TYPE.STD);
		
		Symbol[] alph = { s1, s2, s3 };
		
		TransitionMatrix matrix = new TransitionMatrix(nofinales, finales, alph);
		
		matrix.addTransition(new Transition(a, s1, b));
		matrix.addTransition(new Transition(a, s3, a));
		matrix.addTransition(new Transition(a, s2, b));
		
		
		
		AFD afd = new AFD(a, matrix);

	
		System.out.println(afd.toString());
	
		
		////////////////////TEST////////////////////////////
		
		
		System.out.println("\nTransita al estado: " + afd.transit(a, 'q'));
		
		Analizer an = new Analizer(afd, "/Users/dani/Documents/workspace/PDL/src/clases/text");
		
		an.step();
	
				
		
	}
	
}
