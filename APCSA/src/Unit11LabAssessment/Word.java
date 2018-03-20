package Unit11LabAssessment;

public class Word {
	private double length;
	private String word;
	
	public Word(){
		word = "test";
		length = word.length();
	}
	public Word(String str){
		word = str;
		length = word.length();
	}
	
	public double getLength(){
		return length;
	}
	
	public String getLengthinWords(){
		
		if(length>=10) 
			return "Really Long";
		else if (length>=7) 
			return "Long";
		else if (length>=5) 
			return "Mid";
		else if (length >=2) 
			return "Short";
		return "Single letter";
	}
	public String getWord(){
		return word;
	}
	public String toString(){
		return getWord();
	}
}