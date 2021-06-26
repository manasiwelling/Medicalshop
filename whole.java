import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
public class whole extends JFrame implements ActionListener
   { Connection cn;
    PreparedStatement pst;
    ResultSet rs;
     JButton b1;
    JButton b2,b3;
    //JScrollPane Scrp1;
    JTextField ta;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    
   public whole() 
       {setBounds(180, 10, 1000, 700);
        setVisible(true);
        //setSize(1000,800);
        setResizable(false);
        setTitle("Whole Saler");
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();
        l6 = new JLabel();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        //Scrp1 = new JScrollPane();
        ta = new JTextField();
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        l1.setText("WholeSaler Information");
        getContentPane().add(l1);
        l1.setBounds(370, 10, 350, 50);
        Color c4=new Color(255,0,128); 
       l1.setForeground(c4);
       l1.setFont(new Font("serif",Font.BOLD,30));  
        		
	
        l2.setText("ID:");
        getContentPane().add(l2);
        l2.setBounds(340, 90, 100, 14);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Times New Roman",Font.BOLD,20));		
	 
        l3.setText("Name: ");
        getContentPane().add(l3);
        l3.setBounds(340, 130, 100, 20);
         l3.setForeground(Color.black);
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));		
	
        l4.setText("Address:");
        getContentPane().add(l4);
        l4.setBounds(340, 180, 100, 20);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Times New Roman",Font.BOLD,20));		
	
        l5.setText("Phone No :");
        getContentPane().add(l5);
        l5.setBounds(340, 240, 100, 20);
        l5.setForeground(Color.black);
        l5.setFont(new Font("Times New Roman",Font.BOLD,20));		
	    
        l6.setText("D.L.No:");
        getContentPane().add(l6);
        l6.setBounds(350, 290, 100, 20);
        l6.setForeground(Color.black);
        l6.setFont(new Font("Times New Roman",Font.BOLD,20));		
	
        getContentPane().add(t1);
        t1.setBounds(520, 90, 200, 20);
        t1.setEditable(false);
        getContentPane().add(t2);
        t2.setBounds(520, 140, 200, 20);
        getContentPane().add(t3);
        t3.setBounds(520, 240, 200, 20);
        getContentPane().add(t4);
        t4.setBounds(520, 290, 200, 20);

       //ta.setColumns(20);
        //ta.setRows(5);
        //Scrp1.setViewportView(ta);

        getContentPane().add(ta);
        ta.setBounds(520, 180, 200, 30);

        b1.setText("Add");
        getContentPane().add(b1);
        b1.setBounds(340, 360, 80, 30);
         b1.addActionListener(this);
        b1.setMnemonic('A');

        b2.setText("Next");
        getContentPane().add(b2);
        b2.setBounds(470, 360, 80, 30);
        b2.addActionListener(this);
        b2.setMnemonic('N');
        
        b3.setText("Back");
        getContentPane().add(b3);
        b3.setBounds(600, 360, 80, 30);
        b3.addActionListener(this);
        b3.setMnemonic('B');

        try
         {
           
           cn=UtilDatabase.connect();
          
      pst=cn.prepareStatement("Select max(wid)+1 from wholesaler");
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
      if(t1.getText().length()>0&&t2.getText().length()>0&&t3.getText().length()>0&&t4.getText().length()>0&&ta.getText().length()>0)

     {  
        try
      {    
       pst=cn.prepareStatement("Insert into wholesaler values(?,?,?,?,?)");
        pst.setString(1,t1.getText());
        pst.setString(2,t2.getText());
        pst.setString(3,ta.getText());
        pst.setString(4,t3.getText());
        pst.setString(5,t4.getText());
       int i=pst.executeUpdate();
  
       if(i>0)
       {
JOptionPane.showMessageDialog(this,"Record Added Successfully");
      pst=cn.prepareStatement("Select max(wid)+1 from wholesaler");
      rs=pst.executeQuery();
      rs.next();
      t1.setText(rs.getString(1));
      t2.setText("");
      t3.setText("");
       t4.setText("");
      ta.setText("");  
      }     
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
       new Addnew();

   } 
   else
      if(ae.getSource()==b3)
        { 
         new Details();
        }
} 
    public static void main(String args[]) 
     {
                 
          new whole();
             
    }
    
    
    
}
