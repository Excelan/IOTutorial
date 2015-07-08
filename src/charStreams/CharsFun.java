package charStreams;

import java.io.IOException;
import java.io.PrintWriter;

public class CharsFun {

	public void run() {
		System.out.println("Hello World!");

		try(PrintWriter pw = new PrintWriter("HelloEcho")){
			pw.println("Hello echo!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
}
