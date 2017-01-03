package semanticAnalizer;

import java.util.concurrent.Callable;

public class SemanticAction {
	private Callable<?> func;
	
	public SemanticAction(Callable<?> func) {
		this.func = func;
	}
	
	public void exec() throws Exception {
		this.func.call();
	}
	
	
}
