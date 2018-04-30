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
	private int speed;
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
			image = ImageIO.read(new File("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\Unit17\\alien.jpg"));
			//image = ImageIO.read(new File("\\C:\\Users\\ED2016\\git\\APCSA\\APCSA\\src\\Unit17\\alien.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println(e);
		}
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}

	public String toString()
	{
		return "";
	}
}
