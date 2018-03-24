//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -
package Unit14;
import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;
	private String condition;

	public TicTacToe()
	{


	}

	public TicTacToe(String game)
	{
		
		//takes in one line of game at time
		//one line = nine X or O
		mat = new char[3][3];
		
		int counter = 0;
		
		for(int i = 0;i < 9;i++){
			mat[i/3][i%3] = game.charAt(i);
			System.out.print(game.charAt(i));
			
			
			
			if(counter%3==2){
				System.out.print("\n");
			}
			counter++;
		}
		
		//horizontal check
		
		for(int r = 0;r < 3;r++){
			
			if(mat[r][0] == mat[r][1] && mat[r][0] == mat[r][2]){
				
			condition = mat[r][0] + " wins horizontally";
			
			return;
			}
		}
		
		//vertical check
		
		for(int c = 0;c < 3;c++){
			
			if(mat[0][c] == mat[1][c] && mat[0][c] == mat[2][c]){
				
			condition = mat[0][c] + " wins vertically";
			
			return;
			}
		}
		
		//diagonal check
		
		if(mat[2][0] == mat[1][1] && mat[1][1] == mat[0][2] || mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2]){
			
			condition = mat[1][1] + " wins diagonally";
			
			return;
		}
		
		condition = "Draw";



	}

	public String getWinner()
	{

		return condition;
	}

	public String toString()
	{
		String output="";

		output += condition;

		return output+"\n\n";
	}
}