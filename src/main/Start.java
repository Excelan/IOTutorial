package main;

import DataStreams.DataStreams;
import ScanFormat.ScanStat;
import byteStreams.FunStreams;
import objectStream.ObjectStreams;
import sysConsole.funConsole;

public class Start {

	public static void main(String[] args) {
		System.out.println("Programm started");
		if (args.length!=0) {
			invoke(args[0]);
		}  else System.out.println("Нужно указать параметр при вызове программы");

	}

	private static void invoke(String string) {
		System.out.println("arg is: "+string);
		switch (string) {
		case "b":
			FunStreams.run();
			break;
		case "scan":
			ScanStat.run();
			break;
		case "console":
			funConsole.run();
			break;
		case "dataStreams":
			DataStreams.run();
			break;
		case "objStreams":
			ObjectStreams.run();
			break;
			
		default:
			break;
		}
		
	}

}
