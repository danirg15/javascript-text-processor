package AL;

import DFA.DFA;

public class ExampleLexicalAnalizer extends LexicalAnalizer{

	public ExampleLexicalAnalizer(SourceFile source, DFA automaton) {
		super(source, automaton);
	}

	@Override
	public Token getNewToken() throws Exception {		
		
		int c = getSource().read();
		
		switch(c){
		
		}
	
		return null;
	}
	
}