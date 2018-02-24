package Unit8;

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	//instance variables
	int max = 0;
	double[] actualgradesarray;

	//constructor
	public Grades (int tempmax, String input){
		
		Scanner in = new Scanner(input);
		
		max = tempmax;
		String[] gradestrarray = input.split(" ");
		double[] gradesarray = new double[gradestrarray.length];
		for (int i = 0; i < gradestrarray.length; i++){
			gradesarray[i] = in.nextDouble();
			
		}
		
		actualgradesarray = gradesarray;
	}


	//set method
	
	public void setGrades (int tempmax, String input){
			
		Scanner in = new Scanner(input);
		
		max = tempmax;
		String[] gradestrarray = input.split(" ");
		double[] gradesarray = new double[gradestrarray.length];
		for (int i = 0; i < gradestrarray.length; i++){
			gradesarray[i] = in.nextDouble();
			
		}
				
		actualgradesarray = gradesarray;
	}



	private double getSum()
	{
		double sum = 0.0;
		
		for(double d : actualgradesarray){
			sum = sum + d;
			
		}



		return sum;
	}

	public double getAverage()
	{
		double average=0.0;

		average = getSum()/actualgradesarray.length;

		return average;
	}


	//toString method
	public String toString()
	{
		String out = "";
		
		for(int i = 0; i < actualgradesarray.length; i++){
			out = out + "Grade " + i + ":: " + actualgradesarray[i] + "\n";
			
		}
		
		out = out + "\n \n" + "Average: " + getAverage();
		
		return out;
	}


}