package gibbons_problem1;

public class Application {

	public static void main(String[] args) {
		DuplicateRemover duplicateRemover= new DuplicateRemover();
		duplicateRemover.remove("problem1.txt");
		duplicateRemover.Write("unique_words.txt");
	}
	
}
