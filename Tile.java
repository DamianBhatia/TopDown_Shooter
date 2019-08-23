/* Damian Bhatia and Aleksandar Stojanovic
 * Tile Class
 * This class provides components of a tile
 * 2019-05-31
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

//Different types of blocks
public class Tile {

  //class variables
  private BufferedImage img;
  private String type;
  private int x, y;
  //constructor
  public Tile(int x, int y, BufferedImage img, String type) {
    this.x = x;
    this.y = y;
    this.img = img;
    this.type = type;
  }
  //renders images
  public void render(Graphics g) {
    g.drawImage(this.img, this.x, this.y, null);
  }
  
  //Getter 
  public String getType() {
    return this.type;
  }
  
}