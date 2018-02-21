package Unit7;

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		size = 3;
		letter = "A";
	}

	public TriangleThree(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle( String let, int sz )
	{
		size = sz;
		letter = let;
	}

	public String getLetter()
	{
		return "#";
	}

	public String toString()
	{
		String out ="";
		
		for(int i = 1; i <= size; i++){
			
			for(int c = size; c > i; c--){
				out = out + " ";
				
			}
			
			for(int r = 1; r <= i; r++){
				out = out + letter;
			}
			
			out = out + "\n";
		}
		
		
		
		
		return out+"\n";
	}
}