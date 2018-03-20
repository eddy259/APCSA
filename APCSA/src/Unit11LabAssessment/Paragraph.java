package Unit11LabAssessment;

public class Paragraph implements Comparable<Paragraph>
{
	private String pgName;
	private Sentence mySentence;
	
	public Paragraph()
	{
		setName("");
		setSentence("");
	}
	
	public Paragraph(String name, String wordList)
	{
		setName(name);
		setSentence(wordList);

	}
	
	public void setName(String name)
	{
		pgName = name;

	}	
	
	public void setSentence(String wordList)
	{
		mySentence = new Sentence(wordList);
	
	}
	
	public void setWord(int i, String word)
	{
		mySentence.setWord(i, word);

	}

	public String getName()
	{
		return pgName;
	}
	
	public int getNumWords()
	{
		return mySentence.getNumWords();
	}

	public double getTotalLength()
	{
		return mySentence.getTotalLength();
	}
	
	public double getAverage()
	{
		return getTotalLength()/getNumWords();
	}

	public double getAverageMinusLow()
	{
		return getAverage() - getShortest();
	}
	
	public double getLongest()
	{
		return mySentence.getLongest();		
	}
	
	public double getShortest()
	{
		return mySentence.getShortest();	
	}
	
	public java.util.ArrayList<Word> getSentence(){
		return mySentence.getSentence();
		}
	
	
	
	public String toString()
	{
		return pgName + " = " + mySentence;
	}	
	
	
	public int compareTo(Paragraph d){
		if (getAverage() - d.getAverage()>0) {
			return 1;
		}
		else if(getAverage() - d.getAverage()==0){
			return 0;
		}
		return -1;
	}
}
