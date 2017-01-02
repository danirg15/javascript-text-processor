package extra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import symbolTable.SymbolTable;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class WriteToFile {
	private final static String[] file_names = {"./tokens.txt", "./parse.txt", "./tablas_de_simbolos.txt"}; 
	
	public WriteToFile() {
		
	}
	
	public static void cleanFiles() {
		try{
			for(String filename : file_names){
				File file = new File(filename);

	    		file.delete();
	    		
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	
	public void parse(String s) throws IOException {
		String filename = "./parse.txt";
		this.write(filename, "Descendente "+s);
	}
	
	
	public void symbolTable(SymbolTable st) throws IOException {
		String filename = "./tablas_de_simbolos.txt";
		
		String s = "CONTENIDO DE LA TABLA # "+ st.getId() +" : \n";
		
		for(String key : st.getTable().keySet()) {
			s += st.search(key).formattedEntry() + "\n";
			s += "-------------------------------------";
		}
		
		this.write(filename, s);
	}
	
	
	public void token(AttrTable tablePR, Token token) throws IOException{
		String filename = "./tokens.txt";
		
		if(token.getAttr() != null){
	    	if(token.getType() == TokenType.PR){
	    		this.write(filename, "<"+token.getType()+", "+ token.getAttr() +"> //"+tablePR.getAtIndex(Integer.parseInt(token.getAttr()))+"  \n");
	    	}else{
	    		this.write(filename, "<"+token.getType()+", "+ token.getAttr() +">\n");
	    	}	
	    }
		else{
		    this.write(filename, "<"+token.getType()+", >\n");
		}
		    
	}
	
	
	private void write(String filename, String s) throws IOException {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try{
			File file = new File(filename);

			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(s);
		    
		    bw.close();
			fw.close();
		} catch (IOException e) {
		   System.err.println("Error al escribir fichero ");
		   bw.close();
		   fw.close();
		}
	}


}
