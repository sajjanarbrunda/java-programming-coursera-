
import edu.duke.*;
import java.io.*;
/**
 * Write a description of InvertImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvertImage {
    public ImageResource makeInversion(ImageResource inImage){
     ImageResource outImage = new ImageResource(inImage);
    for(Pixel pixel : outImage.pixels()){
       Pixel inPixel = inImage.getPixel(pixel.getX() , pixel.getY());
        
	//int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;

	//set pixel's red to average
	pixel.setRed(0);

	//set pixel's green to average
	pixel.setBlue(0);

	//set pixel's blue to average
	pixel.setGreen(255 -(inPixel.getGreen()));

                   }
  //outImage is your answer
     return outImage;
	}
	 public void doSave(){
    DirectoryResource  dr = new  DirectoryResource();
      for(File f : dr.selectedFiles()){
       ImageResource image = new ImageResource(f);
        ImageResource Inversion = makeInversion(image);
       String fname = image.getFileName();
       String newName = "Inversion_" + fname;
       Inversion.setFileName(newName);
       Inversion.save();
    }
}
//public void testGray() {
   //ImageResource ir = new ImageResource();
  //  ImageResource gray = makeGray(ir);
  //  gray.draw();
//}
  public void selectAndConvert(){
    DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
	    ImageResource inImage = new ImageResource(f);
	    ImageResource Inversion = makeInversion(inImage);
	    Inversion.draw();
    }
    
    }

}
