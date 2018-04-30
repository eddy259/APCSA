package Unit17;

public class Aliens {
	
	private Alien[][] myAliens = new Alien[3][3];
	
	public Aliens(){
		for(int i = 0; i<3; i++){
			for(int j = 0;j < 3; j++){
				myAliens[i][j] = new Alien(55 * i + 70, 75 * j + 30, 3);
			}
		}
	}
	
	public void delete(int row, int col){
		myAliens[row][col].setSpeed(0);
		myAliens[row][col].setPos(-100, -100);
	}
	
	public Alien alienAt(int r, int c){
		return myAliens[r][c];
	}
	
	
}
