import java.awt.event.KeyEvent;

public class Circle {
private double y;
private double yvel;
public final double grav=.3;
int key;


public Circle() {
	y=100;
	yvel=0;
}
public double getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}




public void jump() {
	yvel=-12;
	
}
public void move() {
	y+=yvel;
	yvel+=grav;
	if(key==0)yvel+=grav;                                          
	if (y>289) {
		yvel=0;
		y=289;
	}
	
	if (key == KeyEvent.VK_SPACE) {
		if (y==289)jump();
}
}

public void KeyPressed(KeyEvent e) {
 key = e.getKeyCode();
	
}
public void KeyReleased(KeyEvent e) {
	         key =0;
}
}
