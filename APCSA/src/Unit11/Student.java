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

public class Student
{
	private String myName;
	private Grades myGrades;
	
	public Student()
	{
		setName("");
		setGrades("");
	}
	
	public Student(String name, String gradeList)
	{

		setName(name);
		setGrades(gradeList);

	}
	
	public void setName(String name)
	{
		myName = name;

	}	
	
	public void setGrades(String gradeList)
	{
		myGrades=new Grades(gradeList);
	
	}
	
	public void setGrade(int spot, double grade)
	{
		myGrades.setGrade(spot, grade);

	}

	public String getName()
	{
		return myName;
	}
	
	public int getNumGrades()
	{
		return myGrades.getNumGrades();
	}

	public double getSum()
	{
		return myGrades.getSum();
	}
	
	public double getAverage()
	{
		return getSum()/getNumGrades();
	}

	public double getAverageMinusLow()
	{
		return getAverage()-getLowGrade();
	}
	
	public double getHighGrade()
	{
		return myGrades.getHighGrade();	
	}
	
	public double getLowGrade()
	{
		return myGrades.getLowGrade();
	}
	
	public int compareTo(Student s){
		if (getAverage()-s.getAverage()>0){
			return 1;
		}
		else if(getAverage()-s.getAverage()==0){
			return 0;
		}
		return -1;
	}
	
	public Grade[] getGrades(){
		return myGrades.getGrades();
		
	}
	
	public String toString()
	{
		return myName+" = "+myGrades;
	}	
}