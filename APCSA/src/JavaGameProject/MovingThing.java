//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package JavaGameProject;
import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Locatable
{
	private int xPos;
	private int yPos;

	public MovingThing()
	{
		xPos = 0;
		yPos = 0;
	}

	public MovingThing(int x, int y)
	{
		xPos = x;
		yPos = y;
	}

	public void setPos( int x, int y)
	{
		//add more code
		xPos = x;
		yPos = y;
	}


	public void setX(int x)
	{
		//add more code
		xPos = x;
	}


	public void setY(int y)
	{
		yPos = y;
		//add more code
	}

	public int getX()
	{
		return xPos;
	}


	public int getY()
	{
		return yPos;
	}

	public abstract void setSpeed( double s );
	public abstract double getSpeed();
	public abstract void draw(Graphics window);

	public void move(String direction)
	{
		if(direction.equals("LEFT"))
			setX((int)(getX()-getSpeed()));
		if(direction.equals("RIGHT"))
		    setX((int)(getX()+getSpeed()));
		if(direction.equals("UP"))
		    setY((int)(getY()-getSpeed()));
		if(direction.equals("DOWN"))
		    setY((int)(getY()+getSpeed()));

      //add more code to complete the move method
	}

	public String toString()
	{
		return "";
	}
}