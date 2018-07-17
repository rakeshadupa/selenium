package sikuli;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.sikuli.script.Finder;
import org.sikuli.script.Pattern;
import org.testng.annotations.Test;

public class SikuliUtils {

	public void compareImageInSikuli(String actualImagePath, String expectedImagePath) throws IOException {

		Finder findr = new Finder(actualImagePath);

		Pattern p = new Pattern(expectedImagePath);
		findr.find(p);
		if (findr.hasNext()) {

			findr.next();
			System.out.println("Matching");
		} else {
			System.out.println("Not matching");
		}

	}

	@Test
	public void pictureTest() {
	
	}

	/// home/rakesh/Pictures/troopM_ticks/read.png

	public static boolean compareImage(String image1, String image2) {
		try {
			File fileA = new File(image1);
			File fileB = new File(image2);

			// take buffer data from botm image files //
			BufferedImage biA = ImageIO.read(fileA);
			DataBuffer dbA = biA.getData().getDataBuffer();
			int sizeA = dbA.getSize();
			BufferedImage biB = ImageIO.read(fileB);
			DataBuffer dbB = biB.getData().getDataBuffer();
			int sizeB = dbB.getSize();
			// compare data-buffer objects //
			if (sizeA == sizeB) {
				// System.out.println("size A"+sizeA);
				// System.out.println("size B"+sizeB);
				for (int i = 0; i < sizeA; i++) {
					if (dbA.getElem(i) != dbB.getElem(i)) {
						System.err.println(false);
						return false;

					}
				}
				System.err.println(true);
				return true;
			} else {
				System.err.println(false);
				return false;
			}
		} catch (Exception e) {
			System.err.println("Failed to compare image files ...");
			return false;
		}
	}

}
