import java.io.*;
import java.util.StringTokenizer;
/**
 * 
 * @author Hadi El-Kadri
 * This class scans texts documents from an input file and looks for the words from the file
 * then creating a BinSearhTreeObject to store the information
 *
 */
public class Searcher {
	
	//INITIALIZE VARIABLES
	
	private HashTable table; //a reference to the table of binary search trees that implements the lexicon data structure
	private String inputFile; // the name of the input file storing all words that will be searched for in the lexicon data structure

	/**
	 * Constructor for class Searcher
	 * @param table reference to the table of binary search trees that implements the lexicon data structure
	 * @param inputFile name of the input file storing all words that will be searched for in the lexicon data structure
	 */
	public Searcher(HashTable table, String inputFile) {
		this.table = table;
		this.inputFile = inputFile;
	}
	
	/**
	 * Reads the input file and invokes the findWord method to look for 
	 * all the give words in the file
	 */
	public void findAllWords(){
		try {
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		String line = in.readLine();
		String words [];
		while(line != null) {
			words = line.split(" ");
			for (int i = 0; i<words.length; i++) {
				findWord(words[i]);
			}
			line = in.readLine();
		}
		in.close();
	}
	catch (IOException e) {
		System.out.println("Invalid input");
	}
	}
	
	/**
	 * This method looks for searchWord in the lexicon
	 * @param searchWord the word to be found
	 */
	
	public void findWord(String searchWord) {
		int computation = table.computeIndex(searchWord);
		
		if (table.getTable()[computation].getWord(searchWord) == null) {
			CustomPrinter.wordNotFound(searchWord, inputFile);
		}
		
		else {
			CustomPrinter.wordFound(searchWord, inputFile);
			BinSearchTreeNode node = table.getTable()[computation].getWord(searchWord);
			LinkedList Lp = node.getFiles();
			FileNode file = Lp.getHead();
			while(file != null) {
				CustomPrinter.printPositionsPerFileFound(file.getFilename(), file.getPositions(), inputFile);
				file = file.getNext();
			}
			 
		}
	}
}
