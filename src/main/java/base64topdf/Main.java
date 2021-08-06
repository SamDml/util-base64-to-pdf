package base64topdf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {
public static void main(String[] args) {
		
		Path pathInput = Paths.get("C:\\Users\\SamDemeulemeester\\testfolders\\PDF.txt");
		Path pathOutPut = Paths.get("C:\\Users\\SamDemeulemeester\\testfolders\\output.pdf");
		
		try (FileReader fileReader = new FileReader(pathInput.toFile());
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				OutputStream outputStream = new FileOutputStream(pathOutPut.toFile())) {
			
			String line;
			while ( (line = bufferedReader.readLine()) != null ) {
				byte[] bytes = Base64.getDecoder().decode(line.getBytes());
				outputStream.write(bytes);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
