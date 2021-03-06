//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class()
	{
		name="";
		studentList=new Student[0];
	}
	
	public Class(String name, int stuCount)
	{
		this.name=name;
		studentList=new Student[stuCount];
	
	}
	
	public Student[] getStudents(){
		return studentList;
	}
	public static Student[] sort(Class x){
		Arrays.sort(x.getStudents());
		return x.getStudents();
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum]=s;

	}
	
	public String getClassName()
	{
		return name;	
	}
	
	public double getClassAverage()
	{
		double tem=0.0;
		for(int i =0;i<studentList.length;i++){
			tem+=getStudentAverage(i);
		}
		tem/=studentList.length;



		return tem;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName)
	{

		int i=0;
		while(!studentList[i].getName().equals(stuName))i++;
		return getStudentAverage(i);
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hN ="";
		int indexOfHighStudent = -1;
		for(int i =0;i<studentList.length;i++){
			if(studentList[i].getAverage()>high){
				high=studentList[i].getAverage();
				indexOfHighStudent =i;
			}
		}
		hN+=getStudentName(indexOfHighStudent);
		return hN;
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String hN ="";		
		int indexOfLowStudent = -1;
		for(int i=0;i<studentList.length;i++){
			if(studentList[i].getAverage()<low){
				low=studentList[i].getAverage();
				indexOfLowStudent = i;
			}
		}
		hN+=getStudentName(indexOfLowStudent);
		return hN;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="Failure List: ";
		for(int i =0;i<studentList.length;i++){
			if (studentList[i].getAverage()<failingGrade)output+=getStudentName(i)+" ";
		}
		output+="\n";
		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";




		return output;
	}  	
}