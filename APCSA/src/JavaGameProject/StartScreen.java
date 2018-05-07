package JavaGameProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.Image;

public class StartScreen {
	private Image image;
	
	
	public StartScreen(){
		try
		{
			//image = ImageIO.read(new File("\\C:\\Users\\ED2016\\git\\APCSA\\APCSA\\src\\Unit17\\ship.jpg"));
			image = ImageIO.read(new File("\\C:\\Users\\lie2983\\Desktop\\APCSAGitRepository\\APCSA\\src\\JavaGameProject\\javagametitlescreen2.png"));
		
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println(e);
		}
	}
	
	
	public void draw( Graphics window )
	{
		window.drawImage(image,0,0,800,600,null);
	}
	
	
}
