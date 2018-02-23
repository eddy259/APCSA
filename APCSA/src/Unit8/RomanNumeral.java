package Unit8;

import static java.lang.System.*;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{

		roman = str;
		for(int i = 0; i < roman.length() - 1; i++){
			//checks if either the single letter or double letter combo is in the list, if it is then converts it to integer
			//takes advantage of the fact that the max length is only two letters
			String s1 = roman.substring(i, i+1);
			String s2 = roman.substring(i, i+2);
			boolean converted = false;
			for(int c = 0; c < LETTERS.length; c++){
				if (LETTERS[c] == s2){
					//convert to int
					converted = true;
				}	
			}
			
			if (converted == false){
				for(int c = 0; c < LETTERS.length; c++){
					if (LETTERS[c] == s1){
						//convert to int
						converted = true;
					}
					
				}
			}
		}
//convert from roman to int

	}

	public RomanNumeral(Integer orig)
	{

		number = orig;
//convert from int to roman

	}

	public void setNumber(Integer num)
	{

		number = num;



	}

	public void setRoman(String rom)
	{

		roman = rom;

	}

	public Integer getNumber()
	{
		return number;
	}

	public String toString()
	{
		return roman + "\n";
	}
}