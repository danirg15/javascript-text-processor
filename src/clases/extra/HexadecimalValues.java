package extra;

import java.util.HashMap;

public class HexadecimalValues {
	private static HashMap<String, Integer> hex;
	
	public static HashMap<String, Integer> get(){
		hex = new HashMap<String, Integer>();
		hex.put("0", 0);
		hex.put("1", 1);
		hex.put("2", 2);
		hex.put("3", 3);
		hex.put("4", 4);
		hex.put("5", 5);
		hex.put("6", 6);
		hex.put("7", 7);
		hex.put("8", 8);
		hex.put("9", 9);
		hex.put("A", 10);
		hex.put("B", 11);
		hex.put("C", 12);
		hex.put("D", 13);
		hex.put("E", 14);
		hex.put("F", 15);
		return hex;
	}
	
}
