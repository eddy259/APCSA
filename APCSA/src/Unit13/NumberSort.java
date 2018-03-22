package Unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	private static int getNumDigits(int num)
	{
		int i = 0;
		
		while(num >0){
			num = num/10;
			i++;
		}
		return i;
		
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int temp = getNumDigits(number);
		
		int[] sorted = new int[temp];
		
		for(int i = 0;i < temp;i++){
			sorted[i] = number % 10;
			number = number / 10;
		}
		Arrays.sort(sorted);

		return sorted;
	}
}