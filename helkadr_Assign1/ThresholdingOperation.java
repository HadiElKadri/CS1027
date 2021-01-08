import java.awt.Color;
/*
 * Class by Hadi-Elkadri
 * Class ThresholdingOperation implements ImageOperation and from an array of pixel colors created  by the doOperation
 * the brightness score of each pixel is calculated and if over or under 100, its color will be changed to black or white accordingly
 */
public class ThresholdingOperation implements ImageOperation {
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		Color[][] result = new Color[numOfRows][numOfColumns];

		//The brightness score of each pixel is calculated based on the amounts of RGB
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				int red = (int) (0.21 * imageArray[i][j].getRed());
				int green = (int) (0.71 * imageArray[i][j].getGreen());
				int blue = (int) (0.07 * imageArray[i][j].getBlue());
				int brightness = red + green + blue;
				
				//Changing pixels to black or white depending on if the brightness score is less or greater than 100
				//if less than 100, black
				if (brightness < 100) {
					result[i][j] = new Color(000,000,000);
				}
				
				//if not, white
				else {
					result[i][j] = new Color(255,255,255);
				}
			}
		return result;
}
	}
