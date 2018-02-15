package Unit6;

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		//call set
		setRemover("Asdfsd", 'b');
	}

	//add in second constructor
	public LetterRemover(String a, char b){
		setRemover(a,b);
		
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned = sentence;
		while(cleaned.indexOf(lookFor) != -1){
			cleaned = cleaned.replaceAll(String.valueOf(lookFor), "");
		}
		

		return cleaned;
	}

	public String toString()
	{
		System.out.println(this.removeLetters() + "\n");
		return sentence + " - letter to remove " + lookFor;
		
	}
}
