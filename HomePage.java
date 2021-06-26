import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener

{
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel a;
	JLabel b;
	JLabel c;
	JLabel d;
	JLabel a1;
	JLabel a2;
	JLabel a3;
	JLabel a4;
	JButton Next;
	JButton Exit;

	public HomePage() {
		Container container = new Container();
		getContentPane();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(0);
		l1 = new JLabel("WELCOME TO WELLNESS MEDICAL STORE");
		l1.setBounds(80, 0, 900, 100);
		Color c1 = new Color(236, 0, 236);
		Color c4 = new Color(128, 0, 255);

		Font fn = new Font("Monotype Corsiva", Font.ITALIC, 40);
		l1.setForeground(c4);
		// hn.setFont(new Font("Times New Roman", 1, 50));
		l1.setFont(fn);
		container.add(l1);
		l2 = new JLabel("Prof.More Sir");
		l2.setBounds(600, 100, 600, 100);
		l2.setFont(new Font("Monotype Corsiva", 1, 25));
		l2.setForeground(Color.black);
		container.add(l2);
		l3 = new JLabel("");
		l3.setForeground(Color.darkGray);
		l3.setBounds(650, 130, 600, 100);
		l3.setFont(new Font("Arial", 1, 14));
		container.add(l3);
		l4 = new JLabel("DL.No.143780");
		l4.setForeground(Color.darkGray);
		l4.setBounds(650, 150, 600, 100);
		l4.setFont(new Font("Arial", 1, 14));
		container.add(l4);
		a = new JLabel("Particulars:");
		a.setForeground(Color.black);
		a.setBounds(80, 180, 600, 100);
		a.setFont(new Font("Georgia", 1, 25));
		container.add(a);
		b = new JLabel("1. Medicine");
		b.setForeground(Color.darkGray);
		b.setBounds(80, 210, 600, 100);
		b.setFont(new Font("Arial", 1, 16));
		container.add(b);
		c = new JLabel("2. LifeSavings & Onco Products");
		c.setForeground(Color.darkGray);
		c.setBounds(80, 233, 600, 100);
		c.setFont(new Font("Arial", 1, 16));
		container.add(c);
		d = new JLabel("3. 24 Hours Emergency Service");
		d.setForeground(Color.darkGray);
		d.setBounds(80, 256, 600, 100);
		d.setFont(new Font("Arial", 1, 16));
		container.add(d);
		a1 = new JLabel("Address :");
		a1.setForeground(Color.black);
		a1.setBounds(80, 415, 600, 100);
		a1.setFont(new Font("F.C. Road", 1, 20));
		container.add(a1);
		a2 = new JLabel("Shastri Nagar");
		a2.setForeground(Color.darkGray);
		a2.setBounds(80, 440, 600, 100);
		a2.setFont(new Font("Arial", 1, 14));
		container.add(a2);
		a3 = new JLabel("Pune");
		a3.setForeground(Color.darkGray);
		a3.setBounds(80, 460, 600, 100);
		a3.setFont(new Font("Arial", 1, 14));
		container.add(a3);
		a4 = new JLabel("Phone No:0241-2354534");
		a4.setForeground(Color.darkGray);
		a4.setBounds(80, 480, 600, 100);
		a4.setFont(new Font("Arial", 1, 14));
		container.add(a4);
		Next = new JButton("Next");
		Next.setBounds(650, 500, 100, 40);
		Next.setVisible(true);
		Next.setEnabled(true);
		Next.addActionListener(this);
		container.add(Next);
		Next.setMnemonic('N');
		Exit = new JButton("Exit");
		Exit.setBounds(750, 520, 100, 40);
		Exit.setVisible(true);
		Exit.setEnabled(true);
		Exit.addActionListener(this);
		container.add(Exit);
		Exit.setMnemonic('E');
		getContentPane().add(container);
		setBounds(180, 10, 1000, 700);
		// setSize(1000,700);
		setResizable(false);
		setTitle("Home Page");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Next) {
			new login();
		} else if (ae.getSource() == Exit)
			new Bye();
	}

	public static void main(String args[]) {
		HomePage homepage = new HomePage();
	}

}
