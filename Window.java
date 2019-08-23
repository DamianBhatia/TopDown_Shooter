/* Damian Bhatia and Aleksandar Stojanovic
 * Window Class
 * This class provides the main method where the window is shown 
 * and the main game can be played. It Also contains buttons and each button has its own function
 * 2019-05-31
 */
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

//The frame itself
public class Window extends JFrame {
  
  public static Window window;
  
  //Constants for dimensions of frame
  public final int WIDTH, HEIGHT;
  
  private boolean isPlaying;
  //JComponents
  private JButton playButton;
  private JButton inButton;
  private JButton playButton2;
  private JButton quitButton;
  private JButton backButton;
  private Game game;
  private TitleScreen titleScreen;
  private static GameCanvas gameCanvas; 
  private InScreen instructionScreen;
  public int a;
  //Constructor
  public Window(String title, int width, int height, Game game, TitleScreen titleScreen,InScreen instructionScreen) {
    
    //Initialize dimensions
    this.WIDTH = width;
    this.HEIGHT = height;
    this.game = game;
    this.titleScreen = titleScreen;
    this.gameCanvas = new GameCanvas(this);
    this.instructionScreen = instructionScreen;
    this.a = 1;
    //Prepare Frame
    setTitle(title);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setMaximumSize(new Dimension(WIDTH, HEIGHT));
    setMinimumSize(new Dimension(WIDTH, HEIGHT));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    
    //Add actionlistener to button
    playButton = new JButton("PLAY");
    inButton = new JButton("Instructions");
    playButton2 = new JButton("PLAY");
    quitButton = new JButton("QUIT");
    backButton = new JButton("background");
    
    playButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //Switches the JPanel shown and adds gameCanvas to panel
        remove(titleScreen);
        game.add(gameCanvas);
        add(game);
        getContentPane().revalidate();
        repaint();
        gameCanvas.startMainThread();
      }
    });
    // button that is added to the instructions screen. Does same fucntions as playButton  
    playButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        //Switches the JPanel shown and adds gameCanvas to panel
        remove(instructionScreen);
        game.add(gameCanvas);
        add(game);
        getContentPane().revalidate();
        repaint();
        gameCanvas.startMainThread();
      }
    });
    //This button is used to display instruction screen
    inButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //Removes titlescreen and adds instructionScreen
        remove(titleScreen);
        add(instructionScreen);
        getContentPane().revalidate();
        repaint();
        
      }
    });
    //quit button
    quitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //sets visible to false
        setVisible(false);
      }
    });
    
    //changes background of title screen once pressed
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //Switches the JPanel shown and adds gameCanvas to panel
        if (a<4){ // rotates between the 4 images
        a = a+1;
        }
        else {
         a = 1;
        }
        titleScreen.setScreen(a); //sets the image
        getContentPane().revalidate();
        repaint();
      }
    });
    
    //Add button to panel and set its position
    titleScreen.add(playButton);
    titleScreen.add(inButton);
    instructionScreen.add(playButton2);
    titleScreen.add(quitButton);
    titleScreen.add(backButton);
    playButton.setBounds((WIDTH/2)-55, HEIGHT/2 - 50, 105, 30);
    inButton.setBounds((WIDTH/2)-55, HEIGHT/2, 105, 30);
    quitButton.setBounds((WIDTH/2)-55, HEIGHT/2 + 100, 105, 30);
    backButton.setBounds((WIDTH/2)-55, HEIGHT/2 + 50, 105, 30);
    playButton2.setBounds((WIDTH/2)-55, HEIGHT/2 + 130, 105, 30);
    //Set current view to the titleScreen
    add(titleScreen);   
    setVisible(true);
    
  }
  
  
  //Getters and Setters
  public int getWidth() {
    return this.WIDTH;
  }
  
  public int getHeight() {
    return this.HEIGHT;
  }
  
  //Create Window
  public static void main(String[] args) {
    window = new Window("Shoot Till You Drop", 640, 480, new Game(), new TitleScreen(),new InScreen());
  }
  
}