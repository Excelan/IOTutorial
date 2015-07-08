package sysConsole;

import java.io.Console;

public class funConsole {

	public static void run() {
		Console c = System.console();
		if (c == null){
			System.out.println("No console.");
			System.exit(1);
		}
		
		c.format("console is %d times better", 100);
	}
}
