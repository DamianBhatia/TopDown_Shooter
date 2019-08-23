/* Damian Bhatia and Aleksandar Stojanovic
 * Camrea Class
 * This class is used to follow the player with a camera
 * 2019-05-31
 */

//This camera follows the player and allows us to explore entire map
public class Camera {
  
  private float x, y;
  
  //Constructor
  public Camera(float x, float y) {
    this.x = x;
    this.y = y;
  }
  
  //Update current position of the camera
  public void update(Player player) {
    
    x += ((player.getX() - x) - 1600/2) * 0.05f;
    y += ((player.getY() - y) - 480/2) * 0.05f;
    
    //Clamp to screen
    if(x <= -490) x = -490;
    if(x >= 490) x = 490;
    if(y <= 0) y = 0;
    if(y >= 520) y = 520;    
  }
  
  //Getters and Setters
  public float getX() {
    return this.x;
  }
  
  public float getY() {
    return this.y;
  }
  
  public void setX(float x) {
    this.x = x;
  }
  
  public void setY(float y) {
    this.y = y;
  }
  
  
}