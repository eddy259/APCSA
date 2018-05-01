//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit17;
import javax.swing.JFrame;
import java.awt.Component;

public class StarFighter extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public StarFighter()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		StarFighter run = new StarFighter();
	}
}

//finished lab assessment in 35 mins, 2:10 - 2:45