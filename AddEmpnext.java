import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;

 class AddEmpnext extends JFrame implements ActionListener
{   Connection cn;
    PreparedStatement pst;
    ResultSet rs; 
   // JScrollPane Scrp1;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7; 
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField ta;
     JButton b1;
     JButton b2;
    JButton b3,b4;     

     public AddEmpnext() 
    {   setVisible(true);
       setBounds(180, 10, 1000, 700); 
      //setSize(1000,800);
        setTitle("Add Employe");
        setResizable(false); 
        l1 = new JLabel("Employee Information");
        l2 = new JLabel(" Employee ID :");
        l3 = new JLabel("Employee Name :");
        l4 = new JLabel("Address :");
        l5 = new JLabel("Phone No :");
        l6 = new JLabel("Salary :");
        l7 = new JLabel("Date of Joining :");
        t1 = new JTextField();
        t2 = new JTextField();
        //Scrp1 = new JScrollPane();
        ta = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        b1 = new JButton("Add");
        b2 = new JButton("Refresh");
        b3 = new JButton("Exit");
        b4=new JButton("Back");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
     getContentPane().setLayout(null);
        
        getContentPane().add(l1);
        l1.setBounds(340, 20, 300, 50);
        Color c4=new Color(255,0,128);
        l1.setForeground(c4);
       l1.setFont(new Font("serif",Font.BOLD,30));
       
         getContentPane().add(l2);
        l2.setBounds(290, 90, 150, 20);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Times New Roman",Font.BOLD,20));		
	  
        getContentPane().add(l3);
        l3.setBounds(290, 130, 150, 20);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));		
	
        getContentPane().add(l4);
        l4.setBounds(290, 180, 150, 20);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Times New Roman",Font.BOLD,20));		
	 
       getContentPane().add(l5);
        l5.setBounds(290, 220, 150, 20);
        l5.setForeground(Color.black);
        l5.setFont(new Font("Times New Roman",Font.BOLD,20));		
	 
        getContentPane().add(l6);
        l6.setBounds(290, 270, 150, 25);
         l6.setForeground(Color.black);
        l6.setFont(new Font("Times New Roman",Font.BOLD,20));		
	
        getContentPane().add(l7);
        l7.setBounds(290, 310, 150, 25);
        l7.setForeground(Color.black);
        l7.setFont(new Font("Times New Roman",Font.BOLD,20));		
	
       getContentPane().add(t1);
        t1.setBounds(480, 90, 100, 20);
         t1.setEditable(false);
       getContentPane().add(t2);
        t2.setBounds(480, 130, 220, 20);

        //ta.setColumns(20);
        //ta.setRows(5);
        //Scrp1.setViewportView(ta);
      
        getContentPane().add(ta);
        ta.setBounds(480, 170, 200, 30);
       
        getContentPane().add(t3);
        t3.setBounds(480, 220, 220, 20);
        
        getContentPane().add(t4);
        t4.setBounds(480, 260, 120, 20);
        
       getContentPane().add(t5);
        t5.setBounds(480, 310, 120, 20);

         getContentPane().add(b1);
        b1.setBounds(300,390, 80, 23);
        b1.addActionListener(this);
        b1.setMnemonic('A');
        getContentPane().add(b2);
        b2.setBounds(420, 390, 80, 23);
        b2.addActionListener(this);
        b2.setMnemonic('R');
       getContentPane().add(b3);
        b3.setBounds(550, 390, 80, 23);
        b3.addActionListener(this);
       b3.setMnemonic('E');
       try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           cn=DriverManager.getConnection("jdbc:odbc:jdsn");
           pst=cn.prepareStatement("Select max(eid)+1 from emp");
      rs=pst.executeQuery();
      rs.next();
      t1.setText(rs.getString(1));
 
         }
       catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e);
       }
  
}       
   
public void actionPerformed(ActionEvent ae)
   {
    if(ae.getSource()==b1)
     {
      if(t1.getText().length()>0&&t2.getText().length()>0&&t3.getText().length()>0&&t4.getText().length()>0&&t5.getText().length()>0&&ta.getText().length()>0)

     {  
        try
      {    
       pst=cn.prepareStatement("Insert into emp values(?,?,?,?,?,?)");
        pst.setString(1,t1.getText());
        pst.setString(2,t2.getText());
        pst.setString(3,ta.getText());
        pst.setString(4,t3.getText());
        pst.setString(5,t4.getText());
        pst.setString(6,t5.getText());
       int i=pst.executeUpdate();
  
       if(i>0)
       JOptionPane.showMessageDialog(this,"Record Added Successfully");
     } 
    catch(Exception e)
    {
       JOptionPane.showMessageDialog(this,"Error:"+e);
     }

   }
     else
      {
       JOptionPane.showMessageDialog(this,"Please fill All the Entries");
      }
     }
    else
      if(ae.getSource()==b2)
     {
      try
     {
     pst=cn.prepareStatement("Select max(eid)+1 from emp");
      rs=pst.executeQuery();
      rs.next();
      t1.setText(rs.getString(1));
 
     t2.setText(" ");
      ta.setText(" ");
      t3.setText(" ");
      t4.setText(" ");
       t5.setText(" ");
      t1.requestFocus();
     }
      catch(Exception e)
     {
     JOptionPane.showMessageDialog(null,e);

    }}
    else
      if(ae.getSource()==b3)
       {
        new Details();
       }
}
public static void main(String args[])
   {
      
       new AddEmpnext();
                
    }
    
  
    
}
