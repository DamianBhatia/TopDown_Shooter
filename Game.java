/* Damian Bhatia and Aleksandar Stojanovic
 * game Class
 * This class is the container for the game.
 * The game instense is called in the window. 
 * 2019-05-31
 */

import javax.swing.JPanel;
import java.awt.Dimension;

//Container panel that holds the game canvas
//Useful for the adding of buttons, components, and possible mouse listener
public class Game extends JPanel {
  
  //Creates the JPanel and sets the size of the container
  public Game() {
    this.setPreferredSize(new Dimension(1600, 960));
    this.setMaximumSize(new Dimension(1600, 960));
    this.setMinimumSize(new Dimension(1600, 960));
  }
 
}