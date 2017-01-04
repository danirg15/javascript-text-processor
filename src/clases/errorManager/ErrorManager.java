package errorManager;

import java.io.IOException;

import lexicalAnalizer.LexicalAnalizer;
import common.WriteToFile;


public class ErrorManager {
	private static WriteToFile writeToFile = new WriteToFile();
	
	public static void notifya(String msg) throws IOException{
		String err = "[Error] Linea: " + LexicalAnalizer.currentLine + " " + msg + "\n";
		System.err.println(err);
		writeToFile.error(err);	
	}
	
}
