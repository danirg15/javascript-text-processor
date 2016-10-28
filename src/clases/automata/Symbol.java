package automata;

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
				
			case CR:
				result = isBreakLine(c);
				break;
			
			case OTHER_CHAR:
				result = true;
				break;
							
			case CHAR_EXCEPT_QUOTE:
				result = (c != '"');
				break;
				
			case HEX_CHAR:
				result = isAnHexChar(c);
				break;
				
			case DIGIT_EXCEPT_ZERO:
				result =  c!='0' && isDigit(c);
				break;
		}
		
		return result;
	}
	
	
	public char getCharacter() {
		return character;//.getCharValue();
	}
	
	public Match getMatchType(){
		return this.match_type;
	}
	
	public boolean equals(Symbol s){
		if(this.character == s.getCharacter() && 
		   this.match_type == s.match_type){
			
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
	
	private boolean isAnHexChar(char c){
		String s = String.valueOf(c);
		String regex = "^[0-9A-F]$";
		return s.matches(regex);
	}
	
	
	@Override
	public String toString() {
		
		if(this.match_type == Match.STD){
			return "(char: '" + character +  "')";
		}
		else{
			return "(" + match_type +")";
		}
	}
	
	
	
	
}
