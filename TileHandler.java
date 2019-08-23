/* Damian Bhatia and Aleksandar Stojanovic
 * Tile Handler Class
 * This class Allows us to handle the tile in the game using a link list.
 * 2019-05-31
 */

import java.util.LinkedList;

public class TileHandler {

  public LinkedList<Tile> tiles;
  
  public TileHandler() {
    tiles = new LinkedList<Tile>(); // creates link list in constructor
  }
  
  //adds a tile from link list
  public void addTile(Tile tile) {
    tiles.add(tile);
  }
  
  //removes a tile from link list
  public void removeTile(Tile tile) {
    tiles.remove(tile);
  }

}