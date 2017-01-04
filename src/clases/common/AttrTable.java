package common;

import java.util.ArrayList;

public class AttrTable {
	private int index = 0;
	private ArrayList<String> table = new ArrayList<String>();

	public void add(String s){
		table.add(index, s);
		index++;
	}
	
	public int find(String s){
		return table.indexOf(s);		
	}
	
	public String getAtIndex(int i){
		return table.get(i);
	}
	
}
