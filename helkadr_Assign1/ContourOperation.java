import java.awt.Color;
import java.lang.Math;

/*
 * 
 * Class by Hadi El-Kadri
 * Class ContourOperation goes through every variation through each pixel of the image to calculate the pixels color distance to its neighbour's 
 * determining whether or not the pixel changes to black or white
 */
public class ContourOperation implements ImageOperation {
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;
		Color[][] p1 = new Color[numOfRows][numOfColumns];

		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				//Initialize variables and create a boolean to keep track of altered pixels so that they do not change once altered
				int calculateDistance;
				boolean isBlack = false;

				//Calculating the distance from the original pixel to it's neighboring one at i-1 and j
				if (i - 1 > 0 && j > 0) {
					calculateDistance = (int) Math
							.sqrt(Math.pow(imageArray[i][j].getRed() - imageArray[i - 1][j].getRed(), 2)
									+ Math.pow(imageArray[i][j].getGreen() - imageArray[i - 1][j].getGreen(), 2)
									+ Math.pow(imageArray[i][j].getBlue() - imageArray[i - 1][j].getBlue(), 2));
					//checking to see if the distance is greater than 65 which will change the value of the boolean
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}
				
				//Calculating the distance from the original pixel to it's neighboring one at i-1 and j + 1
				if (i - 1 > 0 && j + 1 < numOfColumns) {
					calculateDistance = (int) Math
							.sqrt(Math.pow(imageArray[i][j].getRed() - imageArray[i - 1][j + 1].getRed(), 2)
									+ Math.pow(imageArray[i][j].getGreen() - imageArray[i - 1][j + 1].getGreen(), 2)
									+ Math.pow(imageArray[i][j].getBlue() - imageArray[i - 1][j + 1].getBlue(), 2));
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}

				//Calculating the distance from the original pixel to it's neighboring one at i-1 and j-1
				if (i - 1 > 0 && j - 1 > 0) {
					calculateDistance = (int) Math
							.sqrt((Math.pow(imageArray[i][j].getRed() - imageArray[i - 1][j - 1].getRed(), 2)
									+ Math.pow(imageArray[i][j].getGreen() - imageArray[i - 1][j - 1].getGreen(), 2)
									+ Math.pow(imageArray[i][j].getBlue() - imageArray[i - 1][j - 1].getBlue(), 2)));
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}

				//Calculating the distance from the original pixel to it's neighboring one at i and j - 1
				if (i > 0 && j - 1 > 0) {
					calculateDistance = (int) Math
							.sqrt(Math.pow(imageArray[i][j].getRed() - imageArray[i][j - 1].getRed(), 2)
									+ Math.pow(imageArray[i][j].getGreen() - imageArray[i][j - 1].getGreen(), 2)
									+ Math.pow(imageArray[i][j].getBlue() - imageArray[i][j - 1].getBlue(), 2));
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}

				//Calculating the distance from the original pixel to it's neighboring one at i and j + 1 
				if (i > 0 && j + 1 < numOfColumns) {
					calculateDistance = (int) Math
							.sqrt(Math.pow(imageArray[i][j].getRed() - imageArray[i][j + 1].getRed(), 2)
									+ Math.pow(imageArray[i][j].getGreen() - imageArray[i][j + 1].getGreen(), 2)
									+ Math.pow(imageArray[i][j].getBlue() - imageArray[i][j + 1].getBlue(), 2));
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}

				//Calculating the distance from the original pixel to it's neighboring one at i+1 and j-1
				if (i + 1 < numOfRows && j - 1 > 0) {
					calculateDistance = (int) Math
							.sqrt(Math.pow(imageArray[i][j].getRed() - imageArray[i + 1][j - 1].getRed(), 2)
									+ Math.pow(imageArray[i][j].getGreen() - imageArray[i + 1][j - 1].getGreen(), 2)
									+ Math.pow(imageArray[i][j].getBlue() - imageArray[i + 1][j - 1].getBlue(), 2));
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}

				//Calculating the distance from the original pixel to it's neighboring one at i+1 and j
				if (i + 1 < numOfRows && j > 0) {
					calculateDistance = (int) Math
							.sqrt(Math.pow(imageArray[i][j].getRed() - imageArray[i + 1][j].getRed(), 2)
									+ Math.pow(imageArray[i][j].getGreen() - imageArray[i + 1][j].getGreen(), 2)
									+ Math.pow(imageArray[i][j].getBlue() - imageArray[i + 1][j].getBlue(), 2));
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}

				//Calculating the distance from the original pixel to it's neighboring one at i+1 and j+1
				if (i + 1 < numOfRows && j + 1 < numOfColumns) {
					calculateDistance = (int) (Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i + 1][j + 1].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i + 1][j + 1].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i + 1][j + 1].getBlue()), 2)));
					if (calculateDistance > 65) {
						isBlack = true;
					}
				}

				if (isBlack == true) {
					p1[i][j] = new Color(0, 0, 0);
				} else {
					p1[i][j] = new Color(255, 255, 255);
				}
			}
		}
		return p1;
	}
}