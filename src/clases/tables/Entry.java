package tables;

public class Entry {
	private String name;
	private IdentifierType identifierType;
	private String memoryAddr;
	private int dimension;
	private int nArgs;
	private IdentifierType returnedIdentifier;
	
	
	public Entry(String name){
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public IdentifierType getIdentifierType() {
		return identifierType;
	}


	public void setIdentifierType(IdentifierType identifierType) {
		this.identifierType = identifierType;
	}


	public String getMemoryAddr() {
		return memoryAddr;
	}


	public void setMemoryAddr(String memoryAddr) {
		this.memoryAddr = memoryAddr;
	}


	public int getDimension() {
		return dimension;
	}


	public void setDimension(int dimension) {
		this.dimension = dimension;
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
	
	
	

}
