//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

package JavaGameProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class EnemySquare extends MovingThing
{
	private double speed;
	private Image image;

	public EnemySquare()
	{
		this(0,0,0);
	}

	public EnemySquare(int x, int y)
	{
		this(x,y,0);
	}

	public EnemySquare(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\JavaGameProject\\redsquare.png"));
			//image = ImageIO.read(new File("\\C:\\Users\\ED2016\\git\\APCSA\\APCSA\\src\\Unit17\\alien.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println(e);
		}
	}

	public void setSpeed(double s)
	{
	   //add code
		speed = s;
	}

	public double getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),10,10,null);
	}

	public void move(String direction)
	{
		
		if(direction.equals("LEFT"))
			setX((int)(getX()-getSpeed()));
		if(direction.equals("RIGHT"))
		    setX((int)(getX()+getSpeed()));
		if(direction.equals("UP"))
		    setY((int)(getY()-getSpeed()));
		if(direction.equals("DOWN"))
//			try        
//			{
//			    Thread.sleep(1);
//			} 
//			catch(InterruptedException ex) 
//			{
//			    Thread.currentThread().interrupt();
//			}
			
				
			if((int)(Math.random() * 2) == 1){
				setY((int)(getY()+getSpeed()));
			}
			
			
		    

      //add more code to complete the move method
	}
	
	public String toString()
	{
		return "";
	}
}
