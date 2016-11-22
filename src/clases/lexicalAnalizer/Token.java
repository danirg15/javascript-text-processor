package lexicalAnalizer;


public class Token {
	private TokenType type;
	private String attr;
	
	public Token(TokenType type, String attr) {
		this.type = type;
		this.attr = attr;
	}

	public TokenType getType() {
		return type;
	}

	public String getAttr() {
		return attr;
	}
	
	public boolean equals(Token token){
		if(this.type == token.type && this.attr == token.attr){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Token <" + type + ", " + attr + ">";
	}
	
}
