package Unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	String actualans = "";
	public MadLib()
	{
		String s ="";
		loadNouns();
		loadAdjectives();
		loadVerbs();
		
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\APCSA\\src\\Unit10\\story.dat"));
			
			while (file.hasNext()){
				s = file.nextLine();
				//System.out.println(s);
			}
		
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		String answer = "";
		for(int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '#'){
				answer = answer + getRandomNoun();
			}
			else if (s.charAt(i) == '@'){
				answer = answer + getRandomVerb();
			}
			else if (s.charAt(i) == '&'){
				answer = answer + getRandomAdjective();
			}
			else {
				answer = answer + s.charAt(i);
			}
		}

		actualans = answer;
		
	}

	public MadLib(String fileName)
	{
		//load stuff
		String s ="";
		loadNouns();
		loadAdjectives();
		loadVerbs();
		
		
		try{
			Scanner file = new Scanner(new File(fileName));
			s = file.nextLine();		
			file.close();
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
		
		String answer = "";
		
		for(int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '#'){
				answer = answer + getRandomNoun();
			}
			else if (s.charAt(i) == '@'){
				answer = answer + getRandomVerb();
			}
			else if (s.charAt(i) == '&'){
				answer = answer + getRandomAdjective();
			}
			else {
				answer = answer + s.charAt(i);
			}
		}

		actualans = answer;
	}

	public void loadNouns()
	{
		String s = "";
		nouns = new ArrayList<String>();
		
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\APCSA\\src\\Unit10\\nouns.dat"));
			
			while (file.hasNext()){
				s = file.nextLine();
				nouns.add(s);
			}
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
		
	}
	
	public void loadVerbs()
	{
		String s = "";
		verbs = new ArrayList<String>();
		
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\APCSA\\src\\Unit10\\verbs.dat"));
			
			while (file.hasNext()){
				s = file.nextLine();
				verbs.add(s);
			}
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
	}

	public void loadAdjectives()
	{
		String s = "";
		adjectives = new ArrayList<String>();
		
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\APCSA\\src\\Unit10\\adjectives.dat"));
			
			while (file.hasNext()){
				s = file.nextLine();
				adjectives.add(s);
			}
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
	}

	public String getRandomVerb()
	{
	
		return verbs.get((int)(Math.random()*verbs.size()));
	}
	
	public String getRandomNoun()
	{
		
		return nouns.get((int)(Math.random()*nouns.size()));
	}
	
	public String getRandomAdjective()
	{
		
		return adjectives.get((int)(Math.random()*adjectives.size()));
	}		

	public String toString()
	{
	   return actualans;
	}
}