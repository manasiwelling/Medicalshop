import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Details extends JFrame implements ActionListener {
	JLabel l1;
	JButton b1, b2, b3, b4, b5, b6, bexit;

	public Details() {
		setBounds(180, 10, 1000, 700);
		setTitle("Details");
		// setSize(1000,700);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		l1 = new JLabel("Master Files");
		b1 = new JButton("Purchase Invoice Entry");
		b2 = new JButton("Bill");
		b3 = new JButton("Stock ");
		b4 = new JButton("Employee");
		b5 = new JButton("Whole saler");
		b6 = new JButton("Delete Product Entry");
		bexit = new JButton("Exit");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		bexit.addActionListener(this);

		getContentPane().add(l1);
		l1.setBounds(430, 30, 300, 30);
		Color c4 = new Color(255, 0, 128);
		l1.setForeground(c4);
		l1.setFont(new Font("serif", Font.BOLD, 30));

		getContentPane().add(b1);
		b1.setBounds(320, 100, 180, 30);
		b1.setMnemonic('P');

		getContentPane().add(b2);
		b2.setBounds(540, 100, 180, 30);
		b2.setMnemonic('B');

		getContentPane().add(b3);
		b3.setBounds(320, 220, 180, 30);
		b3.setMnemonic('S');
		getContentPane().add(b4);

		b4.setBounds(540, 220, 180, 30);
		getContentPane().add(b5);
		b4.setMnemonic('E');
		b5.setBounds(540, 160, 180, 30);
		getContentPane().add(b6);
		b5.setMnemonic('W');
		b6.setBounds(320, 160, 180, 30);
		b6.setMnemonic('D');
		bexit.setBounds(800, 520, 100, 40);
		getContentPane().add(bexit);
		bexit.setMnemonic('x');
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b4) {
			new Empnext();
		} else if (ae.getSource() == b3) {
			new Showstock();
		}

		else if (ae.getSource() == b6) {
			new Delprod();
		} else if (ae.getSource() == b1) {
			new whole();
		} else if (ae.getSource() == b5) {
			new Showwholesaler();
		} else if (ae.getSource() == b2) {
			new Billinfo();
		} else if (ae.getSource() == bexit) {
			new Bye();
		}

	}

	public static void main(String args[]) {
		new Details();
	}
}