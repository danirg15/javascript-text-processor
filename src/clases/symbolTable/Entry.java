package symbolTable;


public class Entry {
	private String lex;
	private Types type = null;
	private Integer offset = null;
	//private String memoryAddr;
	//private int dimension;
	private int nArgs;
	private Types returnedType = null;
	
	
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


	public Types getType() {
		return type;
	}


	public void setType(Types type) {
		this.type = type;
	}
	

	public int getnArgs() {
		return nArgs;
	}


	public void setnArgs(int nArgs) {
		this.nArgs = nArgs;
	}


	public Types getReturnedIdentifier() {
		return returnedType;
	}


	public void setReturnedType(Types returnedType) {
		this.returnedType = returnedType;
	}
	
	
	public String formattedEntry(){
	
		String s = "* LEXEMA : '" + this.lex + "'\n";
		s += "\t ATRIBUTOS : \n";
		
		if(this.type != null) {
			s += "\t tipo : '"+ type +"' \n";
		}
		else if(this.offset != null) {
			s += "\t desplazamiento : "+ offset +" \n";
		}
				

		return s;
	}

}
