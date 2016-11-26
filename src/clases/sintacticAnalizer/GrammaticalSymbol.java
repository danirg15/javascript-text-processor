package sintacticAnalizer;

import lexicalAnalizer.Token;

public interface GrammaticalSymbol {
	public boolean match(Object object);
}
