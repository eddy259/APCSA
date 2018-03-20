package Unit12;

import static java.lang.System.*;

public class WordNumVowels implements Comparable<WordNumVowels>
{
	private String WordNumVowels;

	public WordNumVowels( String s)
	{
		WordNumVowels = s;


	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int numvowels = 0;
		for(int i = 0;i<WordNumVowels.length();i++){
			for(int j = 0;j<vowels.length();j++){
				if(WordNumVowels.charAt(i)==vowels.charAt(j)){
					numvowels+=1;
				}
			}
		}
		return numvowels;
		
	}

	public int compareTo(WordNumVowels rhs)
	{

		if(numVowels()>rhs.numVowels()) {
			return 1;
		}
		if(numVowels()<rhs.numVowels()){
			return -1;
		}
		for(int i = 0;i<Math.min(this.toString().length(), rhs.toString().length());i++){
			if(toString().charAt(i) > rhs.toString().charAt(i)) {
				return 1;
			}
			else if (toString().charAt(i)<rhs.toString().charAt(i)) {
				return -1;
			}
		}
		
		return -1;
	}

	public String toString()
	{
		return WordNumVowels;
	}
}