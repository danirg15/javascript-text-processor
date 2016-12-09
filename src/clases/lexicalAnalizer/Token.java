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
	
	public boolean match(Token token){
		if(type == TokenType.ID || type == TokenType.STRING || type == TokenType.ENT){
			return true;
		}
		
		else if( (this.type == token.type && this.attr == null && token.attr == null) ||
				 (this.type == token.type && this.attr.equals(token.attr)) ){
			
			return true;	
		}
		
		return false;
	}
	
	public String getHash(){	
		if(type == TokenType.ID || type == TokenType.STRING || type == TokenType.ENT){
			return type + "";
		}
		else if(attr != null){
			return type+attr;
		}
		else{
			return type  +"";
		}	
		
	}
	
	@Override
	public String toString() {
		return "Token <" + type + ", " + attr + ">";
	}
	
}
