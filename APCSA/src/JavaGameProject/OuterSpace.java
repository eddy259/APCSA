//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package JavaGameProject;
import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.util.concurrent.TimeUnit.*;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;

	//private ArrayList<Alien> aliens;
	private EnemySquares aliens;
	

	private boolean[] keys;
	private BufferedImage back;
	
	private int shootcount;
	private int lives;
	private int count;
	private int stage;

	public OuterSpace()
	{
		//final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		int stage = 0;
		setBackground(Color.black);
		count = 0;
		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(399,399,1);
	
		aliens = new EnemySquares();
		
		shootcount = 0;
		lives = 5;
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("DODGER ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("LIVES: "+ lives, 50, 50);
		graphToBack.setColor(Color.BLACK);

		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true){
			ship.move("RIGHT");
		}
		if(keys[2] == true){
			ship.move("UP");
		}
		if(keys[3] == true){
			ship.move("DOWN");
		}
		
		if(ship.getX() > 781){
			ship.setX(781);
		}
		if(ship.getX() < 0){
			ship.setX(0);
		}
		if(ship.getY() > 559){
			ship.setY(559);
		}
		
		
		
		//add code to move stuff


		//add in collision detection
		
		
		
		
		
		if(count > 1){
			aliens.add(new EnemySquare((int)(Math.random() * 800),0,1));
			count = 0;
		}
		else{
			count++;
		}
		
		for(int i = 0;i < aliens.getSize();i++){
					
				aliens.alienAt(i).draw(graphToBack);
			
				aliens.alienAt(i).move("DOWN");
					
				
				
					
//					try        
//					{
//					    Thread.sleep(1000);
//					} 
//					catch(InterruptedException ex) 
//					{
//					    Thread.currentThread().interrupt();
//					}
				
				if(ship.hitEnemy(aliens.alienAt(i))){
					aliens.delete(i);
					lives--;
				}
					
				if(aliens.alienAt(i).getY() > 600) {
					aliens.delete(i);
				}
					
					
					
				
		}
		
		
		
	
		
		
		
		ship.draw(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;

		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

