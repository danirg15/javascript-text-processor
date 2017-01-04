package semanticAnalizer;

import symbolTable.Types;


public class Attribute {
	private Types type;
	private Types returnType;
	private int lenght;
	
	public Attribute() {
		
	}
	
	

	public int getLenght() {
		return lenght;
	}



	public void setLenght(int lenght) {
		this.lenght = lenght;
	}



	public Types type() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public Types returnType() {
		return returnType;
	}

	public void setReturnType(Types returnType) {
		this.returnType = returnType;
	}

}
