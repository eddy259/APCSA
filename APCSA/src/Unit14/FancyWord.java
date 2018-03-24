//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -
package Unit14;
import java.util.*;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{

	}

   public FancyWord(String s)
	{
	   	mat = new char[s.length()][s.length()];
	   	
	   	//fills rows in between first and last
		for(int r = 1;r < s.length() - 1;r++){
			Arrays.fill(mat[r], ' ');
		}
		
		

		for(int r = 1;r < s.length()-1;r++){
			for(int c = 1;c < s.length();c++){
				if(r == c){
					mat[r][c] = s.charAt(r);
				}
				if(r + c + 1 == s.length()){
					mat[r][c] = s.charAt(c);
				}
			}
		}
		
		for(int c = 0;c < s.length();c++){
			mat[0][c] = s.charAt(c);
			mat[s.length()-1][c] = s.charAt(c);
		}

	}

	public String toString()
	{
		String output="";
		for(int r = 0;r < mat.length;r++){
			for(int c = 0;c < mat[0].length;c++){
				output = output + mat[r][c];
			}
			output = output + "\n";
		}

		return output+"\n\n";
	}
}