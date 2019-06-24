 import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame{


 public Frame () {
	 add(new Panel());
	  setSize(1000, 500);
      setResizable(false);
      
      setTitle("Circle");
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }  
 
 public static void main(String[] args) {

     
     
     
     EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
             
        	 Frame frame = new Frame();
             frame.setVisible(true);
             
         }
     });
 }
     
}

