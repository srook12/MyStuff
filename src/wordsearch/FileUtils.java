package wordsearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static final String ERR_FILE_NOT_FOUND = "Error - file not found! ";
	public static final String ERR_READ_FILE = "Error reading file: ";
	
	// For file reading
	private static BufferedReader br = null;
	
	public static List<String> getFileContents(String fileName) {
		List<String> contents = new ArrayList<String>();
		
		openFile(fileName);
		contents = readContents(fileName);
		
		return contents;
	}
	
	// Open the file given on the command line
	public static void openFile(String fileName) {		
		// Attempt to open the file 
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.err.println(ERR_FILE_NOT_FOUND + fileName);
			System.exit(1);
		}		
	}
	
	// Grab the problems from each line of the file
	public static List<String> readContents(String fileName) {
		List<String> wordList = new ArrayList<String>();
			
		String word = "";
		try {
			while((word = br.readLine()) != null) {
				wordList.add(word);
			}
		} catch (IOException ie) {
			System.err.println(ERR_READ_FILE + fileName);
			System.exit(1);
		}
			
		return wordList;
	}
		
	// Close the file
	public static void closeFile() {
		// Clean up after we're done
		try {
			br.close();
		} catch (IOException e) {
			// Ignore
		}
	}
}
