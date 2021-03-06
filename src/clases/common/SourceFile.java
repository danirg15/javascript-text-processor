package common;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SourceFile {
	private int currentChar;
	private boolean fileOpened;
	private String path;
	private FileInputStream fileInput;
	
	public SourceFile(String path) {
		this.path = path;
		this.fileOpened = false;
	}

	public void open() {
		if(!this.fileOpened){
			try {
				this.fileInput = new FileInputStream(this.path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			this.fileOpened = true;
		}
	}

	public int read() throws Exception {
		if(!this.fileOpened)
			throw new Exception("El fichero fuente no esta abierto!");
		
		this.currentChar = fileInput.read();

		//System.out.println("Read: "+(char)c +"("+c+")");
		return currentChar;
	}
	
	
	public int getCurrentChar() {
		return currentChar;
	}

	public void close() {
		try {
			this.fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.fileOpened = false;
	}
}
