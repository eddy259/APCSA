package Unit11;

public class Grade {
	private double value;
	
	public Grade(){
		value = 100;
	}
	public Grade(double temp){
		value = temp;
	}
	public String getLetterGrade(){
		
		if(value>=90) 
			return "A";
		else if (value>=80) 
			return "B";
		else if (value>=70) 
			return "C";
		else if (value >=60) 
			return "D";
		return "F";
	}
	public double getNumericGrade(){
		return value;
	}
	public String toString(){
		return (String.format("%.2f", getNumericGrade()));
	}
}