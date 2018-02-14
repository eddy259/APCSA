package Unit5;

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;

	public CharacterAnalyzer()
	{
		theChar = 12;

	}

	public CharacterAnalyzer(char c)
	{
		theChar = c;

	}

	public void setChar(char c)
	{

		theChar = c;
	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		if (theChar >= 65 && theChar <= 90) {
			return true;
		}
		

		return false;
	}

	public boolean isLower( )
	{
		if (theChar >= 97 && theChar <= 122) {
			return true;
		}


		return false;
	}
	
	public boolean isNumber( )
	{

		if (theChar >= 48 && theChar <= 57) {
			return true;
		}

		return false;
	}	

	public int getASCII( )
	{
		return theChar;
	}

	public String toString()
	{

		if (isLower() == true){
			return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";	
		}
		
		else if(isUpper() == true){
			return ""+getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
		}
		else if (isNumber() == true){
			return ""+getChar() + " is a digit. ASCII == " + getASCII() + "\n";
		}
		else {
			return "none";
		}
	}
}