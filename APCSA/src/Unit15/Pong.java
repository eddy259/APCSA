//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit15;
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

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int p1score;
	private int p2score;
	private boolean done;


	public Pong()
	{
		//set up all variables related to the game

		ball = new Ball(500,200,10,10,Color.BLACK,-5,1);
		leftPaddle = new Paddle(50, 100, 10, 100, Color.RED, 5);
		rightPaddle = new Paddle(700, 100, 10, 100, Color.GREEN, 5);


		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
		
		done = false;
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
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


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		
		
		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
//			ball.setxSpeed(0);
//			ball.setySpeed(0);
			
			
			if (ball.getX() <= 10 && done == false){
				p2score = p2score + 1;
				//done = true;
			}
			if (ball.getX() >= 780 && done == false){
				p1score = p1score + 1;
				//done = true;
			}
			

			
			ball.draw(graphToBack,Color.WHITE);
			ball.setColor(Color.BLACK);
			ball.setX(400);
			ball.setY(100);
			ball.setxSpeed(-5);
			ball.setySpeed(1);
			
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("Player 1: " + (p1score - 1), 100, 100);
			graphToBack.drawString("Player 2: " + (p2score - 1), 600, 100);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Player 1: " + p1score, 100, 100);
			graphToBack.drawString("Player 2: " + p2score, 600, 100);
			
			//done = false;
		}

		
		//see if the ball hits the top or bottom wall 
		
		if(!(ball.getY()>=10 && ball.getY()<=525)){
			ball.setySpeed(-1*ball.getySpeed());
		}
		
		//see if ball hits top or bottom of paddle
		if (ball.didCollideTop(leftPaddle)== true || ball.didCollideBottom(leftPaddle)== true || 
				ball.didCollideTop(rightPaddle)== true || ball.didCollideBottom(rightPaddle)== true)
		{
			ball.setxSpeed(-ball.getxSpeed());
			ball.setySpeed(-ball.getySpeed());
			
		}
		
		
		

		//see if the ball hits the left paddle
		
		if (ball.didCollideLeft(leftPaddle)== true){
			if(ball.getX()<=leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getxSpeed())){
				ball.setySpeed(-1*ball.getySpeed());
			}
			else{
				ball.setxSpeed(-1*ball.getxSpeed());
			}
		}
		
		//see if the ball hits the right paddle
		
		if (ball.didCollideRight(rightPaddle)== true){
			if(ball.getX()+ball.getWidth()>=rightPaddle.getX()+Math.abs(ball.getxSpeed())){
				ball.setySpeed(-1*ball.getySpeed());
			}
			else{
				ball.setxSpeed(-1*ball.getxSpeed());
			}
		}
		


		//see if the paddles need to be moved









		if(keys[0] == true) {
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true) {
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2] == true) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}





		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}