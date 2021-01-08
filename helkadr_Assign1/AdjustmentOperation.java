import java.awt.Color;
import java.lang.Math;
/*
 * Class made by Hadi El-Kadri
 * Class AdjustmentOperation implements ImageOperation to change the brightness of a pixel from dark to light depending on its distance from
 * the top left corner of a desired image (like a gradient)
 */
public class AdjustmentOperation implements ImageOperation {

	//Array of pixel colours made using the doOperation
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;
		
		//The maximum distance from any pixel to the top left of the image is a constant calculated via this equation
		final double MAX_D = Math.sqrt(Math.pow(numOfColumns, 2) + Math.pow(numOfRows, 2));
		
		//Initializing variables
		double distance;
		double adjustBrightness;
		
		Color[][] result = new Color[numOfRows][numOfColumns];
		
		//going through the array of pixels and their colours, calculating their distance from the upper left corner, dividing by the max
		//Once the adjustment of the brightness is calculated, the result is each color multiplied by the adjustment
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				distance = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
				adjustBrightness = distance/MAX_D;
				result[i][j] = new Color((int)(imageArray[i][j].getRed() * adjustBrightness),(int)(imageArray[i][j].getGreen() * adjustBrightness), (int)(imageArray[i][j].getBlue() * adjustBrightness));
			}
		}
		return result;
	}
}
