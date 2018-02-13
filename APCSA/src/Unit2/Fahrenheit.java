package Unit2;

public class Fahrenheit
{
	private double fahrenheit;

	public void setFahrenheit(double fahren)
	{
		fahrenheit=fahren;
	}

	public double getCelsius()
	{
		double cels = 0.0;
		
		cels = 5*(fahrenheit-32) /9;
		return cels;
	}

	public void print()
	{
		//this is part of the solution
		System.out.println(getCelsius());
	}
}
