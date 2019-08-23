/* Damian Bhatia and Aleksandar Stojanovic
 * Instruction Screen Class
 * This class provides componets for the instruction screen
 * 2019-05-31
 */
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

//Title Screen on launch
public class InScreen extends JPanel {
  
  //Image variables
  ImageLoader imageLoader;
  BufferedImage background;
  BufferedImage title;

  public InScreen() {
    setPreferredSize(new Dimension(640, 480));
    setLayout(null);
    
    init();
  }
  
  //Loads everything in
  public void init() {
      imageLoader = new ImageLoader();
      background = imageLoader.loadImage("assets/InScreen.png");
      repaint();
  }
  
  //Draws the menu screen
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, null);
    g.drawImage(title, 65, 50, null);
  }


}