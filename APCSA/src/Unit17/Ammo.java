//� A+ Computer Science  -  www.apluscompsci.com
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

public class Ammo extends MovingThing
{
	private int speed;
	private boolean hit;

	public Ammo()
	{
		this(0,0,0);
		hit = false;
	}

	public Ammo(int x, int y)
	{
		super(x,y);
		hit = false;
		//add code
	}

	public Ammo(int x, int y, int s)
	{
		super(x,y);
		speed = s;
		hit = false;
		//add code
		
		
	}
	
	public void setHit(boolean b){
		hit = b;
	}
	public boolean getHit(){
		return hit;
	}

	public void setSpeed(int s)
	{
		speed = s;
	   //add code
	}
	
	public boolean hitAlien(Alien x){
		if(this.getX() < x.getX() + 55 && this.getX() > x.getX() + 7 && this.getY() > x.getY() && this.getY() < x.getY() + 100) {
			return true;
		}
		
		return false;
	}
	
	public boolean hitShip(Ship s){
		if(this.getX() < s.getX() + 55 && this.getX() > s.getX() + 7 && this.getY() > s.getY() && this.getY() < s.getY() + 100) {
			return true;
		}
		
		return false;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.BLUE);
		
		window.fillRect(getX(), getY(), 20, 20);
		//this.move("UP");
	}

	public String toString()
	{
		return "";
	}
}
