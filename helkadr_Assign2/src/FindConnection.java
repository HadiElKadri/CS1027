/**
 * @author Hadi El-Kadri
 * This class examines a map and finds if there is a path for electricity
 * to get from the power company to a customers house
 */


import java.io.FileNotFoundException;
import java.io.IOException;

public class FindConnection {
	
/**
 * "cityMap" is a Map object created when a map file is given
 */
	Map cityMap;
	
	/**
	 * 
	 * A FindConnection object is constructed from the constructor 
	 * @param filename is the name of the desired map file
	 * @throws InvalidMapException for invalid map file
	 * @throws FileNotFoundException for a not found map file
	 * @throws IOException for an invalid input
	 */
	
	public FindConnection(String filename) throws InvalidMapException, FileNotFoundException, IOException {
		this.cityMap = new Map(filename);
	}
		
	public static void main(String[] args) throws InvalidMapException, FileNotFoundException, IOException {
		//exit program if there is any error with the file provided
		if(args.length < 1) {
			System.out.println("You must provide the name of the input file");
			System.exit(0);
		   }
		
		//variables are initialized 
		String mapFileName = args[0];
		FindConnection input = new FindConnection(mapFileName);
		int counter= 0;
		ArrayStack<MapCell> bestPath = new ArrayStack<MapCell>();
		
		//the start cell is initialized
		MapCell crntCell = input.cityMap.getStart();
		bestPath.push(crntCell);
		crntCell.markInStack();
		
		
		//run through this loop as long as the customer has not been found and the stack is not empty
		do {
			
			//if a proper cell exists, push it into the stack and count the step of the path
			if (input.bestCell(crntCell) != null) {
				crntCell.markInStack();
				bestPath.push(input.bestCell(crntCell));
				//counter = counter + 1;
			}
			
			//if the cell has no where to go, retrace the steps, take away the count, and pop the wrong path cells from the stack
			else{
				bestPath.pop().markOutStack();
				//counter = counter - 1;
			}
			
			//if the stack is empty throw an exception
			try {
				crntCell = bestPath.peek();
				}
				catch(EmptyStackException e) {
				}
		}
		
		while (!crntCell.isCustomer() && !bestPath.isEmpty());
		
		//if there is no clear path, print that there is no path
		if (bestPath.isEmpty()) {
			crntCell.markCustomer();
			System.out.println("There was no path found to the customer's house.");
			System.out.println("The power is unable to reach the customer!");
			}
		
		//if path has been found, print how many cells to get to the customer and that power has reached
		
			else {
				System.out.println("The amount of cells taken to the customer's house: " + (bestPath.size()-1));
				System.out.println("The power has reached the customer!");
			}	
	}
	
	
	/**
	 * This method determines the best cells providing the best path to the customers house (if there is a path)
	 * @param cell the current map cell that determines which neighbour the cell should move to
	 * @return the prioritized cell that must be added to the stack
	 */
	private MapCell bestCell(MapCell cell) {
		MapCell bestCell = null;
		
		for (int i=0;i<=3;i++) {
			
			try {
				
				//the power station is the first preferred cell, then omni, then vertical or horizontal
				if (cell.isPowerStation()) {
					
					if (cell.getNeighbour(i).isCustomer()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isOmniSwitch() && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isHorizontalSwitch() && (i==1||i==3) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isVerticalSwitch()&&(i==0||i==2) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
				}
				
				else if (cell.isOmniSwitch()) {
				
					if (cell.getNeighbour(i).isCustomer()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isOmniSwitch() && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isHorizontalSwitch() && (i==1||i==3) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isVerticalSwitch()&&(i==0||i==2) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
				}
				
				//if the cell is horizontal switch, make sure the neighbours are valid and move to those cells
				else if (cell.isHorizontalSwitch()) {
					if (cell.getNeighbour(i).isCustomer() && (i==1||i==3)) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isOmniSwitch() && (i==1||i==3) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isHorizontalSwitch() && (i==1||i==3) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
				}
				
				
				//if the cell is vertical switch, make sure the neighbours are valid and move to those cells
				else if (cell.isVerticalSwitch()) {
					if (cell.getNeighbour(i).isCustomer() && (i==0||i==2)) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isOmniSwitch() && (i==0||i==2) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
					else if (cell.getNeighbour(i).isVerticalSwitch()&&(i==0||i==2) && !cell.getNeighbour(i).isMarked()) {
						bestCell = cell.getNeighbour(i);
					}
				}
			}
			//out of the map cells that do not exist are caught in this exception
			catch (NullPointerException e) {
				System.out.println("");
			}
		}
		// the next best cell is returned
		return bestCell;
	}
}