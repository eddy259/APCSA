package JavaGameProject;

import java.util.*;

public class EnemySquares {
	
	//private EnemySquare[][] myAliens = new EnemySquare[3][3];
	private List<EnemySquare> enemylist = new ArrayList<EnemySquare>();
	
	public EnemySquares(){
//		for(int i = 0; i<3; i++){
//			for(int j = 0;j < 3; j++){
//				myAliens[i][j] = new EnemySquare(55 * i + 70, 75 * j + 30, 3);
//			}
//		}
		int count = 0;
		while(count < 50){
			enemylist.add(new EnemySquare((int)(Math.random() * 800),0,1));
			count++;
		}
	}
	
	
	public List<EnemySquare> getEnemylist(){
		return enemylist;
	}
	
	public void add(EnemySquare e){
		enemylist.add(e);
	}
	
	public int getSize(){
		return enemylist.size();
	}
	
	public void delete(int i){
		enemylist.get(i).setSpeed(0);
		enemylist.get(i).setPos(-100, -100);
		enemylist.remove(i);
	}
	
	public EnemySquare alienAt(int i){
		return enemylist.get(i);
	}
	
	
}
