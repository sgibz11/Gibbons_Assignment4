package gibbons_problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
	//This method will take the file names as input and remove the duplicate words using the Set
	private Set<String>uniqueWords;
	public DuplicateRemover() {
		uniqueWords=new HashSet<>();
	}
	public void remove(String dataFile) {
		try {
			Scanner scan = new Scanner(new File(dataFile));
			while (scan.hasNext()) {
				uniqueWords.add(scan.next());
			}
			scan.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	//This method will write the contents of Set to the output file
	public void Write(String outputFile) {
		try {
			PrintWriter pt= new PrintWriter(new File(outputFile));
			for (String string: uniqueWords) {
				pt.println(string);
			}
			pt.flush();
			pt.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
