import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;

public class login extends JFrame implements ActionListener {
	JButton b1;
	JButton b2;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JTextField t1;
	JPasswordField t2;
	Connection cn;
	Statement st;
	ResultSet rs;

	public login() {
		setBounds(180, 10, 1000, 700);
		setVisible(true);
		setSize(500, 500);
		setTitle("Login");
		l1 = new JLabel("Login");
		l2 = new JLabel("User Name:");
		t1 = new JTextField(20);
		l3 = new JLabel(" Password:");
		t2 = new JPasswordField(20);
		b1 = new JButton("Login");
		b2 = new JButton("Exit");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		getContentPane().add(l1);
		l1.setBounds(450, 10, 100, 100);
		Color c4 = new Color(255, 0, 128);
		l1.setForeground(c4);
		l1.setFont(new Font("serif", Font.BOLD, 30));

		getContentPane().add(l2);
		l2.setBounds(350, 100, 130, 30);
		l2.setForeground(Color.black);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		getContentPane().add(l3);
		l3.setBounds(350, 160, 130, 30);
		l3.setForeground(Color.black);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));

		getContentPane().add(t1);
		t1.setBounds(490, 100, 160, 30);

		getContentPane().add(t2);
		t2.setBounds(490, 160, 160, 30);

		getContentPane().add(b1);
		b1.setBounds(390, 243, 80, 30);
		b1.setMnemonic('L');

		getContentPane().add(b2);
		b2.setBounds(500, 240, 90, 30);
		b2.setMnemonic('E');
		b1.addActionListener(this);
		b2.addActionListener(this);
		try {

			cn = UtilDatabase.connect();
			st = cn.createStatement();
			JOptionPane.showMessageDialog(null, "Connected to database");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public void actionPerformed(ActionEvent ae)

	{
		try {
			if (ae.getSource() == b1) {
				if (t1.getText().trim().length() > 0) {

					if (t2.getText().trim().length() > 0) {
						rs = st.executeQuery("Select pwd from login where uname='" + t1.getText() + "'");
						if (rs.next()) {
							if (t2.getText().equals(rs.getString(1))) {

								new Details();
							}

							else {
								JOptionPane.showMessageDialog(null, "Invalid password");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Invalid User Name");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Enter Password");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Enter User Name");
				}
			} else if (ae.getSource() == b2) {
				new HomePage();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void main(String args[]) {
		new login();

	}

}
