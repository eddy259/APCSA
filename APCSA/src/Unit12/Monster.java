package Unit12;

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster(){
		new Monster(0);
	}


	//write an initialization constructor with an int parameter ht
	public Monster(int ht){
		new Monster(ht,0);
	}


	//write an initialization constructor with int parameters ht and wt
	public Monster(int ht, int wt){
		new Monster(ht, wt, 0);
	}



	//write an initialization constructor with int parameters ht, wt, and age
	public Monster(int ht, int wt, int age){
		myWeight = wt; 
		myHeight = ht;
		myAge=age;
	}


//modifiers - write set methods for height, weight, and age

	public void setHeight(int height){
		myHeight = height;
	}
	public void setWeight(int weight){
		myWeight = weight;
	}
	public void setAge(int age){
		myAge = age;
	}

//accessors - write get methods for height, weight, and age
	public int getHeight(){
		return myHeight;
	}
	
	public int getWeight(){
		return myWeight;
	}
	
	public int getAge(){
		return myAge;
	}


//creates a new copy of this Object
	public Object clone()
	{
	   return new Monster();
	}

	public boolean equals( Object obj )
	{
		Monster test= (Monster)obj;
		
		if(test.getAge()==getAge() && test.getHeight()==getHeight() && test.getWeight()==getWeight()){
			return true;
		}
		
		return false;
	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;
		if (getHeight()>rhs.getHeight()) {
			return 1;
		}
		if (getHeight()<rhs.getHeight()) {
			return -1;
		}
		if (getWeight()>rhs.getWeight()) {
			return 1;
		}
		if (getWeight()<rhs.getWeight()) {
			return -1;
		}
		if (getAge()>rhs.getAge()) {
			return 1;
		}
		if (getAge()<rhs.getAge()) {
			return -1;
		}
		return 0;

	}

//write a toString() method
	public String toString(){
		
		String out = "";
		out += getHeight() + " " + getWeight() + " " + getAge();
		return out;
		
	}
	
}