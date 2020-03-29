package gibbons_problem2;

public class Application {
	private static final String INPUT_FILE = "problem2.txt";
	private static final String OUTPUT_FILE = "unique_word_counts.txt";

	public static void main(String[] args) {
		Duplicate_Counter duplicateCounter = new Duplicate_Counter();
		duplicateCounter.count(INPUT_FILE);
		duplicateCounter.write(OUTPUT_FILE);
	}

}
