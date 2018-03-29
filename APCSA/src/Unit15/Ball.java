//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit15;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int width, int height)
	{
		super(x,y, width, height);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int width, int height, Color color)
	{
		super(x,y, width, height, color);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int width, int height, Color color, int xspd, int yspd)
	{
		super(x,y, width, height, color);
		xSpeed = xspd;
		ySpeed = yspd;
	}
	
	
	
	
	
	
	
	
	
	
	
	   
   //add the set methods
	public void setxSpeed(int x){
		xSpeed = x;
	}
	   
	public void setySpeed(int y){
		ySpeed = y;
	}
	
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location

	  super.draw(window, Color.WHITE);
      setX(getX() + xSpeed);
		//setY
      setY(getY() + ySpeed);
		//draw the ball at its new location
      
      super.draw(window);
   }
   
	public boolean equals(Object obj)
	{

		Ball b = (Ball) obj;
		
		if (getX() == b.getX() && getY() == b.getY() && getWidth() == b.getWidth() && getHeight() == b.getHeight() && getColor().equals(b.getColor()) && getxSpeed() == b.getxSpeed() && getySpeed() == b.getySpeed()){
			return true;
		}
		
		return false;

	}   

   //add the get methods
	
	public int getxSpeed(){
		return xSpeed;
	}

	public int getySpeed(){
		return ySpeed;
	}
	
   //add a toString() method
	
	public String toString(){
		return super.toString() + " " + getxSpeed() + " " + getySpeed();
		
	}
}