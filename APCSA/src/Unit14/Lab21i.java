//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit14;
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Lab21i
{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\APCSA\\src\\Unit14\\"+"lab21i.dat"));
		for (int i = 0; i < 6; i++) {
			int numLines1 = Integer.parseInt(br.readLine());
			String Line1 = br.readLine();
			Maze adam = new Maze(numLines1, Line1);
			
			System.out.println(adam);
		}
	}
}