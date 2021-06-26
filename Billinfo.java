import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
 public class Billinfo extends JFrame implements ActionListener
{
    JButton b1;
    JButton b2;
    JButton b3,b4;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4; 
    
    public Billinfo()
     { 
      setBounds(180, 10, 1000, 700);
      //setSize(1000,800);
       setVisible(true);        
        setResizable(false);
       setTitle("Bill Information"); 
       b1 = new JButton("Bill");
        b2 = new JButton("Show");
       // b3 = new JButton("Show");
        l1 = new JLabel(" Bill Information");
        l2= new JLabel("Create a New Bill :");
         l3 = new JLabel("Show Bill Record:");
        //l4= new JLabel("Employee Information:");
         b4=new JButton("Back");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);


        getContentPane().add(b1);
        b1.setBounds(470, 140, 100, 30);
        b1.addActionListener(this);
        b1.setMnemonic('B');

        getContentPane().add(b2);
        b2.setBounds(470, 203, 100, 30);
        b2.addActionListener(this); 
         b2.setMnemonic('S');
      
       /*getContentPane().add(b3);
        b3.setBounds(470, 260, 100, 30);
       b3.addActionListener(this); */
      
      b4.setBounds(600, 370, 100, 40);
       b4.addActionListener(this); 
        getContentPane().add(b4);
        b4.setMnemonic('k');
      getContentPane().add(l1);
      l1.setBounds(250, 30, 350, 50);
        Color c4=new Color(255,0,128);
       l1.setForeground(c4);
       l1.setFont(new Font("serif",Font.BOLD,30));  
       
        getContentPane().add(l2);
        l2.setBounds(200, 140, 250, 30);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Times New Roman",Font.BOLD,20));		
		
       
        getContentPane().add(l3);
        l3.setBounds(200, 200, 230, 30);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));		
		
        /*getContentPane().add(l4);
        l4.setBounds(200, 260, 230, 30);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Times New Roman",Font.BOLD,20));	*/	
		
        }

  public void actionPerformed(ActionEvent ae)
   { 
     if(ae.getSource()==b1)
      {
        new Bill();
      }
     else
     if(ae.getSource()==b2)
      {
        new Showbill1();        
      }
     else
     
     if(ae.getSource()==b4) 
    {
     new Details();
    }
}

  public static void main(String args[]) 
    {
       
     new Billinfo();
                 
    }
  } 
    
      

