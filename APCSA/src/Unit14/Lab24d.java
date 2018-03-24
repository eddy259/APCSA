//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -
package Unit14;
import java.util.Scanner;
import static java.lang.System.*;

import java.util.*;
import java.io.*;
public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\APCSA\\src\\Unit14\\"+"lab24d.dat"));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			System.out.println(new TicTacToe(br.readLine()));
		}
	}
}



