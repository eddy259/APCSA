//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit14;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private boolean[][] visited;
   private int max;
   
	public Maze()
	{


	}

	public Maze(int size, String line)
	{
		
		maze = new int[size][size];
		visited = new boolean[size][size];
		Scanner in = new Scanner(line);
		
		for(int r = 0;r < size;r++){
			for(int c = 0;c < size;c++){
				int x = in.nextInt();
				if(x == 1){
					System.out.print("1");
					maze[r][c]= 1;
				}
				else {
					System.out.print("0");
				}
			}
			System.out.println("\n");
		}
		
		max = size;
		
		in.close();

	}

	public boolean hasExitPath(int r, int c)
	{
		if(c == max){
			return true;
		}
		
		if ((0 <= r && r < maze.length) && (0 <= c && c < maze[0].length) && maze[r][c] == 1){
			if (visited[r][c] == false){
				visited[r][c] = true;
				if(hasExitPath(r+1,c)){
					return true;
				}
				if(hasExitPath(r,c+1)){
					return true;
				}
				if(hasExitPath(r-1,c)){
					return true;
				}
				if(hasExitPath(r,c-1)){
					return true;
				}
			}	
		}
		return false;
		
	}

	public String toString()
	{
		String output="";


		if(hasExitPath(0,0)){
			output += "\n exit found\n";
		}
		else {
			output += "\n exit not found\n";
		}


		return output;
	}
}