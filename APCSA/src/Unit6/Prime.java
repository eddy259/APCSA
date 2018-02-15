package Unit6;

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{
		number = 0;

	}

	public Prime(int num)
	{
		number = num;

	}

	public void setPrime(int num)
	{
		number = num;

	}

	public boolean isPrime()
	{
		for (int i = 2; i <= (number / Math.sqrt(number)); i++){
			if (number % i == 0){
				return false;
			}
		}
		return true;






		
	}

	public String toString()
	{
		String output="";

		if (this.isPrime()){
			System.out.println(number +" is prime");
		}
		else{
			System.out.println(number +" is composite");
		}





		return output;
	}
}
