package semanticAnalizer;

import java.util.ArrayList;

import symbolTable.Types;


public class Attribute {
	private Types type;
	private Types returnType;
	private ArrayList<Types> typesList;
	private int lenght;
	
	public Attribute() {
		this.typesList = new ArrayList<Types>();
	}
	
	
	
	public ArrayList<Types> getTypesList() {
		return typesList;
	}

	public void addListOfTypes(ArrayList<Types> list) {
		for(Types t : list){
			this.typesList.add(t);
		}
	}

	public void addTypeToList(Types t) {
		this.typesList.add(t);
	}
	
	public boolean typesListIsEqual(ArrayList<Types> list) {
		boolean match = true;
		
		if(this.typesList.size() == list.size()) {
			for(Types t : this.typesList) {
				if(!list.contains(t)) {
					match = false;
					break;
				}
			}
		}
		else {
			match = false;
		}
		
		return match;
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
