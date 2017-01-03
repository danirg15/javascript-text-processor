package semanticAnalizer;


public class Attribute {
	Types type;
	Types returnType;
	
	public Attribute() {
		
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
