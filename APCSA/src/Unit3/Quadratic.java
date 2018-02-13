package Unit3;

public class Quadratic {

	private int a = 0;
	private int b = 0;
	private int c = 0;
	
	public Quadratic(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;
		double rootOne = (-quadB + Math.sqrt(quadB * quadB - 4 * quadA * quadC))/(2 * quadA);
		double rootTwo = (-quadB - Math.sqrt(quadB * quadB - 4 * quadA * quadC))/(2 * quadA);
		System.out.println("Root one is "+ String.format("%.2f", rootOne));
		System.out.println("Root two is "+ String.format("%.2f", rootTwo));
		
	}
	
}
