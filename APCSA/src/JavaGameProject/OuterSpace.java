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
	private StartScreen Start;
	private Ship ship;
	

	//private ArrayList<Alien> aliens;
	private EnemySquares aliens;
	private CheckPoint cpoint1;
	private CheckPoint cpoint2;
	private CheckPoint cpoint3;

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
		Start = new StartScreen();
		setBackground(Color.black);
		count = 0;
		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(-1000,-1000,1);
		cpoint1 = new CheckPoint(-1000,-1000,0);
		cpoint2 = new CheckPoint(-1000,-1000,0);
		cpoint3 = new CheckPoint(-1000,-1000,0);
	
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
		
		if(stage == 0){
			Start.draw(graphToBack);
			if(keys[4] == true){
				stage = 1;
				ship.setPos(399, 500);
				cpoint1.setPos(600,100);
				cpoint2.setPos(500,400);
				cpoint3.setPos(50,250);
				
			}
		}

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
		
		if(ship.hitCheckPoint(cpoint1)){
			cpoint1.setChecked(true);
		}
		if(ship.hitCheckPoint(cpoint2)){
			cpoint2.setChecked(true);
		}
		if(ship.hitCheckPoint(cpoint3)){
			cpoint3.setChecked(true);
		}
		
		if(cpoint1.getChecked() == true){
			cpoint1.setImage("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\JavaGameProject\\cyansquare.png");
		}
		if(cpoint2.getChecked() == true){
			cpoint2.setImage("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\JavaGameProject\\cyansquare.png");
		}
		if(cpoint3.getChecked() == true){
			cpoint3.setImage("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\JavaGameProject\\cyansquare.png");
		}
		
		cpoint1.draw(graphToBack);
		cpoint2.draw(graphToBack);
		cpoint3.draw(graphToBack);
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

