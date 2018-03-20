//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit11;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private Grade[] grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		Scanner s = new Scanner(gradeList);
		int n = (s.nextInt());
		String st = s.next();
		grades=new Grade[n];
		for(int i =0;i<n;i++)
			grades[i]=new Grade(Double.parseDouble(s.next()));
	}
	
	public void setGrade(int spot, double grade)
	{
		grades[spot]=new Grade(grade);
	}
	
	public double getSum()
	{
		double sum=0.0;
		for(int i =0;i<grades.length;i++){
			sum+=grades[i].getNumericGrade();
		}
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		for(int i =0;i<grades.length;i++){
			if(grades[i].getNumericGrade()<low){
				low = grades[i].getNumericGrade();
			}
		}
		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		for(int i =0; i<grades.length;i++){
			if(grades[i].getNumericGrade()>high){
				high=grades[i].getNumericGrade();
			}
		}




		return high;
	}
	
	public int getNumGrades()
	{
		return grades.length;
	}
	
	public Grade[] getGrades(){
		return grades;
		
	}
	
	public String toString()
	{
		String output="";
		for(int i = 0;i<grades.length;i++){
			output += grades[i] + " ";
		}
		
		return output;
	}	
}