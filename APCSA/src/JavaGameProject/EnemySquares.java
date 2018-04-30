package JavaGameProject;

import java.util.*;

public class EnemySquares {
	
	private EnemySquare[][] myAliens = new EnemySquare[3][3];
	private List<EnemySquare> enemylist = new ArrayList<EnemySquare>();
	
	public EnemySquares(){
		for(int i = 0; i<3; i++){
			for(int j = 0;j < 3; j++){
				myAliens[i][j] = new EnemySquare(55 * i + 70, 75 * j + 30, 3);
			}
		}
	}
	
	public void delete(int row, int col){
		myAliens[row][col].setSpeed(0);
		myAliens[row][col].setPos(-100, -100);
	}
	
	public EnemySquare alienAt(int r, int c){
		return myAliens[r][c];
	}
	
	
}
