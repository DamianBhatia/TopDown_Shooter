/* Damian Bhatia and Aleksandar Stojanovic
 * bullet controller  Class
 * This class allows us to handle the bullet objects using a arraylist
 * 2019-05-31
 */


import java.util.ArrayList;

// creates an array of bullets 
public class BulletController {
  
  private int count;
  private ArrayList<Bullet> bulletList;
  
  public BulletController() { 
    bulletList = new ArrayList<Bullet>();
    count = -1;
  }
  // adds bullet to array
  public void addBullet(Bullet bullet){
    bulletList.add(bullet);
    
  }
  //removes bullet from array
  public void removeBullet(Bullet bullet){
    bulletList.remove(bullet);
  
  }
  
  //retrieves the bullet
  public Bullet getBullet(int i){
    if (bulletList.size()!=0){
      return bulletList.get(i);  
    }
    else{
      return null;
    }
    
  }
  
  
  public int getSize(){
    return bulletList.size();
  }
}
