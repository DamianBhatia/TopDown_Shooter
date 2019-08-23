/* Damian Bhatia and Aleksandar Stojanovic
 * image loader Class
 * This class loads images 
 * 2019-05-31
 */
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

//Used to preload image files
public class ImageLoader {
  
  BufferedImage img;
  
  //Getter for the image
  public BufferedImage getImage() {
    return this.img; 
  }
  
  //Try to read and load an image
  public BufferedImage loadImage(String filename) {
     try {
      img = ImageIO.read(new File(filename));
      return img;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
  
}
