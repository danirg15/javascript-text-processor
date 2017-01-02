package symbolTable;


public class Entry {
	private String lex;
	private IdentifierType identifierType = null;
	private Integer offset = null;
	//private String memoryAddr;
	//private int dimension;
	private int nArgs;
	private IdentifierType returnedIdentifier = null;
	
	
	public Entry(String lex){
		this.lex = lex;
	}


	public String getLex() {
		return lex;
	}
	

	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public IdentifierType getIdentifierType() {
		return identifierType;
	}


	public void setIdentifierType(IdentifierType identifierType) {
		this.identifierType = identifierType;
	}
	

	public int getnArgs() {
		return nArgs;
	}


	public void setnArgs(int nArgs) {
		this.nArgs = nArgs;
	}


	public IdentifierType getReturnedIdentifier() {
		return returnedIdentifier;
	}


	public void setReturnedIdentifier(IdentifierType returnedIdentifier) {
		this.returnedIdentifier = returnedIdentifier;
	}
	
	
	public String formattedEntry(){
	
		String s = "* LEXEMA : '" + this.lex + "'\n";
		s += "\t ATRIBUTOS : \n";
		
		if(this.identifierType != null) {
			s += "\t tipo : '"+ identifierType +"' \n";
		}
		else if(this.offset != null) {
			s += "\t desplazamiento : "+ offset +" \n";
		}
				

		return s;
	}

}
