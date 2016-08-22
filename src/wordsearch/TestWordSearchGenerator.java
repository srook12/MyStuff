package wordsearch;

public class TestWordSearchGenerator {

	public static void main(String[] args) {
		WordSearchGenerator wordSearch = new WordSearchGenerator(15, 15, args[0]);
		
		System.out.println(wordSearch);
	}

}
