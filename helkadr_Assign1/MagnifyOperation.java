import java.awt.Color;
/*
 * 
 * Class by Hadi El-Kadri
 * Class MagnifyOperation implements ImageOperation to go through every pixel of a desired image and magnify it
 * 
 * 
 **/
public class MagnifyOperation implements ImageOperation{
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		//Creates an array that is double the size of the original one
		Color[][] result = new Color[numOfRows*2][numOfColumns*2];

		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				
				//every pixel will take up 3 spots around it (total 4 pixels) and the color of the original pixel will fill the new spots
				//this results in pixels having to shift over double their original positions 
				result [i * 2][j * 2] = imageArray[i][j];
				result [i * 2][(j * 2) +1] = new Color(imageArray[i][j].getRed(),imageArray[i][j].getGreen(),imageArray[i][j].getBlue());
				result [(i * 2) + 1][j * 2] = new Color(imageArray[i][j].getRed(),imageArray[i][j].getGreen(),imageArray[i][j].getBlue());
				result [(i * 2) + 1][(j * 2) +1] = new Color(imageArray[i][j].getRed(),imageArray[i][j].getGreen(),imageArray[i][j].getBlue());
			}
			
		}
		return result;
	}
}