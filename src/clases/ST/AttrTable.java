package ST;

import java.util.ArrayList;

public class AttrTable {
	private static int index = 0;
	private static ArrayList<String> table = new ArrayList<String>();

	public static void add(String s){
		table.add(index, s);
		index++;
	}
	
	public static int find(String s){
		return table.indexOf(s);		
	}
	
	public static String getAtIndex(int i){
		return table.get(i);
	}
	
}
