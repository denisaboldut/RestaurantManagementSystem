package prezentarea;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import data.FileWriter;

public class OspatarView  extends JFrame{
	public JTable tabel1;
	public JTable tabelCopie;
	public DefaultTableModel tableModel = new DefaultTableModel();

	public DefaultTableModel tableModel1 = new DefaultTableModel();

	private JLabel l1=new JLabel("  Nr. comanda:");
	private JLabel l2=new JLabel("  Data:");
	private JLabel l3=new JLabel("  Nr. masa:");
	private JLabel l4=new JLabel("Alege produsele pentru comanda:");
	private JButton b1 = new JButton("Incarca comanda");
	private JButton b2 = new JButton("Generare bon fiscal");
	private JTextField t1=new JTextField();
	private JTextField t2=new JTextField();
	private JTextField t3=new JTextField();
	private AdministratorView rest=new AdministratorView();
	FileWriter f = new FileWriter();
	
	public OspatarView() {
		JPanel panelM = new JPanel();
		panelM.setLayout(new GridLayout(3,1));
	    
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(8,2));
		panel1.add(l1);
		panel1.add(t1);
		panel1.add(l2);
		panel1.add(t2);
		panel1.add(l3);
		panel1.add(t3);
		panel1.add(new JLabel());
		panel1.add(b1);
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(b2);
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(l4);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(1,1));

	
        copiazaTabelu(f.citesteItem());
    	tabelCopie = new JTable(tableModel);
		panel2.add(new JScrollPane(tabelCopie));
		tabelCopie.setBackground(Color.decode("#a3caff"));
		rest.incarcaProduse(f.citesteItem());
		
		JPanel panel3=new JPanel();
		panel3.setLayout(new GridLayout(1,1));
		tabel1 = new JTable(tableModel1);
		panel3.add(new JScrollPane(tabel1));
		incarcaComanda(" , , , , , , , , , , , , , , , , , , , , , , , , , , ");
		tabel1.setBackground(Color.decode("#BDCAF9"));
		tabel1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabel1.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabel1.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabel1.getColumnModel().getColumn(2).setPreferredWidth(30);
		tabel1.getColumnModel().getColumn(3).setPreferredWidth(328);
		
		l1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		l2.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		l3.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		t1.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t2.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t3.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t1.setBackground(Color.decode("#C6E0F7"));
		t2.setBackground(Color.decode("#C6E0F7"));
		t3.setBackground(Color.decode("#C6E0F7"));

		panelM.add(panel1);
		panelM.add(panel2);
		panelM.add(panel3);
		this.setContentPane(panelM);
		this.setTitle("Ospatar");
		this.setSize(500, 650);
		this.setLocation(490, 100);
		// this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void incarcaComanda(String s) {
		Vector<String> numeColoana = new Vector<String>();
		numeColoana.add("id");
		numeColoana.add("data");
		numeColoana.add("nr.masa");
		numeColoana.add("comanda");
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<Object> vector = new Vector<Object>();
		//this.tableModel= new DefaultTableModel();
		this.tableModel1.setDataVector(data, numeColoana);
		
		for (String val : s.split(",")) {
			Vector row = new Vector();
			row.add(val);
			// System.out.println(val+",");
			tableModel1.addRow(row);
		}
	}
	public void copiazaTabelu(String s) {
		Vector<String> numeColoana = new Vector<String>();
		numeColoana.add("denumire produse");
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<Object> vector = new Vector<Object>();
		//this.tableModel= new DefaultTableModel();
		this.tableModel.setDataVector(data, numeColoana);
		for (String val : s.split(",")) {
			Vector row = new Vector();
			row.add(val);
			// System.out.println(val+",");
			tableModel.addRow(row);
		}
	}


 public String getId(){
	 return t1.getText();
 }
 public String getData(){
	 return t2.getText();
 }
 public String getMasa(){
	 return t3.getText();
 }
 public void addListenerComanda(ActionListener c) {
	 b1.addActionListener(c);
 }
 public void addListenerBill(ActionListener c) {
	 b1.addActionListener(c);
 }
}
