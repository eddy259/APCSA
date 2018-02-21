package Unit7;

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		
		int gcf = 1;
		int max = 0;
		if (a > max){
			max = a;
		}
		if (b > max){
			max = b;
		}
		if (c > max){
			max = c;
		}
		
		for(int i = 1; i < max; i++){
			if (a % i == 0 && b % i == 0 && c % i == 0){
				gcf = i;
				
			}
		}

		return gcf;
	}

	
	public boolean firstCondition(int a, int b, int c){
		
		return true;	
	}
	
	
	public String toString()
	{
		String output="";






		return output+"\n";
	}
}