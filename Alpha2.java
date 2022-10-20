import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Alpha2 {

	
	public static void main(String[] args) throws IOException {
		
		Reader r = new FileReader(new File("alpha.txt"));
		BufferedReader br = new BufferedReader(r);
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line=br.readLine())!=null) {
			sb.append(line);
			
		}
		
	}
}
