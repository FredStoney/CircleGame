import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {

	Rectangle playButton= new Rectangle(350,175,300,75);
	Rectangle quitButton= new Rectangle(350,275,300,75);
	int highscore = 0;
	public void draw(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fill(playButton);
		g2d.fill(quitButton);
		g2d.setColor(Color.white);
		Font fnt0=new Font("arial", Font.BOLD,50);
		g2d.setFont(fnt0);
		g2d.drawString("Play", 450, 225);
		g2d.drawString("Quit", 450, 325);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Score: " + String.valueOf(Enemies.enemycount), 400, 120);
		if (Enemies.enemycount>highscore)highscore=Enemies.enemycount;
		g2d.drawString("Highscore: "+ String.valueOf(highscore), 400, 60);
		
	}
}
