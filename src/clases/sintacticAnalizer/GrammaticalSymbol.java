package sintacticAnalizer;

import semanticAnalizer.Attribute;

public interface GrammaticalSymbol {
	public boolean match(Object object);
	public Attribute getAttribute();
	//public void setAttribute(Attribute attribute);
}
