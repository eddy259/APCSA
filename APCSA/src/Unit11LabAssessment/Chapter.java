package Unit11LabAssessment;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.util.ArrayList;
import java.util.Collections;

public class Chapter
{
	private String name;
	private ArrayList<Paragraph> pgList;
	
	public Chapter()
	{
		name = "";
		pgList = new ArrayList<Paragraph>();
	}
	
	public Chapter(String name, int pgCount)
	
	{
		this.name = name;
		pgList = new ArrayList<Paragraph>();
	
	}
	
	public ArrayList<Paragraph> getParagraphs(){
		return pgList;
	}
	
	public static ArrayList<Paragraph> sort(Chapter x){
		Collections.sort(x.getParagraphs());
		return x.getParagraphs();
	}
	
	public void addParagraph(int pgNum, Paragraph s)
	{
		pgList.add(s);

	}
	
	public String getChapterName()
	{
	   return name;	
	}
	
	public double getChapterAverage()
	{
		double temp = 0.0;
		for(int i =0;i<pgList.size();i++){
			temp += getParagraphAverage(i);
		}
		temp /= pgList.size();
		return temp;
	}
	
	public double getParagraphAverage(int pgNum)
	{
		return pgList.get(pgNum).getAverage();
	}

	public double getParagraphAverage(String pgName)
	{
		int i=0;
		while(!pgList.get(i).getName().equals(pgName)){
			i++;
		}
		return getParagraphAverage(i);
	}
	
	public String getParagraphName(int pgNum)
	{
		return pgList.get(pgNum).getName();
	}

	public String getParagraphWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hN ="";
		int indexOfHighestParagraph = -1;
		for(int i = 0;i < pgList.size();i++){
			if(pgList.get(i).getAverage() > high){
				high=pgList.get(i).getAverage();
				indexOfHighestParagraph = i;
			}
		}
		hN += getParagraphName(indexOfHighestParagraph);
		return hN;
	}

	public String getParagraphWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String hN ="";		
		int indexOfLowestParagraph = -1;
		for(int i= 0;i<pgList.size();i++){
			if(pgList.get(i).getAverage()<low){
				low=pgList.get(i).getAverage();
				indexOfLowestParagraph = i;
			}
		}
		hN += getParagraphName(indexOfLowestParagraph);
		return hN;
	}
	
	public String getLengthList(double lengthBar)
	{
		String output="Length List: ";
		for(int i = 0;i<pgList.size();i++){
			if (pgList.get(i).getAverage() < lengthBar){
				output+=getParagraphName(i) + " ";
			}
		}
		
		output = output + "\n";
		
		return output;
	}
	
	public String toString()
	{
		String output= "" + getChapterName() + "\n";
		
	    for(Paragraph i: pgList){
				output += i.toString() + "\t" + "avg=" + i.getAverage() + "\n";
			}
			
		return output;
	}  	
}