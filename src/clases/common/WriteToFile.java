package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import symbolTable.SymbolTable;
import lexicalAnalizer.Token;
import lexicalAnalizer.TokenType;

public class WriteToFile {
	private final static String[] file_names = {"./tokens.txt", "./parse.txt", "./tablas_de_simbolos.txt", "./errores.txt"}; 	
	private static ArrayList<SymbolTable> tables = new  ArrayList<SymbolTable>(); 
	
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
	
	
	public void symbolTable(SymbolTable tabla) throws IOException {
		String filename = "./tablas_de_simbolos.txt";
		
		tables.add(tabla);
		
		if(tabla.getName() == "GLOBAL") {
			String s;
			
			s = tables.get(tables.size()-1).toString();
			s += "-------------------------------------\n";
			this.write(filename, s);
			
			tables.remove(tables.size()-1);
			
			for(SymbolTable st : tables){
				s = st.toString();
				s += "-------------------------------------\n";
				this.write(filename, s);
			}
		}
		
	}
	
	
	public void token(AttrTable tablePR, Token token) throws IOException{
		String filename = "./tokens.txt";
		
		if(token != null && token.getAttr() != null){
	    	if(token.getType() == TokenType.PR){
	    		this.write(filename, "<"+token.getType()+", "+ token.getAttr() +"> //"+tablePR.getAtIndex(Integer.parseInt(token.getAttr()))+"  \n");
	    	}else{
	    		
	    		if(token.getType() == TokenType.STRING)
	    			this.write(filename, "<"+token.getType()+", \""+ token.getAttr() +"\">\n");
	    		else
	    			this.write(filename, "<"+token.getType()+", "+ token.getAttr() +">\n");
	    		
	    	}	
	    }
		else if(token != null){
		    this.write(filename, "<"+token.getType()+", >\n");
		}
		    
	}
	
	public void error(String msg) throws IOException{
		String filename = "./errores.txt";
		this.write(filename,  msg + "\n");    
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
