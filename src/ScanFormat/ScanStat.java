package ScanFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

//https://docs.oracle.com/javase/tutorial/essential/io/scanning.html


public class ScanStat 
{
	public static void run() {

		try (Scanner scan = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")))) 
		{
			// scan.useDelimiter(",\\s*"); //a comma, optionally followed by white space
			scan.useLocale(Locale.US);
			// scan.useLocale(new Locale("ru"));
			while (scan.hasNext()) {
				System.out.println(scan.next());
			}
			
			
		} catch (Exception e) {
			System.out.println("Scanner error: " + e);
		}
		
		runNumbers();
	}

	
	public static void runNumbers() {
		System.out.println("runNumbers");
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")))) 
		{
			// scan.useDelimiter(",\\s*"); //a comma, optionally followed by white space
			scan.useLocale(Locale.US);
			// scan.useLocale(new Locale("ru"));
			
			double d = 0;
			
			while (scan.hasNext()) {
				if (scan.hasNextDouble()) {
					d+=scan.nextDouble();
				} else scan.next();
				
			}

			System.out.format("Double is: %040.20f%n", d);
			System.out.format("Double is: %+40.20f%n", d);
			System.out.format("Double is: %0+40.20f%n", d);
			System.out.format("Double is: %+040.20f%n", d);
			System.out.format("Double is: %60.40f%n", d);
			System.out.format("Double is: %40.20f%n", d);
			System.out.format("Double is: %40.10f%n", d);
			System.out.format("Double is: %40.4f%n", d);
			System.out.format("Double is: %-40.4f%n", d);
			
		} catch (Exception e) {
			System.out.println("Scanner error: " + e);
		}
	}
	
}
