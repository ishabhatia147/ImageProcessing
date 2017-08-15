import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ImageProcessing {
	public File image1 = new File("C:\\Users\\HP\\Pictures\\Rectangle1.jpg");
	public File image2 = new File("C:\\Users\\HP\\Pictures\\Rectangle3.jpg");

	public int findTotalBytes() {
		int totalBytes = 0;
		try {
			FileInputStream file1 = new FileInputStream(getImage1());
			FileInputStream file2 = new FileInputStream(getImage2());
			totalBytes = Math.max(file1.available(), file2.available());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalBytes;
	}

	public File getImage1() {
		return image1;
	}

	public File getImage2() {
		return image2;
	}

	public void byteWiseMatching(File image1, File image2) {
		int matchedBytes = 0;
		int totalBytes;
		int unmatchedBytes = 0;
		try {
			FileInputStream file1 = new FileInputStream(getImage1());
			FileInputStream file2 = new FileInputStream(getImage2());

			totalBytes = findTotalBytes();
			System.out.println("Image1--->" + file1.available());
			System.out.println("Image2--->" + file2.available());
			System.out.println(totalBytes);
			while (totalBytes > 0) {
				// System.out.println(matchedBytes);
				if (file1.read() == file2.read()) {
					matchedBytes++;
					// System.out.println("MAtched bytes----> "+matchedBytes);
				} else {
					unmatchedBytes++;
				}
				totalBytes--;
			}

			System.out.println("Matched---->    " + matchedBytes + "  Unmatched---->  " + unmatchedBytes);
			totalBytes = findTotalBytes();
			System.out.println(totalBytes);
			double matchedPercentage = ((double) matchedBytes / (double) totalBytes) * 100;
			System.out.println(
					"Images match percentage when doing byte by byte comparison--->   " + matchedPercentage + "%");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pixelWiseMatching(File image1, File image2) {

		int matchedPixels=0;
		int unmatchedPixels=0;
		long totalPixels=0;
		long difference=0;
		try {
			BufferedImage img1=ImageIO.read(getImage1());
			BufferedImage img2=ImageIO.read(getImage2());
			
			int type=img2.getType();
			int height=img1.getHeight();
			int width=img1.getWidth();
			BufferedImage img3=new BufferedImage(width, height, type);
			img3.getGraphics().drawImage(img2, 0, 0, null);
			System.out.println(img3.getHeight());
			//img2.getScaledInstance(width, height,Image.SCALE_DEFAULT));
			//img1=Scal;
			//Image scaledImg1= img1.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			if(img1.getHeight()==img3.getHeight()&&img1.getWidth()==img3.getWidth())
			{
				System.out.println("Scaled");
			}
			//Image finalImage1=ImageIO.read(scaledImg1);
			totalPixels=height*width;
			
			System.out.println("Width--->"+img3.getWidth()+"Height--->"+img3.getHeight()+"Total--->"+totalPixels);
			for(int i=0;i<width;i++)
			{
				for(int j=0;j<height;j++)
				{
					Color c1=new Color(img3.getRGB(i, j));
					Color c2=new Color(img1.getRGB(i, j));
					//System.out.println(Math.abs());
					difference=difference+Math.abs((c1.getRed()-c2.getRed()));
					difference=difference+Math.abs((c1.getGreen()-c2.getGreen()));
					difference=difference+Math.abs((c1.getBlue()-c2.getBlue()));
				//	System.out.println("Difference---->"+difference);
					//if(c1.getColorSpace()==c2.getColorSpace())
					
					
						
						//matchedPixels++;
					
//					else
//					{	//System.out.println(img1.getRGB(i, j));
//					unmatchedPixels++;}
				}
			}
			totalPixels=totalPixels*3*255;
			
			System.out.println("Difference---->    " + difference + "  Unmatched---->  " + unmatchedPixels);
			double matchedPercentage = (((double)(totalPixels- difference)) / ((double) (totalPixels))) * 100;
			System.out.println(
					"Images match percentage when doing Pixel by pixel comparison--->   " + matchedPercentage + "%");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rasterScanMatching(File image1, File image2)
}
