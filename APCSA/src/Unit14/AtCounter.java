//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

package Unit14;

import static java.lang.System.*;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   private boolean[][] visited;
   private boolean firstrun = true;
   private int rp;
   private int cp;
   
   
	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
	
		visited = new boolean[10][10];
	
	}
	

	public void countAts(int r, int c)
	{

		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
		
		if (firstrun == true){
			firstrun = false;
			rp = r;
			cp = c;
		}
		
		//System.out.println(r + " " +  c);
		if ((0 <= r && r < atMat.length) && (0 <= c && c < atMat[0].length) && atMat[r][c] == '@'){
			if (visited[r][c] == false){
				//System.out.println("Count");
				visited[r][c] = true;
				atCount++;
				countAts(r+1,c);
				countAts(r,c+1);
				countAts(r-1,c);
				countAts(r,c-1);
			}
			
			
			
			
		}
		
		return;
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output= rp + " " + cp + " has ";
		output += getAtCount() + " @s connected.";
		return output;
	}
}