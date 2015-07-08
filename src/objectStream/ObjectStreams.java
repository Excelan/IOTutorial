package objectStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;

public class ObjectStreams {

	static final String dataFile = "ObjectsData.txt";

	static final BigDecimal[] prices = {
			new BigDecimal(1.99),
			new BigDecimal(2.99),
			new BigDecimal(3.99),
			new BigDecimal(4.99),
			new BigDecimal(5.99)
	};

	static final int[] units = { 1,2,3,4,5 };
	static final String[] names = { "ррA", "B-B", "T-Shirt", "Ololo", "Waradero" };

	public static void run() {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {

			out.writeObject(Calendar.getInstance());
			for (int i = 0; i < names.length; i++) {
				out.writeObject(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(names[i]);
				System.out.println("Written " + i);
			}

		} catch (Exception e) {
			System.out.println("чета не стримимся");
		}
		
		displayData();
	}

	private static void displayData() {
		
		Calendar clnd = null;
		BigDecimal price; 
		BigDecimal total = new BigDecimal(0);
		int itm;
		String name;
		
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			
			clnd = (Calendar)in.readObject();
			
			try {
				while(true){
					price = (BigDecimal)in.readObject();
					itm = in.readInt();
					name = in.readUTF();
					System.out.format("You ordered %d units of %s at $%.2f%n",
                            itm, name, price);
					
					total = total.add(price.multiply(new BigDecimal(itm)));
					
				}
			} catch (EOFException e) {
				System.out.format("For a TOTAL of: $%.2f%n", total);
			}
			
			System.out.format("Дата в стриме %tA, %<tB %<te, %<tY:%n", clnd);
			
		} catch (Exception e) {
			System.out.println("can't stream back");
		}
		
		
	}
	
	
	
}
