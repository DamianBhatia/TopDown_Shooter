/* Damian Bhatia and Aleksandar Stojanovic
 * bullet  Class
 * This class This class provides all compnents of a bullet object
 * 2019-05-31
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.*;
import java.awt.Rectangle; 

//Bullet that is being shot out by the player
public class Bullet {
  //Player Variables
  private int x,y;
  private int speedX,speedY;
  
  //adds a bullet controller
  private BulletController bController;
  
  private EnemyHandler enemyHandler;
  
  //count
  private int count;
  //Images
  private ImageLoader imageLoader;
  private BufferedImage img;
  
  private Player player;
  
  private GameCanvas game;
  
  //Constructor
  public Bullet(int x, int y,int speedX,int speedY,BulletController bController, EnemyHandler enemyHandler, Player player, GameCanvas game) { 
    this.x=x;
    this.y=y;
    this.speedX=speedX;
    this.speedY=speedY;
    this.bController = bController;
    this.enemyHandler = enemyHandler;
    this.player = player;
    this.game = game;
    count = 0;
    init();
  }
  //the contents of the bullet 
  public void init() {
    imageLoader = new ImageLoader();
    img = imageLoader.loadImage("assets/bulletTile.png");
  }
  //Update the bullet
  public void update() {
    count++;
    this.x+=this.speedX;
    this.y+=this.speedY;
    if (count == 50){
      bController.removeBullet(this);
    }
    //makes sure bullet doenst go off screen
    if(x <= 35){
      bController.removeBullet(this);
    }
    if(x >= 1555){
      bController.removeBullet(this);
    } 
    if(y <= 35){
      bController.removeBullet(this);
    } 
    if(y >= 900){
      bController.removeBullet(this);  
    }  
    checkCollision();
  }
  
  //Draw the bullet
  public void render(Graphics g) {
    g.drawImage(img, this.getX(), this.getY(), null);
  }

  public int getX() {
    return this.x;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public int getSpeedX() {
    return this.speedX;
  }
  
  public void setSpeedX(int speedX) {
    this.speedX = speedX;
  }
  
  public int getSpeedY() {
    return this.speedY;
  }
  
  public void setSpeedY(int speedY) {
    this.speedY = speedY;
  }
  
  public Rectangle getBounds() {
    return new Rectangle(x, y, 10, 10);
  }
  
  private void checkCollision() {
    for(int i = 0; i < this.enemyHandler.enemies.size(); i++) {
      if(this.getBounds().intersects(this.enemyHandler.enemies.get(i).getBounds())) {
        this.enemyHandler.removeEnemy(this.enemyHandler.enemies.get(i));
        this.game.setNumEnemies(this.game.getNumEnemies() - 1);
        this.bController.removeBullet(this);
        this.player.score += 5;
      }
    }
  }
  
}