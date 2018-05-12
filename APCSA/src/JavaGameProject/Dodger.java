//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package JavaGameProject;
import javax.swing.JFrame;
import java.awt.Component;

public class Dodger extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Dodger()
	{
		super("DODGER");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		Dodger run = new Dodger();
	}
}