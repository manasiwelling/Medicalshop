import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.io.*;
import java.util.*;
public class Bill extends JFrame implements ActionListener
    {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JLabel l1;
    JLabel l10;
    JLabel l11;
    JLabel l12,l13;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel l8;
    JLabel l9;
    JTextField t1;
    JTextField t10,t11,t13;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JTextField t7;
    JTextField t8;
    JTextField t9,td;
    JTable tb;
     Vector col=new Vector();
     Vector data=new Vector();
  

Connection cn;
PreparedStatement pst;
ResultSet rs;

    public Bill()
     {
       setBounds(180, 10, 1000, 700);
         setVisible(true);
       setTitle("Bill");
         //setResizable(false);
         col.add("Pname");
         col.add("quantity"); 
         col.add("rate"); 
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l6 = new JLabel();
        l5 = new JLabel();
        l7 = new JLabel();
        l8 = new JLabel();
        l9 = new JLabel();
        l10 = new JLabel();
        l11 = new JLabel();
        l12 = new JLabel();
        l13 = new JLabel();
       t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11 = new JTextField();
         t13 = new JTextField(); 
       td=new JTextField();        
       b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        l1.setText("BILL");
        getContentPane().add(l1);
        l1.setBounds(400,-8, 100, 100);
         Color c4=new Color(255,0,128);
    
        l1.setForeground(c4);
       l1.setFont(new Font("serif",Font.BOLD,20));  
       
        l2.setText(" Bill No :");
        getContentPane().add(l2);
        l2.setBounds(110, 90, 50, 20);

        l3.setText(" Patient Name:");
        getContentPane().add(l3);
        l3.setBounds(110, 140, 100, 20);

        l4.setText("Patient Add:");
        getContentPane().add(l4);
        l4.setBounds(110, 180, 100, 20);

        l6.setText(" Dr. Name:");
        getContentPane().add(l6);
        l6.setBounds(110, 220, 80, 20);

        l5.setText(" Dr.Add :");
        getContentPane().add(l5);
        l5.setBounds(110, 260, 100, 20);

        l7.setText("Batch No:");
        getContentPane().add(l7);
        l7.setBounds(110, 300, 100, 20);

        l8.setText("Product Name:");
        getContentPane().add(l8);
        l8.setBounds(440, 90, 100, 20);

        l9.setText("Quantity:");
        getContentPane().add(l9);
        l9.setBounds(440, 140, 70, 20);

        l10.setText(" Rate:");
        getContentPane().add(l10);
        l10.setBounds(440, 190, 90, 20);

        l11.setText(" MFG Date:");
        getContentPane().add(l11);
        l11.setBounds(440, 240, 60, 20);

        l12.setText(" Expiry Date :");
        getContentPane().add(l12);
        l12.setBounds(440, 290, 100, 20);
        
       l13.setText("Total Amount:");
        getContentPane().add(l13);
        l13.setBounds(700, 403, 100, 20);  

       getContentPane().add(t1);
        t1.setBounds(250, 90, 110, 20);
        t1.setEditable(false);
       
       getContentPane().add(t2);
        t2.setBounds(250, 180, 110, 20);
        
       getContentPane().add(t3);
        t3.setBounds(250, 220, 110, 20);
        
       getContentPane().add(t4);
        t4.setBounds(250, 260, 110, 20);
        
       getContentPane().add(t5);
        t5.setBounds(250, 300, 110, 20);
        t5.setEditable(false);
        getContentPane().add(t6);
        t6.setBounds(550, 90, 110, 20);
        
      getContentPane().add(t7);
        t7.setBounds(550, 140, 110, 20);
       getContentPane().add(t8);
        t8.setBounds(550, 190, 110, 20);
        getContentPane().add(t9);
        t8.setEditable(false);
        t9.setBounds(550, 240, 110, 20);
        getContentPane().add(t10);
        t9.setEditable(false);
       t10.setBounds(550, 290, 110, 20);
       t10.setEditable(false);
        
        getContentPane().add(t11);
        t11.setBounds(250, 140, 110, 20);
       
       getContentPane().add(t13);
        t13.setBounds(800, 403, 110, 30);
       t13.setFont(new Font("Arial",Font.BOLD,15));      
       t13.setText("0");
       t13.setEditable(false); 
       
        getContentPane().add(td);
        td.setBounds(720, 10, 120, 30);
        td.setEditable(false); 
 //date code       
Date d=new Date();
d.setYear(2011);
int y=d.getYear();
 long d1=d.getDate();
d.setMonth(3);
int m=d.getMonth();
String g1,g2;

if(d1<10)
g1="0"+d1;
else
g1=""+d1;

if(m<10)
g2="0"+m;
else
g2=""+m;

String date=g1+"/"+g2+"/"+y;       
 td.setText(date);      
  td.setFont(new Font("serif",Font.BOLD,20));      
        b1.setText("Fill");
        getContentPane().add(b1);
        b1.setBounds(170, 400, 70, 30);
       b1.addActionListener(this);
       b1.setMnemonic('F');
 
       b2.setText("Add");
        getContentPane().add(b2);
        b2.setBounds(310, 403, 70, 30);
        b2.addActionListener(this);
       b2.setMnemonic('A');
 
       b3.setText("Save");
        getContentPane().add(b3);
        b3.setBounds(450, 403, 80, 30);
        b3.addActionListener(this);
        b3.setMnemonic('S');

         b4.setText("Exit");
        getContentPane().add(b4);
        b4.setBounds(590, 403, 73, 30);
         b4.addActionListener(this); 
         b4.setMnemonic('E');

           tb=new JTable(data,col);     
         JScrollPane jsp=new JScrollPane(tb,20,30);
          getContentPane().add(jsp);
         //jsp.setBounds(700, 190, 200, 250);  
          jsp.setBounds(700, 90, 200, 250);     
    try
         {
          
           cn=UtilDatabase.connect();
          Statement st=cn.createStatement();
         }
       catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e);
       }
getbno();
   }


//To remove elements from Jtable
public void settable()
{
tb=new JTable(data,col);   
JScrollPane jsp=new JScrollPane(tb,20,30);
          getContentPane().add(jsp);
         jsp.setBounds(700, 90, 200, 250);
}


//to autoincrease the bill no
public void getbno()
{
try
{
pst=cn.prepareStatement("Select max(bno)+1 from bill");
rs=pst.executeQuery();
rs.next();
t1.setText(rs.getString(1));
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
}

}
//end of getbno


public void actionPerformed(ActionEvent ae)
   {
    if(ae.getSource()==b1)
     {  String stemp1,stemp2,stemp3,temp; 
        try
           { 
            if(t6.getText().trim().length()>0)
             {
               pst=cn.prepareStatement("Select pno,prate,mdate,edate from prod where pname=?");      
              pst.setString(1,t6.getText());
              rs=pst.executeQuery();
              
            if(rs.next())
                       {
                         t5.setText(rs.getString(1));
                          t8.setText(rs.getString(2));
                           String md=rs.getString(3);
                          String s1=md.substring(0,10);     
                          stemp1=s1.substring(0,4);
                          stemp2=s1.substring(5,7);
                          stemp3=s1.substring(8,10);  
                          temp=stemp3+"-"+stemp2+"-"+stemp1;
                        t9.setText(temp);
                         String ed=rs.getString(4);
                          String s2=ed.substring(0,10);     
                          stemp1=s2.substring(0,4);
                          stemp2=s2.substring(5,7);
                          stemp3=s2.substring(8,10);  
                          temp=stemp3+"-"+stemp2+"-"+stemp1;
                          t10.setText(temp);
                             
                        }
              else
                  JOptionPane.showMessageDialog(null,"Product is not Available");
}
else
JOptionPane.showMessageDialog(null,"Enter Product Name"); 
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
}
}
if(ae.getSource()==b2)
{

if(t1.getText().length()>0&&t11.getText().length()>0&&t2.getText().length()>0&&t3.getText().length()>0&&t4.getText().length()>0&&t5.getText().length()>0&&t6.getText().length()>0&&t7.getText().length()>0&&t8.getText().length()>0&&t9.getText().length()>0&&t10.getText().length()>0)
 {
  String mtr;int m1,m2,m3;
mtr=t10.getText();
m1=Integer.parseInt(mtr.substring(0,2));
m2=Integer.parseInt(mtr.substring(3,5));
m3=Integer.parseInt(mtr.substring(6,10));
String ptr;int p1,p2,p3;
ptr=td.getText();
p1=Integer.parseInt(ptr.substring(0,2));
p2=Integer.parseInt(ptr.substring(3,5));
p3=Integer.parseInt(ptr.substring(6,10));

if(m3<p3)
JOptionPane.showMessageDialog(null,"Product has been expired");
else
if(m3==p3)
   {
     if(m2<p2)
          JOptionPane.showMessageDialog(null,"Product has been expired");
      else
         if(m2==p2) 
       JOptionPane.showMessageDialog(null,"Product is very near to expiry do not sale it");
      else
       add();
    }
else
add();
}
else
JOptionPane.showMessageDialog(null,"Fill All the Entries");
}//end of button b2

if(ae.getSource()==b3)

{
try
{
if(t1.getText().length()>0&&t6.getText().length()>0&&td.getText().length()>0&&t13.getText().length()>0)
{
pst=cn.prepareStatement("Insert into bill values(?,?,?,?)");
int bno=Integer.parseInt(t1.getText());
pst.setInt(1,bno);
String s1,s2,s3,str,temp;
str=td.getText();
s1=str.substring(0,2);
s2=str.substring(3,5);
s3=str.substring(6,10);
temp=s2+"/"+s1+"/"+s3;
pst.setString(2,temp);

//pst.setString(2,td.getText());
pst.setString(3,t11.getText());
pst.setString(4,t13.getText());
int i=pst.executeUpdate();
if(i>0)
JOptionPane.showMessageDialog(null,"Bill is Saved!!!!");
data.removeAllElements();
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");
t13.setText("0");
pst=cn.prepareStatement("Select max(bno)+1 from bill");
rs=pst.executeQuery();
rs.next();
t1.setText(rs.getString(1));
t11.requestFocus();
settable();
}
else 
JOptionPane.showMessageDialog(null,"Fill All The Infomation");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
}
}//end of b3
else
if(ae.getSource()==b4)
{
new Details();
}
}// end of method actionPerformed   
    
public void add()
{
try
{
//to check available stock
pst=cn.prepareStatement("Select pqua from prod where pname=?");
pst.setString(1,t6.getText());
rs=pst.executeQuery();
rs.next();
int cqua=rs.getInt(1);
String a=t7.getText();
int aqua=Integer.parseInt(a);
if(aqua>cqua)
{
JOptionPane.showMessageDialog(null,"Only "+cqua+"  items are remaining");
}
else
{
//to update stock
pst=cn.prepareStatement("Update prod set pqua=? where pname=?");
pst.setInt(1,cqua-aqua);
pst.setString(2,t6.getText());
pst.executeUpdate();

//to insert valuesin billdetails table
pst=cn.prepareStatement("Select max(ID) from billdetails");
rs=pst.executeQuery();
rs.next();
int id=rs.getInt(1);

pst=cn.prepareStatement("Insert into billdetails values(?,?,?,?,?,?,?,?,?,?,?)");
int bno=Integer.parseInt(t1.getText());
pst.setInt(1,id+1);
pst.setInt(2,bno);
pst.setString(3,t11.getText());
pst.setString(4,t2.getText());
pst.setString(5,t3.getText());
pst.setString(6,t4.getText());
pst.setString(7,t6.getText());
pst.setString(8,t7.getText());
pst.setString(9,t8.getText());
String s1,s2,s3,str,temp;
str=t9.getText();
s1=str.substring(0,2);
s2=str.substring(3,5);
s3=str.substring(6,10);
temp=s2+"/"+s1+"/"+s3;
pst.setString(10,temp);
str=t10.getText();
s1=str.substring(0,2);
s2=str.substring(3,5);
s3=str.substring(6,10);
temp=s2+"/"+s1+"/"+s3;
pst.setString(11,temp);
pst.executeUpdate();


//to add values in JTable
Vector row=new Vector();
row.add(t6.getText());
row.add(t7.getText());
row.add(t8.getText());
data.add(row);
tb.updateUI();

//to calculate total amount
int rate=Integer.parseInt(t8.getText());
int amt=Integer.parseInt(t13.getText());
int total=amt+aqua*rate;
t13.setText(""+total);

//to make field blank for another product
t5.setText(" ");
t6.setText(" ");
t7.setText(" ");
t8.setText(" ");
t9.setText(" ");
t10.setText(" ");


}
}//end of try
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
}
}

public static void main(String args[])
{
new Bill();
}
}
