/* Damian Bhatia and Aleksandar Stojanovic
 * Title Screen Class
 * This class provides components for the title screen
 * 2019-05-31
 */
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

//Title Screen on launch
public class TitleScreen extends JPanel {
  
  //Image variables
  ImageLoader imageLoader;
  BufferedImage background;
  BufferedImage background2;
  BufferedImage background3;
  BufferedImage background4;
  BufferedImage title;
  int screen = 1;
 //constructor 
  public TitleScreen() {
    setPreferredSize(new Dimension(640, 480));
    setLayout(null);
    
    init();
  }
  
  //Loads everything in
  public void init() {
      imageLoader = new ImageLoader();
      background = imageLoader.loadImage("assets/titleBackground.jpg");
      background2 = imageLoader.loadImage("assets/titleBackground2.jpg");
      background3 = imageLoader.loadImage("assets/titleBackground3.jpg");
      background4= imageLoader.loadImage("assets/titleBackground4.jpg");
      title = imageLoader.loadImage("assets/titleWords.png");
      repaint();
  }
  
  //Draws the menu screen
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(getScreen(screen), 0, 0, null);
    g.drawImage(title, 65, 50, null);
  }
  
  //returns background that will be displayed
  public BufferedImage getScreen(int background){
    if (background == 1){
      return this.background;
    }
    else if (background == 2){
      return this.background2;
    }
    else if (background == 3) {
      return this.background3;
    }
    else{
     return this.background4;
    }
  }
  
  //sets which bakcground will be displayed
  public void setScreen (int screen){
   this.screen = screen;
  }
  

}