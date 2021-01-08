/**
 * 
 * @author Hadi El-Kadri 251015226
 * 
 * This class BinSearchTree implements a binary search tree using a linked list
 * 
 */

public class BinSearchTree {
	
	//INSTANCE VARIABLES INITIALIZED
	
	//Refers to the root node of the binary search tree
	private BinSearchTreeNode root;
	
	/**
	 * Method getWord returns the node in the tree containing searchWord
	 * @param searchWord is the word to find in the binary tree
	 * @return the node storing the desired word or null if no node stores the word
	 */
	public BinSearchTreeNode getWord(String searchWord) {
		return search(root, searchWord);
	}
	
	/**
	 * Method searchWord checks each node to see if it contains the given word
	 * @param r the current node being searched starting at root and traversing through the tree
	 * @param searchWord is the word being searched for
	 * @return r or recursively calls the method
	 */
	private BinSearchTreeNode search(BinSearchTreeNode r, String searchWord) {
		if (r==null) return null;
		else if (searchWord.equals(r.getWord())) return r;
		else if (searchWord.compareTo(r.getWord())<0) return search(r.getLeft(), searchWord);
		else return search(r.getRight(), searchWord);
	}
	
	/**
	 * This method searches for a node storing the word and if it is found, the file name and position
	 * is added to the node p
	 * @param theWord is to be looked for
	 * @param theFileName the name of the file where the word is found
	 * @param thePosition where in the file the word is found
	 */
	public void insertWord(String theWord, String theFileName, int thePosition) {
		BinSearchTreeNode p = this.getWord(theWord);
		if (p!=null&&p.getWord().equals(theWord)) {
			LinkedList Lp = p.getFiles();
			Lp.insertWord(theFileName, thePosition);
		}
		else insert(root, theWord, theFileName, thePosition);
	}
	
	private void insert(BinSearchTreeNode r, String theWord, String theFile, int thePosition) {
		if (r==null) {
			r = new BinSearchTreeNode(theWord, theFile, thePosition);
			root = r;
		}
		else if (theWord.compareTo(r.getWord())<0) {
			if (r.getLeft()==null) {
				BinSearchTreeNode left = new BinSearchTreeNode(theWord, theFile, thePosition);
				r.setLeft(left);
			}
			else insert(r.getLeft(), theWord, theFile, thePosition);
		}
		else if (r.getRight()==null) {
				BinSearchTreeNode right = new BinSearchTreeNode(theWord, theFile, thePosition);
				r.setRight(right);
			}
		else insert(r.getRight(), theWord, theFile, thePosition);
	}
}
