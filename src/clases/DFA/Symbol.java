package DFA;

public class Symbol {
	private char character;
	private Match match_type;
	
		
	public Symbol(char character, Match match_type){
		this.character = character;
		this.match_type = match_type;
	}
	
	public boolean match(char c){
		boolean result = false;
		
		switch(this.match_type){	
			case STD: 
				result = (this.character == c); 
				break;
				
			case DIGIT:
				result = isDigit(c);
				break;
				
			case LETTER:
				result = isLetter(c);
				break;	
			
			case DELIM:
				result = (isBlank(c) || isBreakLine(c) || isTab(c));
				break;	
		}
		
		return result;
	}
	
	
	public char getCharacter() {
		return character;
	}

	
	public boolean equals(Symbol s){
		if(this.character == s.getCharacter() && this.match_type == s.match_type){
			return true;
		}
		return false;
	}
	
	private boolean isDigit(char c){
		String s = String.valueOf(c);
		String regex = "\\d+";
		return s.matches(regex);
	}
	
	private boolean isLetter(char c){
		String s = String.valueOf(c);
		String regex = "[a-zA-Z]";
		return s.matches(regex);
	}
	
	private boolean isBlank(char c){
		return (int)c == 32;
	}
	
	private boolean isBreakLine(char c){
		return (int)c == 10;
	}

	private boolean isTab(char c){
		return (int)c == 9;
	}
	
	
	@Override
	public String toString() {
		return "(char: '" + character +  "' match_type=" + match_type+")";
	}
	
	
	
	
}
