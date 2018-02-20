package Unit7;

import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;

	public GuessingGame(int stop)
	{
		upperBound = stop;

	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		int goal = (int)(Math.random() * upperBound + 1);
		int counter = 0;
		int guess;
		
		do{
			System.out.println("Guess a number");
			guess = keyboard.nextInt();
			counter++;
		}while (guess != goal);

		System.out.println("The answer was" + goal);
		double calc = counter/upperBound;
		System.out.println("You guessed wrong " + calc + "percent of the time");

	}

	public String toString()
	{
		String output="";
		return output;
	}
}