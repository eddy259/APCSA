package Unit1;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	/*
	 *All of your test code should be placed in paint.
	 */
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);


		//instantiate a Shape
		//tell your shape to draw
window.setColor(Color.GRAY);
window.fillRect(300, 100, getWidth()-700, getHeight()-200);
		//instantiate a Shape
		//tell your shape to draw
window.setColor(Color.GRAY);
window.drawLine(350, 300, 450, 250);
window.drawLine(300, 350, 450, 250);
window.drawLine(350, 300, 100, 250);
window.drawLine(300, 320, 100, 250);

window.setColor(Color.GREEN);
window.fillOval(125, 75, getWidth()-400, getHeight()-450);
window.fillOval(45, 210, getWidth()-600, getHeight()-500);
window.fillOval(400, 220, getWidth()-700, getHeight()-500);

		//instantiate a Shape
		//tell your shape to draw
	}
}