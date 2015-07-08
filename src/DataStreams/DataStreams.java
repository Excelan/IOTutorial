package DataStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreams {

	static final String dataFile = "DataStreams.txt";

	static final double[] prices = {10, 11.1, 12.67, 3, 0.01};
	static final int[] units = {5, 33, 0, 10, 1};
	static final String[] descs = {
			"Java T-shirt",
			"Java Mug",
			"Duke Juggling Dolls",
			"Java Pin",
	"Java Key Chain" };


	public static void run() {

		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile))))
		{
			for (int i = 0; i < descs.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		readDataStream();

	}


	private static void readDataStream() {

		double price;
		int unit;
		String desc;
		double total = 0.0;

		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile))))
		{
			try {
				while (true) {
					price = in.readDouble();
					unit = in.readInt();
					desc = in.readUTF();
					System.out.format("You ordered %d" + " units of %s at $%.2f%n",
							unit, desc, price);
					total += unit * price;
				}
			} catch (EOFException e) {
				System.out.format("For a TOTAL of: $%.2f%n", total);	
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
