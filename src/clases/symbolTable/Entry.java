package symbolTable;

import java.util.ArrayList;


public class Entry {
	private String lex;
	private Types type = null;
	private Integer offset = null;
	private int nArgs;
	private ArrayList<Types> typesList;
	private Types returnedType = null;
	private int idToReferencedTable;
	
	
	public Entry(String lex){
		this.lex = lex;
		this.typesList = new ArrayList<Types>();
	}
	
	public void addTypeToList(Types t) {
		this.typesList.add(t);
	}
	
	public void addListOfTypes(ArrayList<Types> list) {
		for(Types t : list){
			this.typesList.add(t);
		}
	}
	
	public ArrayList<Types> getTypesList() {
		return this.typesList;
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


	public Types getReturnedType() {
		return returnedType;
	}


	public void setReturnedType(Types returnedType) {
		this.returnedType = returnedType;
	}
	
	
	
	
	public int getIdToReferencedTable() {
		return idToReferencedTable;
	}

	public void setIdToReferencedTable(int idToReferencedTable) {
		this.idToReferencedTable = idToReferencedTable;
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
