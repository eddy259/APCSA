package Unit13;

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		System.out.println();
		System.out.println("pass 0 "+ Arrays.toString(list));
		passCount = 0;
		quickSort(list, 0, list.length-1);
	}


	private static void quickSort(Comparable[] list, int low, int high)
	{
		if(low < high){
			int s = partition(list, low, high);
			quickSort(list, low, s);
			quickSort(list, s+1, high);
		}
		
		
	}


	private static int partition(Comparable[] list, int low, int high)
	{

		Comparable pivot = list[low];
		int bot = low-1;
		int top = high+1;
		while(true){
			do{
				top--;

			}while(list[top].compareTo(pivot)>0);
			
			do{
				bot++;
			}while(list[bot].compareTo(pivot)<0);
			
			if(bot >= top){
				return top;
			}
			Comparable temp = list[bot];
			list[bot] = list[top];
			list[top] = temp;
			passCount++;
			System.out.println("pass " + passCount + " " + Arrays.toString(list));
		}
	}
}