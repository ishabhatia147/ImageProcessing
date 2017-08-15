import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ImageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageProcessing img=new ImageProcessing();
		//File f=new File("C:\\Users\\HP\\Pictures\\Image3.jpg");
	
		try {
//			//FileOutputStream fileOut=new FileOutputStream(f);
//			//FileInputStream fileIn=new FileInputStream("C:\\Users\\HP\\Pictures\\Image2.jpg");
//			
//			Image image1=ImageIO.read(img.image1);
//			image1.
//			
//			//System.out.println(fileIn.read());
//			while(fileIn.available()>0)
//			{
//				//System.out.println(fileIn.read());
//				System.out.println(fileIn.available());
//			fileOut.write(fileIn.read());
//			}
			System.out.println(img.getImage1().toString());
			img.byteWiseMatching(img.image1, img.image2);
			img.pixelWiseMatching(img.image1, img.image2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
