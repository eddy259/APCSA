//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit12;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\APCSA\\src\\Unit12\\"+"lab18e.dat"));
		int n =Integer.parseInt(br.readLine());
		WordNumVowels[] myWords = new WordNumVowels[n];
		for(int i =0;i<n;i++){
			myWords[i]=new WordNumVowels(br.readLine());
		}
		Arrays.sort(myWords);
		for(WordNumVowels i :myWords)out.println(i);
	}
}