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

public class Ship extends MovingThing
{
	private double speed;
	private Image image;

	public Ship()
	{
		this(0,0,0);
	}

	public Ship(int x, int y)
	{
		this(x,y,0);
	}

	public Ship(int x, int y, double s)
	{
		super(x, y);
		speed = s;
		try
		{
			//image = ImageIO.read(new File("\\C:\\Users\\ED2016\\git\\APCSA\\APCSA\\src\\Unit17\\ship.jpg"));
			image = ImageIO.read(new File("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\JavaGameProject\\greensquare.png"));
		
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println(e);
		}
	}


	public void setSpeed(double s)
	{
	   //add more code
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

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
