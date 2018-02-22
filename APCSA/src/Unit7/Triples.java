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
		
		if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2)){ 
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean secondCondition(int a, int b, int c){
		if(c % 2 == 0){
			return false;
		}
		if(a %2 == 0 && b%2 == 1){
			return true;
		}
		else if(a%2 == 1 && b%2 == 0){
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
	public String toString()
	{
		String output="";

		for(int a = 1; a < number; a ++){
			for(int b = a;b < number -1; b++){
				for(int c = b; c < number; c++){
					if(c * c != a * a + b * b){
						continue;
					}
					if( greatestCommonFactor(a,b,c) == 1 && secondCondition(a,b,c) == true){
						output = output + a + " " + b + " " + c + "\n";
					
					}
					
					
				}
			}
			
		}

		return output+"\n";
	}
}