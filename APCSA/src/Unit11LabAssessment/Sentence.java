package Unit11LabAssessment;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.util.ArrayList;

public class Sentence
{
	
private ArrayList<Word> words;
	
	public Sentence()
	{
		setWords("");
	}
	
	public Sentence(String wordstr)
	{
		setWords(wordstr);		
	}
	
	public void setWords(String wordstr)
	{
		Scanner in = new Scanner(wordstr);
		int n = (in.nextInt());
		String trash = in.next();
		words = new ArrayList<Word>();
		for(int i = 0;i < n; i++){
			words.add(new Word(in.next()));
		}
	}
	
	public void setWord(int i, String word)
	{
		words.set(i, new Word(word));
	}
	
	public double getTotalLength()
	{
		double sum = 0.0;
		for(int i = 0;i < words.size();i++){
			sum += words.get(i).getLength();
		}
		return sum;
	}
	
	public double getShortest()
	{
		double low = Double.MAX_VALUE;
		for(int i = 0;i<words.size();i++){
			if(words.get(i).getLength()<low){
				low = words.get(i).getLength();
			}
		}
		return low;
	}
	
	public double getLongest()
	{
		double high = Double.MIN_VALUE;
		for(int i = 0; i < words.size();i++){
			if(words.get(i).getLength()>high){
				high=words.get(i).getLength();
			}
		}

		return high;
	}
	
	public int getNumWords()
	{
		return words.size();
	}
	
	public ArrayList<Word> getSentence(){
		return words;
	}
	
	public String toString()
	{
		String output="";
		for(int i = 0;i < words.size();i++){
			output += words.get(i) + " ";
		}
		
		return output;
	}	
}