package Unit7;

import java.util.Scanner;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		System.out.println("Choose an upper bound");
		Scanner keyboard = new Scanner(System.in);
		int response;
		response = keyboard.nextInt();

		GuessingGame test = new GuessingGame(response);
		test.playGame();



	}
}