import java.awt.Color;
import java.util.Random;

public class Enemy {
 private int y;
 private int x;
 //private int dy;
 private int speed=5;

 private Color color;
 private TYPE type;

 
 public enum TYPE{
	 jumping,
	 sliding,
	 fast
	 
 }
 public Enemy() {
	 
	 setY(289); 
	 setColor(getRandomColor());
	 setX(1000);
	 speedChange();
	 speed=(int) (Math.random()*10 +5);
	 
 }
 
 public void speedChange() {
	 System.out.println("Changing");
	 double rand=Math.random();
	 if (rand>.66)setType(TYPE.sliding);
	 else if (rand>.33)setType(TYPE.jumping);
	 else setType(TYPE.fast);
	 speed=(int) (Math.random()*10 +5);
 }
public int getY() {
	return y;
}

public void setType(TYPE a) {
	type=a;
}


public Color getRandomColor() {
Random rand = new Random();
//float r = rand.nextFloat();
float g = rand.nextFloat();
float b = rand.nextFloat(); 
Color randomColor = new Color(1, g, b);
return randomColor;
}
public void setY(int y) {
	this.y = y;
}

public void move() {
	
//	if (type==TYPE.sliding)x-=speed;
//	if (type==TYPE.jumping) {
////		x-=5;
////		if (y>=289)dy=-4;
////		if (y<100)dy=4;
////		y+=dy;
//		x-=speed +1;
//	}
//	if (type==TYPE.fast)x-=speed +2;
	x-=speed;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public Color getColor() {
	return color;
}
public void setColor(Color color) {
	this.color = color;
}


}
