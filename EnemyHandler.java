/* Damian Bhatia and Aleksandar Stojanovic
 * enemy handler Class
 * This class allows us to handle the enemy objects using a linklist
 * 2019-05-31
 */

import java.util.LinkedList;

public class EnemyHandler {

  public LinkedList<Enemy> enemies;
  
  public EnemyHandler() {
    enemies = new LinkedList<Enemy>();
  }
  
  public void addEnemy(Enemy enemy) {
    enemies.add(enemy);
  }
  
  public void removeEnemy(Enemy enemy) {
    enemies.remove(enemy);
  }

}