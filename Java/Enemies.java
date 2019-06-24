import java.util.ArrayList;

public class Enemies {

	private ArrayList <Enemy> enemies = new ArrayList<Enemy>() ; //Enemy ArrayList
	static public int enemycount=0; //counts number of enemies deleted for score
	static public int enemytime=0; //time counter
	public int lastspawn=0; //set to enemy time when an enemy spawns
	private double spawningtime=50; //current minimum time to pass before a enemy spawns
	private final int randomspacing=10; // random amount of time added to fixed time for next spawn
	
	
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public int getEnemytime() {
		return enemytime;
	}
	public int getLastspawn() {
		return lastspawn;
	}
	public double getSpawningtime() {
		return spawningtime;
	}
	public int getRandomspacing() {
		return randomspacing;
	}
	public void updateEnemy() {
		
		
		if (enemytime>lastspawn+spawningtime+ Math.random()*10*randomspacing) {
			
			enemies.add(new Enemy());
			
		    lastspawn=enemytime;
		}
		if (enemies.size()>0 && enemies.get(0).getX()<0) {
			enemies.remove(enemies.get(0));
			enemycount++;
		}
		
		if (enemytime%100   ==0)randomSpeed();
		enemytime++;
		
	}
	public void updateSpawningTime() {
		if (spawningtime>25)spawningtime-=.02;
	}
	public void enemyReset() {
		enemies = new ArrayList<Enemy>() ;
		enemycount=0;
		enemytime=0;
		lastspawn=0;
		spawningtime=50;
	}
	
	public  void randomSpeed() {
		for(Enemy e:enemies) {
			e.speedChange();
		}
	}
}
