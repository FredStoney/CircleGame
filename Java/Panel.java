import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
@SuppressWarnings("serial")

public class Panel extends JPanel implements ActionListener {
	
		private Circle circle; // Player Controlled circle
		Enemies enems = new Enemies(); // Enemies obj
		boolean newgame=true; //resets game to base state if true
		
		private Timer timer; // Timer to control playing speed
		private final int DELAY=10; // delay for timer 
	
		Menu menu=new Menu(); // menu object
		
		static public enum STATE { 
			Game,
			Menu
		}
		static public STATE state=STATE.Menu; 
		private int encount =0;
		
		
	@Override

	public void actionPerformed(ActionEvent arg0) {
		if (state==STATE.Game) {
			if (newgame) {
				newGame();
			newgame=false;
			}
		circle.move();
		repaint();
		checkIntersect(); 
		enems.updateEnemy();
		enems.updateSpawningTime();
		
		} 
		
	}
	
	public void checkIntersect() {
		Rectangle a= new Rectangle(100,(int) circle.getY(),40,40 );
		
		for (Enemy e : enems.getEnemies()) {
		e.move(); 
		Rectangle b= new Rectangle(e.getX(),e.getY(),40,40);
		if (a.intersects(b)) {
			System.out.println(Enemies.enemycount);
			newgame=true;
			state=STATE.Menu;
			
		}
		}
	}
	
	private void newGame() {
		
		circle=new Circle();
		enems.enemyReset();
		encount=0;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);         
		drawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	public Panel() {
		
		addKeyListener(new TAdapter());
		addMouseListener(new MouseInput());
		setFocusable(true);
		setBackground(Color.BLACK);
		circle = new Circle();
		timer = new Timer(DELAY, this);
        timer.start();
       
        
	}

	private void drawing(Graphics g) {
	if (state==STATE.Game) {
		this.setBackground(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 100);
		g2d.setFont(myFont);
		
		
		
		
		
		g2d.fillOval(100, (int) circle.getY(), 50, 50);
		g2d.setColor(Color.WHITE);
	g2d.drawString(String.valueOf(Enemies.enemycount), 50, 100);
		g2d.fillRect(0, 340, 1000, 10);
		
		for (Enemy e: enems.getEnemies()) {
			g2d.setColor(e.getColor());
		g2d.fillOval(e.getX(), e.getY(), 50, 50);
		}
	}
		if (state==STATE.Menu) {
			this.setBackground(Color.white);
			menu.draw(g);
		}
	}
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            circle.KeyReleased(e);
           if(state.equals(STATE.Menu)&&e.getKeyCode()==KeyEvent.VK_SPACE){
        	   state=STATE.Game;
        
        }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	 
    			 circle.KeyPressed(e);
    		 
            
        }
    }
	
	
	
	
	
}
