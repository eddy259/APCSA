//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit17;
import java.awt.Color;
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

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;

	//private ArrayList<Alien> aliens;
	private Aliens aliens;
	private ArrayList<Ammo> shots;
	private ArrayList<Ammo> alienshots;
	private PowerUp pu;

	private boolean[] keys;
	private BufferedImage back;
	
	private int shootcount;
	private int score;
	private int alienshootcount;
	
	

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(399,399,2);
		shots = new ArrayList<Ammo>();
		alienshots = new ArrayList<Ammo>();
		aliens = new Aliens();
		alienOne = new Alien(20,80,3);
		alienTwo = new Alien(100,80,3);
		pu = new PowerUp(200,200);
		
		alienshootcount = 0;
		shootcount = 0;
		score = 0;
		
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
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("SCORE: "+ score, 50, 50);
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
		if(keys[4] == true){
			if(shootcount > 20){
				Ammo x = new Ammo(ship.getX() + 30, ship.getY() - 30, 4);
				x.move("UP");
				shots.add(x);
				keys[4] = false;
				shootcount = 0;
			}
			else{
				if(shootcount < 100)
					shootcount++;
			}
			
		}
		
		
		//add code to move stuff


		//add in collision detection
		
		if(shots.size() > 0){
			for(Ammo a : shots){
				if(a.getY() > 0){
					a.move("UP");
					a.draw(graphToBack);
					//shots.remove(a);
				}
				
				if(a.hitAlien(alienOne)){
					alienOne.setSpeed(0);
					alienOne.setPos(-100, -100);
					a = null;
					score++;
					
				}
				
				
			}
		}
		
		if(alienshots.size() > 0){
			for(Ammo a: alienshots){
				if(a.getY() < 1000){
					a.move("DOWN");
					a.draw(graphToBack);
				}
			}
		}
		
		if(ship.hitAlien(alienOne)){
			if(ship.getPUstatus() == true){
				ship.setImage("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\Unit17\\ship.jpg");
				ship.setPUstatus(false);
			}
			else{
				alienOne.setSpeed(0);
				alienOne.setPos(-100, -100);
				score--;
			}
			
			
		}
		
		
		
		if(alienOne != null){
			alienOne.draw(graphToBack);
			alienOne.move("RIGHT");
			if(alienOne.getX() < 0 || alienOne.getX() > 700){
				alienOne.setSpeed(-1*alienOne.getSpeed());
			}
		}
		
		
		for(int r = 0;r < 3;r++){
			for(int c = 0;c < 3;c++){
					
					aliens.alienAt(r, c).draw(graphToBack);
					aliens.alienAt(r, c).move("RIGHT");
					
					//aliens shooting
					if(alienshootcount > 500){
						Ammo a = new Ammo(aliens.alienAt(r, c).getX() + 30, aliens.alienAt(r, c).getY() + 30, 1);
						a.move("DOWN");
						alienshots.add(a);
						alienshootcount = 0;
					}
					else{
						if(alienshootcount < 1000){
							alienshootcount++;
						}
						
					}
					
					
					//shots hitting aliens
					if(shots.size() > 0){
						for(int i = 0;i < shots.size(); i++){
							if(shots.get(i).hitAlien(aliens.alienAt(r, c)) && shots.get(i) != null){
								aliens.delete(r,c);
								score++;
								//shots.set(i, null);
							}
						}
					}
					
					//ship hitting aliens
					if(ship.hitAlien(aliens.alienAt(r, c))){
						if(ship.getPUstatus() == true){
							ship.setImage("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\Unit17\\ship.jpg");
							ship.setPUstatus(false);
						}
						else{
							aliens.delete(r, c);
							score--;
						}
						
					}
					
					//aliens rebounding off of walls
					if(aliens.alienAt(r, c).getX() > 700 || aliens.alienAt(r, c).getX() < 0) {
						aliens.alienAt(r, c).setSpeed(-aliens.alienAt(r, c).getSpeed());
					}
					
					
					
				
			}
		}
		
		
		//shots hitting ship
		
		for(Ammo a : alienshots){
			
			if(a.hitShip(ship) && a.getHit() == false){
				if(ship.getPUstatus() == true){
					ship.setImage("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\Unit17\\ship.jpg");
					ship.setPUstatus(false);
					a.setHit(true);
				}
				else{
					score--;	
				}
				
				a.setHit(true);
			}
		}
		
		
		
		
//		alienTwo.draw(graphToBack);
//		
//		
//		alienTwo.move("LEFT");
//		
//		
//		
//		if(alienTwo.getX() < 0 || alienTwo.getX() > 700){
//			alienTwo.setSpeed(-1*alienTwo.getSpeed());
//		}
	
		
		if(ship.hitPowerUp(pu)){
			ship.setImage("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\Unit17\\ship.jpgWithShield.jpg");
			pu.setPos(-100, -100);
		}
		
		pu.draw(graphToBack);
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
//			int count = 0;
//			count++;
//			if(count > 100){
//				keys[4] = false;
//				count = 0;
//			}
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

