package Unit16;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
	int count = 0;
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    
    System.out.println(count);
  }
  
  public void mirrorArms(){
	  
	  Pixel[][] pixels = this.getPixels2D();
	  
	  int mirrorPoint = 300;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  
	  for(int c = 100;c < 170;c++){
		  
		  for(int r = 160;r < 190;r++){
			  botPixel = pixels[r+85][c-5];
			  topPixel = pixels[r][c];
			  botPixel.setColor(topPixel.getColor());
		  
		  }
	  }
	  
	  for(int r = 170;r < 200;r++){
		  
		  for(int c = 240;c < mirrorPoint;c++){
			  rightPixel = pixels[r+85][c + 3];
			  leftPixel = pixels[r][c];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  
  public void mirrorGull(){
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for(int r = 233;r < 327;r++){
		
		  for(int c = 233;c < 347;c++){
			  
			  pixels[r+22][c+155].setColor(pixels[r][c].getColor());
		  
		  }
	  }
	  
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, int startrow,int startcolumn,int endrow,int endcolumn,
          int startRow, int startCol)
	{
		
	  	Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = startrow, toRow = startRow; 
		  fromRow < endrow &&
		  toRow < toPixels.length; 
		  fromRow++, toRow++)
		{
			for (int fromCol = startcolumn, toCol = startCol; 
			    fromCol < endcolumn &&
			    toCol < toPixels[0].length;  
			    fromCol++, toCol++)
			{
			 fromPixel = fromPixels[fromRow][fromCol];
			 toPixel = toPixels[toRow][toCol];
			 toPixel.setColor(fromPixel.getColor());
			}
		}   
	}

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
    Picture swan = new Picture("swan.jpg");
    Picture robot = new Picture("robot.jpg");
   
    this.copy(robot,100,50);
    this.copy(swan,56,30,23,70,10,40);
    this.copy(swan,150,90);
    Picture robotNoBlue = new Picture(robot);
    robotNoBlue.zeroBlue();
    this.copy(robotNoBlue,200,0);
    this.copy(swan,300,0);
    this.copy(robot,400,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color downColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
    	topPixel = pixels[row][col];
      	if((row+1) == pixels.length)
      	{
      		botPixel = pixels[row][col];
      	}
      	else
      	{
      	botPixel = pixels[row+1][col];
      	}
      	downColor = botPixel.getColor();
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist || topPixel.colorDistance(downColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void negate(){
	  
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for(Pixel[] rowArray:pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setColor(new Color(255 - pixelObj.getRed(), 255 - pixelObj.getGreen(), 255 - pixelObj.getBlue()));
		  }
	  }
	  
  }
  
  public void grayScale(){
	  
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for(Pixel[] rowArray:pixels){
		  
		  for(Pixel pixelObj : rowArray){
			  
			  int avg = (pixelObj.getBlue() + pixelObj.getGreen()+pixelObj.getRed())/3;
			  pixelObj.setColor(new Color(avg, avg, avg));
		  }
	  }
  }
  
  public void fixUnderwater(){
	  
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for(Pixel[] rowArray:pixels){
		  
		  for(Pixel pixelObj:rowArray){
			  if (pixelObj.getBlue()>pixelObj.getGreen()) {
				  pixelObj.setBlue(200);
			  } 
			  else {
					pixelObj.setBlue(100);
				}
			  
		  }
	  }
  }
  
  public void mirrorVerticalRightToLeft() {
	  
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width-1; col > width / 2; col--)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal(){
	  
	    Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    int height = pixels.length;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length / 2; row++)
	    {
	      for (int col = 0; col < width; col++)
	      {
	        topPixel = pixels[row][col];
	        botPixel = pixels[height - row - 1][col];
	        botPixel.setColor(topPixel.getColor());
	      }
	    } 
  }
	public void mirrorHorizontalBotToTop(){
		
		    Pixel[][] pixels = this.getPixels2D();
		    Pixel topPixel = null;
		    Pixel botPixel = null;
		    int height = pixels.length;
		    int width = pixels[0].length;
		    for (int row = pixels.length / 2; row < pixels.length; row++)
		    {
		      for (int col = 0; col < width; col++)
		      {
		        topPixel = pixels[row][col];
		        botPixel = pixels[height - row - 1][col];
		        botPixel.setColor(topPixel.getColor());
		      }
		   } 
	}

	public void mirrorDiagonal(){
		
		  Pixel[][] pixels = this.getPixels2D();
		  int cap;
		  
		  if (pixels.length>pixels[0].length) {
			cap = pixels[0].length;
		  } 
		  else {
			
			cap = pixels.length;
		  }
		 
		  
		  for(int r = 0;r < cap;r++){
			  
			  for(int c = 0;c < r;c++){
				  
				  pixels[c][r].setColor(pixels[r][c].getColor());
			  }
		  }
	}
	
	public void blur (int x, int y, int width, int height){
		Pixel[][] pixels = this.getPixels2D();
		  
		for(int r = y; r < height; r++){
			  
			for(int c = x; c < width; c++){
				  if(r > 0 && c > 0 && r < 479 && c < 639){
					  
					//2:06 done with this alg that changes color a little
					  
//					  int redavg = ((pixels[r][c].getRed() + pixels[r+1][c].getRed() + pixels[r][c+1].getRed()
//							  + pixels[r+1][c+1].getRed() + pixels[r-1][c].getRed() + pixels[r][c-1].getRed()
//							  + pixels[r-1][c-1].getRed() + pixels[r-1][c+1].getRed() + pixels[r+1][c-1].getRed())/9);
//					  
//					  int blueavg = ((pixels[r][c].getBlue() + pixels[r+1][c].getBlue() + pixels[r][c+1].getBlue()
//							  + pixels[r+1][c+1].getBlue() + pixels[r-1][c].getBlue() + pixels[r][c-1].getBlue()
//							  + pixels[r-1][c-1].getBlue() + pixels[r-1][c+1].getBlue() + pixels[r+1][c-1].getBlue())/9);
//					  
//					  int greenavg = ((pixels[r][c].getGreen() + pixels[r+1][c].getGreen() + pixels[r][c+1].getGreen()
//							  + pixels[r+1][c+1].getGreen() + pixels[r-1][c].getGreen() + pixels[r][c-1].getGreen()
//							  + pixels[r-1][c-1].getGreen() + pixels[r-1][c+1].getGreen() + pixels[r+1][c-1].getGreen())/9);
//					  
//					  pixels[r][c].setColor(new Color(redavg, blueavg, greenavg));
					  
					  int redavg = ((pixels[r][c].getRed() + pixels[r+1][c].getRed() + pixels[r][c+1].getRed()
							  + pixels[r+1][c+1].getRed())/4);
					  
					  int blueavg = ((pixels[r][c].getBlue() + pixels[r+1][c].getBlue() + pixels[r][c+1].getBlue()
							  + pixels[r+1][c+1].getBlue())/4);
					  
					  int greenavg = ((pixels[r][c].getGreen() + pixels[r+1][c].getGreen() + pixels[r][c+1].getGreen()
							  + pixels[r+1][c+1].getGreen())/4);
					  
					  pixels[r][c].setColor(new Color(redavg, blueavg, greenavg));
					  
//					  if((int)(2*Math.random()) == 1){
//						  pixels[r][c].setColor(new Color(pixels[r+1][c].getRed(), pixels[r+1][c].getBlue(), pixels[r+1][c].getGreen()));
//					  }
					  
					  
					  //2:06 done with this alg that changes color a little
					  
					  
				  }
				  
			}
		}
		
		
		
		
		
		for(int r = y; r < height; r++){
			  
			for(int c = x; c < width; c++){
				  if(r != 0 && c != 0 && r != 479 && c != 639){
					  
					  
					  int redavg = ((pixels[r][c].getRed() + pixels[r+1][c].getRed() + pixels[r][c+1].getRed()
							  + pixels[r+1][c+1].getRed())/4);
					  
					  int blueavg = ((pixels[r][c].getBlue() + pixels[r+1][c].getBlue() + pixels[r][c+1].getBlue()
							  + pixels[r+1][c+1].getBlue())/4);
					  
					  int greenavg = ((pixels[r][c].getGreen() + pixels[r+1][c].getGreen() + pixels[r][c+1].getGreen()
							  + pixels[r+1][c+1].getGreen())/4);
					  
					  pixels[r][c].setColor(new Color(redavg, blueavg, greenavg));
					  
				  }
				  
			}
		}
		
		for(int r = y; r < height; r++){
			  
			for(int c = x; c < width; c++){
				  if(r != 0 && c != 0 && r != 479 && c != 639){
					  
					  
					  int redavg = ((pixels[r][c].getRed() + pixels[r+1][c].getRed() + pixels[r][c+1].getRed()
							  + pixels[r+1][c+1].getRed())/4);
					  
					  int blueavg = ((pixels[r][c].getBlue() + pixels[r+1][c].getBlue() + pixels[r][c+1].getBlue()
							  + pixels[r+1][c+1].getBlue())/4);
					  
					  int greenavg = ((pixels[r][c].getGreen() + pixels[r+1][c].getGreen() + pixels[r][c+1].getGreen()
							  + pixels[r+1][c+1].getGreen())/4);
					  
					  pixels[r][c].setColor(new Color(redavg, blueavg, greenavg));
					  
				  }
				  
			}
		}
		
		for(int r = y; r < height; r++){
			  
			for(int c = x; c < width; c++){
				  if(r != 0 && c != 0 && r != 479 && c != 639){
					  
					  
					  int redavg = ((pixels[r][c].getRed() + pixels[r+1][c].getRed() + pixels[r][c+1].getRed()
							  + pixels[r+1][c+1].getRed())/4);
					  
					  int blueavg = ((pixels[r][c].getBlue() + pixels[r+1][c].getBlue() + pixels[r][c+1].getBlue()
							  + pixels[r+1][c+1].getBlue())/4);
					  
					  int greenavg = ((pixels[r][c].getGreen() + pixels[r+1][c].getGreen() + pixels[r][c+1].getGreen()
							  + pixels[r+1][c+1].getGreen())/4);
					  
					  pixels[r][c].setColor(new Color(redavg, blueavg, greenavg));
					  
				  }
				  
			}
		}
	}
	
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
