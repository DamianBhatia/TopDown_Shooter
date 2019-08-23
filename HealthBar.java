/* Damian Bhatia and Aleksandar Stojanovic
 * health bar Class
 * This class provides componets for the health bar
 * 2019-05-31
 */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.image.BufferedImage;

//The healthbar for the player
public class HealthBar {
  
  private int health;
  private Player player;
  
  private int x, y;
  
  private Camera camera;
  
  private BufferedImage scoreImg;
  private ImageLoader loader;
  
  public HealthBar(Player player, int x, int y, Camera camera) {
    this.x = x;
    this.y = y;
    this.player = player;
    this.health = player.getHealth();
    this.camera = camera;
    
    init();
  }
  
  private void init() {
    loader = new ImageLoader();
    scoreImg = loader.loadImage("assets/score.png");
  }
  
  //Update position of the health bar and the value
  public void update() {
    this.x = (int)this.camera.getX() + 490;
    this.y = (int)this.camera.getY() + 5;
    this.health = this.player.getHealth();
    
    if(this.health <= 0) {
      this.player.setStatus(false);
    }
  }
  
  
  public void render(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(x, y, 100, 12);
    g.setColor(Color.GREEN);
    g.fillRect(x, y, this.health/10, 12);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, 100, 12);
    g.drawString(("HP: " + player.getHealth()/10 + "/100"), (int)camera.getX() + 492, (int)camera.getY() + 16);
    g.setColor(Color.WHITE);
    g.drawImage(scoreImg, (int)camera.getX() + 1000, (int)camera.getY() - 8, null);
    g.drawString(Integer.toString(player.getScore()), (int)camera.getX() + 1080, (int)camera.getY() + 16);
  } 
  
  
  public Rectangle getBorder() {
    return null;
  }
  
  
  
}