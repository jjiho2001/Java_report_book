package module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

public class BookDataSet {

	public static TreeMap<Integer, BookInfo> bookList = new TreeMap<Integer, BookInfo>();
	
	public BookDataSet() {
		
	}

	public static void dataSave() {
		try {
			File f = new File("C://Users/Jiho Jung/Desktop/dev", "Booklist.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(BookDataSet.bookList);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dataLoad() {
		try {
			File f = new File("C://Users/Jiho Jung/Desktop/dev", "Booklist.txt");
			if(f.exists()) {
				FileInputStream ios = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(ios);
				
				BookDataSet.bookList = (TreeMap) ois.readObject();
				
				ois.close();
				ios.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
