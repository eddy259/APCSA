//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit17;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private boolean powerup;

	public Ship()
	{
		this(0,0,0);
		powerup = false;
	}

	public Ship(int x, int y)
	{
		this(x,y,0);
		powerup = false;
	}

	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed = s;
		powerup = false;
		try
		{
			//image = ImageIO.read(new File("\\C:\\Users\\ED2016\\git\\APCSA\\APCSA\\src\\Unit17\\ship.jpg"));
			image = ImageIO.read(new File("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\Unit17\\ship.jpg"));
		
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println(e);
		}
	}

	public void setImage(String s){
		try{
			image = ImageIO.read(new File(s));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void setSpeed(int s)
	{
	   //add more code
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
	
	public boolean hitAlien(Alien x){
		if(this.getX() < x.getX() + 55 && this.getX() > x.getX() + 7 && this.getY() > x.getY() && this.getY() < x.getY() + 100) {
			return true;
		}
		
		return false;
	}
	
	public boolean hitPowerUp(PowerUp pu){
		if(this.getX() < pu.getX() + 55 && this.getX() > pu.getX() + 7 && this.getY() > pu.getY() && this.getY() < pu.getY() + 100) {
			powerup = true;
			return true;
			
		}
		
		return false;
	}
	
	public void setPUstatus(boolean b){
		powerup = b;
	}
	
	public boolean getPUstatus(){
		return powerup;
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
