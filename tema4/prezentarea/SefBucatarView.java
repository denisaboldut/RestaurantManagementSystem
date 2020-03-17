package prezentarea;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class SefBucatarView extends JFrame implements Observer{
    JLabel l1 = new JLabel(" Comenzile in asteptare:");
    TextArea text = new TextArea("");

	
    public SefBucatarView() {
    	ImageIcon img = new ImageIcon("ef.jpg");
		JLabel l = new JLabel(img);
		
		JPanel panelM= new JPanel();
		panelM.setLayout(new GridLayout(2,1));
		JPanel panel1= new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		panel1.add(l);
		panel1.add(l1);
		l1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 25));
		
		panelM.add(panel1);
		panelM.add(text);
		l1.setBackground(Color.decode("#F7DDC6"));
		l1.setOpaque(true);
		text.setBackground(Color.decode("#F7DDC6"));
		text.setFont(new Font("Sitka Banner", 0 , 12));
		
		
		this.setContentPane(panelM);
		this.setTitle("Sef bucatar");
		this.setSize(500, 370);
		this.setLocation(1000, 150);
		// this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		//text.setText((String)arg1);
		
		text.append((String)arg1+"\n");
		//System.out.println("Avem o comanda noua "+(String)arg1);
	}
	
	

}
