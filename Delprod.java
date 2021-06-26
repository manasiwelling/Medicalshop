import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
 
class Delprod extends JFrame implements ActionListener
{   Connection cn;
    PreparedStatement pst;
    JButton b1;
    JButton b2;
    JLabel l1;
    JLabel l2;
    JTextField t1;
   
    
   public Delprod()
  {      setBounds(180, 10, 1000, 700);
        //setSize(1000,800);
        setVisible(true);
       setTitle("Delete Employe");
         setResizable(false);
         l1 = new JLabel();
        t1 = new JTextField();
        l2 = new JLabel();
        b1 = new JButton();
        b2 = new JButton();

     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
     

      /*    l1.setText("Delete Employee Details ");
        getContentPane().add(l1);
        l1.setBounds(390, 60, 170, 20);*/
        
       getContentPane().add(t1);
        t1.setBounds(320, 210, 320, 30);

        l2.setText("Enter  Product Name to Delete");
        getContentPane().add(l2);
        l2.setBounds(330, 150, 320, 30);
        l2.setForeground(Color.black);
	l2.setFont(new Font("Times New Roman",Font.BOLD,20));		
		
        b1.setText("Delete");
        getContentPane().add(b1);
        b1.setBounds(320, 290, 120, 30);
        b1.addActionListener(this);
        b1.setMnemonic('D'); 
        b2.setText("Back");
        getContentPane().add(b2);
        b2.setBounds(530, 290, 110, 30);
        b2.addActionListener(this); 
        b2.setMnemonic('B'); 
    try
         {
           
           cn=UtilDatabase.connect();
           
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
        if(t1.getText().trim().length()>0)
         {
          try
         {
           pst=cn.prepareStatement("Delete from prod where pname=?");
            pst.setString(1,t1.getText());
            int i=pst.executeUpdate();
            if(i>0)
              {JOptionPane.showMessageDialog(this,"Record is Successfully Deleted");
                t1.setText(" ");}
            else
            JOptionPane.showMessageDialog(this,"Record not found");         
           } 
       catch(Exception e)
       {
         JOptionPane.showMessageDialog(this,"Error:"+e);
       }
    }
    else
      {
        JOptionPane.showMessageDialog(this,"Please Enter Product Name");
      }
    }
     else
    if(ae.getSource()==b2)
     new Details();
   }


public static void main(String args[]) 
 
   {
         
               new Delprod();
                
    }
    
    
}
