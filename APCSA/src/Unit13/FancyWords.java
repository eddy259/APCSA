package Unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public String toString()
	{
		String output = "";
		int max = Integer.MIN_VALUE;
		
		for(int i = 0;i < wordRay.length;i++){
			if (wordRay[i].length() > max){
				max = wordRay[i].length();
			}
		}
		
		for(int i = 0;i < max;i++){
			for(int c = wordRay.length-1; c >= 0; c--){
				
				if(wordRay[c].length() <= i){
					output += " ";
					continue;
				}
				else{
					output += wordRay[c].charAt(wordRay[c].length() - i - 1);
				}
			}
			output = output + "\n";
		}

		return output+"\n\n";
	}
}