package errorManager;

import java.io.IOException;


import lexicalAnalizer.LexicalAnalizer;
import common.WriteToFile;


public class ErrorManager {
	private static WriteToFile writeToFile = new WriteToFile();
	public static boolean thereAreErrors = false;
	
	public static void notify(ErrorTypes type, String msg) throws IOException{
		String err = "[Error " + type + " ] Linea: " + LexicalAnalizer.currentLine + " " + msg + "\n";
		
		thereAreErrors = true;
		
		writeToFile.error(err);	
		
		System.err.print(err);
		//System.exit(-1);
	}
	
}
