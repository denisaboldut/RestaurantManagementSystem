package prezentarea;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class AdministratorView extends JFrame {

	public JTable tabel;
	public DefaultTableModel tableModel = new DefaultTableModel();
	private JButton buton1 = new JButton("Salvare editare");
	private JButton buton2 = new JButton("Stergere selectat");
	private JButton buton3 = new JButton("Adauga");
	private JLabel l1 = new JLabel(" Adaugare produs", SwingConstants.RIGHT);
	private JLabel l2 = new JLabel("Denumire:", SwingConstants.CENTER);
	private JTextField t1 = new JTextField();

	public AdministratorView() {
		JPanel panelM = new JPanel();

		JPanel panel1 = new JPanel();
		// panelM.add(new JLabel("Vizualizare produse din meniu"));
		panelM.setLayout(new GridLayout(2, 1));
		panel1.setLayout(new GridLayout(1, 1));
		// incarcaProduse("branza,suc");
		tabel = new JTable(tableModel);
		panel1.add(new JScrollPane(tabel));
		tabel.setBackground(Color.decode("#ABEEB5"));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5, 2));
		panel2.add(buton1);
		panel2.add(buton2);
		panel2.add(new JLabel());
		panel2.add(new JLabel());
		panel2.add(l1);
		panel2.add(new JLabel());

		panel2.add(l2);
		panel2.add(t1);
		panel2.add(new JLabel());
		panel2.add(buton3);
		
		l1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 25));
		l2.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		t1.setFont(new Font("Sitka Banner", Font.PLAIN, 25));
		t1.setBackground(Color.decode("#C6F7CE"));

		panelM.add(panel1);
		panelM.add(panel2);
		this.setContentPane(panelM);
		this.setTitle("Administrator");
		this.setSize(400, 600);
		this.setLocation(100, 150);
		// this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showError(String mesajEroare) {
		JOptionPane.showMessageDialog(this, mesajEroare);
	}

	public void incarcaProduse(String s) {
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

		// this.tableModel.setDataVector(data, numeColoana);

	}
	public void addListenerAdaugareProdus(ActionListener c) {
		buton3.addActionListener(c);
	}
	public String iaProdusulNou() {
		return t1.getText();
	}
	public void addListenerEditare(ActionListener c) {
		buton1.addActionListener(c);
	}
	public void addListenerStergere(ActionListener c) {
		buton2.addActionListener(c);
	}
}
