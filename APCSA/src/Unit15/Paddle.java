//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit15;
import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	   super(10,10);
	   speed =5;
   }


   //add the other Paddle constructors


   public Paddle(int x, int y)
	{
		super(x,y);
		speed =5;
	}
	
	public Paddle(int x, int y, int width, int height)
	{
		super(x,y, width, height);
		speed =5;
	}
	
	public Paddle(int x, int y, int width, int height, Color color)
	{
		super(x,y, width, height, color);
		speed =5;
	}
	
	public Paddle(int x, int y, int width, int height, Color color, int spd)
	{
		super(x,y, width, height, color);
		speed = spd;
	}







   public void moveUpAndDraw(Graphics window)
   {
	   super.draw(window, Color.WHITE);
	   setY(getY() + speed);
		//draw the ball at its new location
	      
	   super.draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   super.draw(window, Color.WHITE);
	   setY(getY() - speed);
		//draw the ball at its new location
	      
	   super.draw(window);

   }

   //add get methods
   
   public int getSpeed(){
	   return speed;
   }
   
   public void setSpeed(int x){
	   speed = x;
   }
   
   
   public String toString(){
		return super.toString() + " " + getSpeed();
		
	}
   //add a toString() method
}