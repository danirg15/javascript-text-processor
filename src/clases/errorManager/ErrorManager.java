package errorManager;

import java.io.IOException;


import lexicalAnalizer.LexicalAnalizer;
import common.WriteToFile;


public class ErrorManager {
	private static WriteToFile writeToFile = new WriteToFile();
	
	public static void notify(ErrorTypes type, String msg) throws IOException{
		String err = "[Error " + type + " ] Linea: " + LexicalAnalizer.currentLine + " " + msg + "\n";
		System.err.println(err);
		writeToFile.error(err);	
	}
	
}