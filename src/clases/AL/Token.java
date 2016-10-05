package AL;


public class Token {
	private TOKEN_TYPE type;
	private String attr;
	
	public Token(TOKEN_TYPE type, String attr) {
		this.type = type;
		this.attr = attr;
	}

	public TOKEN_TYPE getType() {
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
