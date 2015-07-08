package byteStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FunStreams {

	public static void run() {
		// TODO Auto-generated method stub
		try (FileInputStream input = new FileInputStream("File_Input_Sream")) {
			
			int b;
			while ((b = input.read()) != -1 ) {
				System.out.println((char)(b));				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			try (FileOutputStream output = new FileOutputStream("File_Input_Sream")) {
				output.write("wHY".getBytes());
				
			} catch ( IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				e.printStackTrace();
			}
		}
	}

}
