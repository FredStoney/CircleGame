

import java.awt.event.MouseEvent;


import javax.swing.event.MouseInputListener;







public class MouseInput implements MouseInputListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int y=e.getY();
		int x=e.getX();
//		new Rectangle(350,175,300,75);
		//Rectangle quitButton= new Rectangle(350,275,300,75);
		if (x>350&&x<650) {
			if (y>175&&y<250) {
				Panel.state=Panel.STATE.Game;
			}
		}
		
		
		if (x>350&&x<650) {
			if (y>275&&y<350) {
				System.exit(0);
			}
		}
		
		if (x<300&&x>200) {
			if (y>150&&y<250) {
				
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
