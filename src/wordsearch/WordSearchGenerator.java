package wordsearch;

import java.util.ArrayList;
import java.util.List;

public class WordSearchGenerator {
	
	// Directional constants
	private static final int NORTH = 0;
	private static final int NORTHEAST = 1;
	private static final int EAST = 2;
	private static final int SOUTHEAST = 3;
	private static final int SOUTH = 4;
	private static final int SOUTHWEST = 5;
	private static final int WEST = 6;
	private static final int NORTHWEST = 7;
	
	private int rows;
	private int cols;
	private char[][] grid;
	private List<String> wordList;
	
	public WordSearchGenerator(int rows, int cols, String wordListFile) {
		this.rows = rows;
		this.cols = cols;
		
		grid = new char[rows][cols];
		wordList = new ArrayList<String>();
		
		// Create blank grid
		constructBlankGrid();
		
		// Read the words from a file and store them in a list
		storeWordsInList(wordListFile);
	}
	
	private void constructBlankGrid() {
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				grid[r][c] = (char) (Math.random()*26 + 'A');				
			}
		}
	}
	
	private void storeWordsInList(String wordListFile) {
		wordList = FileUtils.getFileContents(wordListFile);
	}
	
	private void placeWords() {
		/* Algorithm:
		 *     -For each word in the list	
		 *         -Calculate a random orientation to place the word
		 *         -Calculate a random (row, col) to place a word
		 * 		   -Determine whether it is possible to place the word there
		 *         -If yes, place the word
		 *         -Else recalculate
		 */         
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				sb.append(grid[r][c]);
				
				if(c < (cols - 1)) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		sb.append("=====================\n");
		sb.append("Word List\n\n");

		int numCols = 4;
		int numWordsPerCol = wordList.size() / numCols; 
		
		for(int i = 0; i < numWordsPerCol; i++) {
			for(int j = 0; j < (numCols+1); j++) {
				int position = i + numWordsPerCol*j;
				if(position < wordList.size()) {
					sb.append(String.format("%-10s  ", wordList.get(position)));
				} else {
					break;
				}
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
