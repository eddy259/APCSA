//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner br = new Scanner(new File(System.getProperty("user.dir")+"\\APCSA\\src\\Unit12\\"+"lab18d.dat"));
		int n = Integer.parseInt(br.nextLine());
		Word[] myWords = new Word[n];
		for(int i =0;i<n;i++) myWords[i]=new Word(br.nextLine());
		Arrays.sort(myWords);
		for(int i =0;i<myWords.length;i++)out.println(myWords[i]);


	}
		











}
