package AL;
import AFD.AFD;


public class Analizer {

	private SourceFile source;
	
	public Analizer(AFD afd, String filepath){
		this.source = new SourceFile(filepath);
		
		this.source.open();
	}
	
	public void step() throws Exception{
		
		int c;
		
		while((c = this.source.read()) != -1){
			System.out.println (c + " --> " + (char)c);
		}
		
		this.source.close();
	}
	
}
