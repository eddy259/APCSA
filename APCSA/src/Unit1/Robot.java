package Unit1;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);
      
      window.drawString("Robot LAB ", 35, 35 );

      //call head method
      Robot robot = new Robot();
      robot.head(window);
      //call other methods
      robot.upperBody(window);
      robot.lowerBody(window);
   }

   public void head( Graphics window )
   {
      window.setColor(Color.YELLOW);

      window.fillOval(300, 100, 200, 100);


		//add more code here
		window.setColor(Color.GREEN);
		window.fillOval(340, 120, 20, 20);
		window.fillOval(440, 120, 20, 20);
		window.setColor(Color.BLACK);
		window.fillOval(390, 150, 20, 10);
		window.setColor(Color.red);
		window.drawArc(350, 150, 100, 40, 180, 180);
   }

   public void upperBody( Graphics window )
   {

		//add more code here
	   window.setColor(Color.YELLOW);
	   window.drawRect(339, 224, 121, 76);
	   window.setColor(Color.blue);
	   window.fillRect(340, 225, 120, 75);
	   window.setColor(Color.black);
	   window.drawLine(460, 225, 540, 185);
	   window.drawLine(340, 225, 260, 185);

   }

   public void lowerBody( Graphics window )
   {
	   window.setColor(Color.yellow);
	   window.drawRect(339, 319, 121, 76);
	   window.setColor(Color.gray);
	   window.fillRect(340, 320, 120, 75);
		//add more code here
	   window.setColor(Color.black);
	   window.drawLine(460, 395, 540, 480);
	   window.drawLine(340, 395, 260, 480);

   }
}
