package gibbons_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Duplicate_Counter {
	private Integer wordCounter;
	private Map<String, Integer> map;
	
	public Duplicate_Counter() {
		this.map= new HashMap<>();
	}
	
	public void count(String dataFile) {
		//read the file line-by-line
		Scanner fileReader;
		try {
			fileReader= new Scanner(new File(dataFile));
			while(fileReader.hasNextLine()) {
				String line= fileReader.nextLine().trim(); 
				String[] data= line.split("[\\W]+");
				for(String word: data) {
					this.wordCounter= map.get(word);
					this.wordCounter= (this.wordCounter==null)?1: ++this.wordCounter;
					map.put(word, this.wordCounter);
				}
			}
			fileReader.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("File" +dataFile+ "can not be found.");
			System.exit(1);
		}
	}
	public void write(String outputFile) {
		FileWriter fileWriter;
		PrintWriter printWriter;
		try {
			fileWriter= new FileWriter(new File(outputFile));
			printWriter= new PrintWriter(fileWriter);
			for(Map.Entry<String, Integer>entry: map.entrySet()) {
				printWriter.write(entry.getKey()+ " occurs " + entry.getValue() + " times." +System.lineSeparator());
			}
			System.out.println("Map data written to file: " +outputFile);
			printWriter.flush();
			fileWriter.close();
			printWriter.close();
		}
		catch(IOException ex) {
			System.out.println("Error in writing to " +outputFile+ ":" +ex.getMessage());
			System.exit(1);
		}
	
	}
}
