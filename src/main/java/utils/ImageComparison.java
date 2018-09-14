package utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

public class ImageComparison {
	public static boolean compareImage(File fileA, File fileB) { 
		try {
		// take buffer data from botm image files //
		BufferedImage biA = ImageIO.read(fileA);
		DataBuffer dbA = biA.getData().getDataBuffer();
		int sizeA = dbA.getSize(); 
		BufferedImage biB = ImageIO.read(fileB);
		DataBuffer dbB = biB.getData().getDataBuffer();
		int sizeB = dbB.getSize();
		// compare data-buffer objects //
		if(sizeA == sizeB) {
		for(int i=0; i<sizeA; i++) { 
		if(dbA.getElem(i) != dbB.getElem(i)) {
		return false;
		}
		}
		return true;
		}
		else {
		return false;
		}
		} 
		catch (Exception e) { 
		System.out.println("Failed to compare image files ...");
		return false;
		}
		}
	@Test
	public void testImage()
	{
		System.err.println(compareImage(new File("https://s3.amazonaws.com/files.tvisha/mr-miss/data/attachments/A1bNysJ7Y5_1536671570_1536671570.jpg"),new File("https://s3.amazonaws.com/files.tvisha/mr-miss/data/attachments/A1bNysJ7Y5_1536671570_1536671570.jpg")));
	}
}
