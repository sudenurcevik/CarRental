import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	public static ArrayList<String> read() throws FileNotFoundException { // returns the lines of the given file.
		ArrayList<String> lines = new ArrayList<>();

		try {
			Scanner keyboardScanner = new Scanner(new File("HW4_Rentals.csv"));
			String line;

			while (keyboardScanner.hasNextLine()) {

				line = keyboardScanner.nextLine();
				if (!line.equals("")) {
					lines.add(line);
				}
				
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
			
		return lines;

	}
}
