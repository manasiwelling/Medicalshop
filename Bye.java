import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;

class Bye extends JFrame implements ActionListener {
	Font fn, ft;
	// String msg;
	JLabel l1;
	// JLabel l2,l3;
	Color c1, c2, c3, c4;
	JButton b1;

	Bye() {
		c4 = new Color(128, 128, 255);
		JFrame f = new JFrame();
		Container c = new Container();
		f.getContentPane();
		f.setLayout(new BorderLayout());
		c.setBackground(Color.green);
		f.setLocation(200, 100);
		f.setTitle("Exit");

		f.setDefaultCloseOperation(f.DO_NOTHING_ON_CLOSE);
		f.setAlwaysOnTop(true);
		f.setFocusable(true);

		fn = new Font("Monotype Corsiva", Font.ITALIC, 70);
		ft = new Font("Georgia", Font.BOLD + Font.ITALIC, 18);

		c1 = new Color(255, 100, 100);
		c2 = new Color(100, 100, 255);
		c3 = new Color(50, 200, 100);
		c4 = new Color(128, 0, 255);

		l1 = new JLabel("Good Bye.....");
		l1.setBounds(100, 80, 300, 100);
		c.add(l1);
		l1.setFont(fn);
		l1.setForeground(c4);

		b1 = new JButton("OK");
		b1.setBounds(170, 200, 80, 40);
		b1.setMnemonic('O');
		c.add(b1);

		b1.setFont(ft);
		b1.setForeground(c3);
		b1.addActionListener(this);

		f.getContentPane().add(c);
		f.setBounds(400, 200, 450, 350);
		f.setResizable(false);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("OK")) {
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		new Bye();
	}

}
