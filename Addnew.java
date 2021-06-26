import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
 

public class Addnew extends JFrame implements ActionListener
     {
     Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
   JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
   JLabel l5;
    JLabel l6;
   JLabel l7;
    JLabel l8;
   JLabel l9;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
   JTextField t7;
    JTextField t8;
     
   public Addnew() {
          setBounds(180, 10, 1000, 700);
         //setSize(1000,800);
        setVisible(true);
       setTitle("Add Product");
         setResizable(false);
        l1 = new JLabel();
        l2 = new JLabel();
        t1 = new JTextField();
        l3 = new JLabel();
        t2 = new JTextField();
        l4 = new JLabel();
        t3 = new JTextField();
        l5 = new JLabel();
        t4 = new JTextField();
        l6 = new JLabel();
        t5 = new JTextField();
        l7 = new JLabel();
        t6 = new JTextField();
        l8 = new JLabel();
        t7 = new JTextField();
        l9 = new JLabel();
        t8 = new JTextField();
        b1 = new JButton("Add");
        b2 = new JButton("Refresh");
        b3 = new JButton("Back");
        b4 = new JButton("Exit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        l1.setText("Product Information");
        getContentPane().add(l1);
        
       l1.setBounds(230, 40, 300, 50);
        Color c4=new Color(255,0,128);
    
       l1.setForeground(c4);
       l1.setFont(new Font("serif",Font.BOLD,30));
       
        

        l2.setText("Batch No.:");
        getContentPane().add(l2);
        l2.setBounds(180, 150, 120, 20);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Times New Roman",Font.BOLD,20));
    
        getContentPane().add(t1);
        t1.setBounds(360, 140, 200, 30);
        t1.setEditable(false);
        l3.setText("Prod Name:");
        getContentPane().add(l3);
        l3.setBounds(180, 190, 120, 20);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));
        
       getContentPane().add(t2);
        t2.setBounds(360, 190,200,30);

        l4.setText("Quantity:");
        getContentPane().add(l4);
        l4.setBounds(180, 250, 120, 25);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Times New Roman",Font.BOLD,20));
         
        
      getContentPane().add(t3);
        t3.setBounds(360, 240, 200, 30);

         l5.setText("Rate:");
        getContentPane().add(l5);
         l5.setBounds(180, 294, 150, 20);
         l5.setForeground(Color.black);
        l5.setFont(new Font("Times New Roman",Font.BOLD,20));
         
        getContentPane().add(t4);
       t4.setBounds(360, 290, 200, 30);
          
        l6.setText("Purchase Rate:");
        getContentPane().add(l6);
        l6.setBounds(180,340, 200,20);
        l6.setForeground(Color.black);
        l6.setFont(new Font("Times New Roman",Font.BOLD,20));
        

        getContentPane().add(t5);
        t5.setBounds(360, 340, 200, 30);

        l7.setText("Expiry Date: ");
        getContentPane().add(l7);
        l7.setBounds(180, 440, 120, 20);
        l7.setForeground(Color.black);
        l7.setFont(new Font("Times New Roman",Font.BOLD,20));
         
        getContentPane().add(t6);
        t6.setBounds(360, 390, 200, 30);

       l8.setText("MFG.Date:");
        getContentPane().add(l8);
        l8.setBounds(180, 400, 120, 20);
         l8.setForeground(Color.black);
        l8.setFont(new Font("Times New Roman",Font.BOLD,20));
       
        getContentPane().add(t7);
        t7.setBounds(360, 440, 200, 30);

        l9.setText("Wholesaler Name:");
        getContentPane().add(l9);
        l9.setBounds(180, 490, 160, 14);
          l9.setForeground(Color.black);
        l9.setFont(new Font("Times New Roman",Font.BOLD,20));
         
        getContentPane().add(t8);
        t8.setBounds(360, 490, 200, 30);

         
        getContentPane().add(b1);
       b1.setBounds(230, 550, 85, 30);
       b1.addActionListener(this);
       b1.setMnemonic('A');
  
        getContentPane().add(b2);
        b2.setBounds(400, 550, 85, 30);
        b2.addActionListener(this);
        b2.setMnemonic('R');
   
       
        getContentPane().add(b3);
        b3.setBounds(230, 600, 85, 30);
          b3.addActionListener(this);
        b3.setMnemonic('B');

        getContentPane().add(b4);
       b4.setBounds(400, 600, 85, 30);
        b4.addActionListener(this);
       b4.setMnemonic('E');
 
try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           cn=DriverManager.getConnection("jdbc:odbc:jdsn");
            pst=cn.prepareStatement("Select max(pno)+1 from prod");
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
      if(t1.getText().length()>0&&t2.getText().length()>0&&t3.getText().length()>0&&t4.getText().length()>0&&t5.getText().length()>0&&t6.getText().length()>0&&t7.getText().length()>0&&t8.getText().length()>0)

     {  
        try
      {    pst=cn.prepareStatement("Select * from wholesaler where wname=?");
           pst.setString(1,t8.getText());
           ResultSet rs= pst.executeQuery();
           if(rs.next())
            {//start



        pst=cn.prepareStatement("Insert into prod values(?,?,?,?,?,?,?,?)");
        
        pst.setInt(1,Integer.parseInt(t1.getText()) );
        pst.setString(2,t2.getText());
         pst.setInt(3,Integer.parseInt(t3.getText()) );	
         	pst.setInt(4,Integer.parseInt(t4.getText()) );
         	pst.setInt(5,Integer.parseInt(t5.getText()) );
         	pst.setString(6,t6.getText());
         	pst.setString(7,t7.getText());
         	pst.setString(8,t8.getText());
         		
         			
         	
        	
        /*pst.setString(1,t1.getText());
       
        pst.setString(2,t2.getText());
        pst.setString(3,t3.getText());
        pst.setString(4,t4.getText());
        pst.setString(5,t5.getText());
       
        
        String s1,s2,s3,str,temp;
str=t6.getText();
s1=str.substring(0,2);
s2=str.substring(3,5);
s3=str.substring(6,10);
temp=s2+"/"+s1+"/"+s3;

   
     
        pst.setString(6,temp);
        
         //pst.setString(7,t7.getText());
        String s11,s22,s33,str1,temp1;
str1=t7.getText();
s11=str1.substring(0,2);
s22=str1.substring(3,5);
s33=str1.substring(6,10);
temp1=s22+"/"+s11+"/"+s33;
pst.setString(7,temp1);

 
       
       pst.setString(8,t8.getText());*/
      int i=pst.executeUpdate();
  
       if(i>0)
       JOptionPane.showMessageDialog(this,"Record Added Successfully");
     } //end
      else
     JOptionPane.showMessageDialog(this,"Please fill whole saler Details First");
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
     pst=cn.prepareStatement("Select max(pno)+1 from prod");
      rs=pst.executeQuery();
      rs.next();
      t1.setText(rs.getString(1));
       t2.setText(" ");
      t6.setText(" ");
      t3.setText(" ");
      t4.setText(" ");
       t5.setText(" ");
       t7.setText(" ");
        t8.setText(" ");
      t1.requestFocus();
     }
catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e);
       }
}

    else
      if(ae.getSource()==b3)
      {
        new whole();
      
      }
      else
      if(ae.getSource()==b4)
      {
        new Details();
      
      }
}

    public static void main(String args[]) 
          {
        
                new Addnew();
            }
       
    }


