package analizer;

import extra.SourceFile;
import automata.DFA;

public abstract class LexicalAnalizer {
	private SourceFile source;
	private DFA automaton;
	
	public LexicalAnalizer(SourceFile source, DFA automaton) {
		this.source = source;
		this.automaton = automaton;
	}
	
	abstract public Token getNewToken() throws Exception;

	public SourceFile getSource() {
		return source;
	}

	public DFA getAutomaton() {
		return automaton;
	}
	
}
