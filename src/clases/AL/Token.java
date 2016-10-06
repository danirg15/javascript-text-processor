package AL;


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

	@Override
	public String toString() {
		return "Token [type=" + type + ", attr=" + attr + "]";
	}
	
}
