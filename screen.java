import javax.swing.*;
import java.awt.event.*;

public class screen extends JFrame{

	public screen(){
		super("Learn By Repeating");

		WindowListener l = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};

		addWindowListener(l);

		ImageIcon img = new ImageIcon("chien.gif");
		JButton bouton = new JButton("Mon bouton",img);

		JPanel panneau = new JPanel();
		panneau.add(bouton);
		setContentPane(panneau);
		setSize(700,400);
		setVisible(true);
	}

	public static void main(String[] args){
		JFrame frame = new screen();
	}
}
