package Unit16;
public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the sum 
   * @return the sum of the values in the array
   */
  public int getTotal()
  {
    int sum = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        sum = sum + matrix[row][col];
      }
    }
    return sum;
  }
  
  /**
   * Method to return the sum using a nested for-each loop
   * @return the sum of the values in the array
   */
  public int getTotalNested()
  {
    int sum = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        sum = sum + item;
      }
    }
    return sum;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  public int getCount(int x){
	  
	  int count = 0;
	  for(int r = 0;r < matrix.length;r++){
		  for(int c = 0;c<matrix[0].length;c++){
			  if(matrix[r][c] == x){
				  count++;
			  }
		  }
	  }
	  
	  return count;
  }
  
  public int getLargest(){
	  
	  int max = Integer.MIN_VALUE;
	  for(int r = 0; r < matrix.length; r++){
		  for(int c = 0;c < matrix[r].length; c++){
			  if (matrix[r][c] > max) {
					max = matrix[r][c];
			  }
		  }
	  }
	  return max;
  }
  
  public int getColTotal(int c){
	  
	  int sum = 0;
	  
	  for(int r = 0;r < matrix.length; r++) {
		  sum = sum + matrix[r][c];
	  }
	  
	  return sum;
  }

  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
}