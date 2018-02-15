package Unit6;

import static java.lang.System.*;

public class LoopStats
{
	private int start, stop;

	public LoopStats()
	{

		start = 0; stop = 1;
	}

	public LoopStats(int beg, int end)
	{

		start = beg; stop = end;
	}

	public void setNums(int beg, int end)
	{

		start = beg; stop = end;
	}

	public int getEvenCount()
	{
		int evenCount=0;
		for (int i = start; i <= stop; i++){
			if (i % 2 == 0){
				evenCount += 1;
			}


		}
		System.out.println("Even count: " + evenCount);
		return evenCount;
	}

	public int getOddCount()
	{
		int oddCount=0;

		for (int i = start; i <= stop; i++){
			if (i % 2 == 1){
				oddCount += 1;
			}



		}
		System.out.println("Odd count: " + oddCount +"\n");
		return oddCount;
		
		
	}

	public int getTotal()
	{
		int total=0;
		for(int i = start; i <= stop; i++){
			total += i;
		}
		System.out.println("Total is "+ total);



		return total;
	}
	
	public String toString()
	{
		return start + " " + stop;
	}
}
