package Unit4;

import static java.lang.System.*;

public class Name
{
	private String name;

	public Name()
	{
		name = "asdf";

	}

	public Name(String s)
	{
		name = s;

	}

   public void setName(String s)
   {
	   name = s;

   }

	public String getFirst()
	{
		int stringindex = name.indexOf(" ");
		return name.substring(0, stringindex);
	}

	public String getLast()
	{
		int stringindex = name.indexOf(" ");
		return name.substring(stringindex + 1, name.length());
	}

 	public String toString()
 	{
 		return "";
	}
}