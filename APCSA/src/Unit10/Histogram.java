package Unit10;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;

	public Histogram()
	{
		letters = new ArrayList<Character>();
		count = new ArrayList<Integer>();
		char[] values = {'x'};
		for (char c : values){
			letters.add(c);
			count.add(0);
		}
		
		fileName = "lab16e1.dat";
		out.println("search letters = " +letters);

	}

	public Histogram(char[] values, String fName)
	{
		letters = new ArrayList<Character>();
		count = new ArrayList<Integer>();
	
		for (char c : values){
			letters.add(c);
			count.add(0);
		}
		
		fileName = fName;
		out.println("search letters = " +letters);


	}

	public void loadAndAnalyzeFile() throws IOException
	{

		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\APCSA\\src\\Unit10\\"+fileName));
			
			while(file.hasNextLine()){
				String s = file.nextLine();
				for(int i = 0; i < s.length(); i++){
					for(int k = 0; k < letters.size(); k++){
						if (letters.get(k) == s.charAt(i)){
							count.set(k, count.get(k) + 1);
						}
					}
				}
			}
			
			file.close();
		}
		catch (Exception e){
			System.out.println(e);
		}




	}

	public char mostFrequent()
	{
		
		int max = count.get(0);
		int perm = 0;
		for(int i = 1; i < count.size();i++){
			if (count.get(i)>max){
				
				max = count.get(i);
				perm = i;
			}
		}
		
		return letters.get(perm);
		
		
	}

	public char leastFrequent()
	{
		int min = count.get(0);
		int perm = 0;
		for(int i = 1; i < count.size();i++){
			if (count.get(i)<min){
				
				min = count.get(i);
				perm = i;
			}
		}
		
		return letters.get(perm);
	}

	public String toString()
	{
//	   return "Letter occurring most: " + mostFrequent() + "\n" + "Letter occurring least: " + leastFrequent() + "\n" + 
		return fileName
		+ "\n" + letters
		+ "\n" + count + "\n\n\n";
	}
}