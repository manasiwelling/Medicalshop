import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Showstock extends JFrame implements ActionListener
{
	JLabel hn,hn1,ser,plz,l;
	JButton b1,b3,b2;
	JTextField txt,t;
	JTextArea ta;
	String str,q;
	public Showstock()
	{
		
		Container cont=new Container();
		getContentPane();
		setTitle("Stock");   
	  	this.setFocusable(true);
	
	
	  	b1=new JButton("Show");
	  	b1.setBounds(700,165,100,30);
	  	b1.setVisible(true);
	  	b1.setEnabled(true);
	  	b1.addActionListener(this);
	  	cont.add(b1);
	  	b1.setMnemonic('S');   
                
                b2=new JButton("Check");
	  	b2.setBounds(700,120,100,30);
	  	b2.setVisible(true);
	  	b2.setEnabled(true);
	  	b2.addActionListener(this);
	  	cont.add(b2);
                b2.setMnemonic('C');
	  	
	  	
	  	b3=new JButton("Back");
	  	b3.setBounds(490,480,100,30);
	  	b3.setVisible(true);
	  	b3.setEnabled(true);
	  	b3.addActionListener(this);
	  	cont.add(b3);
	  	b3.setMnemonic('B');	  	
   	    
	   	     
		plz = new JLabel("Enter Product Name to check stock :");
		plz.setBounds(45,80,600,100);
		plz.setForeground(Color.darkGray);
		plz.setFont(new Font("Georgia",Font.BOLD,18));		
		cont.add(plz);
		
                l = new JLabel("Enter Product Name to check Details :");
		l.setBounds(45,130,600,100);
		l.setForeground(Color.darkGray);
		l.setFont(new Font("Georgia",Font.BOLD,18));		
		cont.add(l);
	
			
		

              //Textfield
	  
	  	txt = new JTextField(20);
	  	txt.setBounds(400,170,150,25);
	  	cont.add(txt);
		//txt.requestFocus();
		
                t = new JTextField(20);
	  	t.setBounds(400,120,150,25);
	  	cont.add(t);
		t.requestFocus();


               //TextArea
		
		ta = new JTextArea(100,50);
	  	ta.setBounds(50,250,920,200);
	  	ta.setEditable(false);
		ta.setFont(new Font("Times New Roman",Font.LAYOUT_LEFT_TO_RIGHT,20));		
		cont.add(ta);
		
		
		getContentPane().add(cont);
		setBounds(180, 10, 1000, 700);
               //setSize(1000,800);		
                 setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         }
		
public void actionPerformed(ActionEvent ae)
		{
		
			if(ae.getActionCommand().equals("Show"))
				{
                                  if(txt.getText().trim().length()>0)
					display();
				else
                                    JOptionPane.showMessageDialog(null,"Please Enter Product Name");
                                }
			else if(ae.getActionCommand().equals("Back"))
				{
				     new Details();
				}
						
                             
               if(ae.getActionCommand().equals("Check"))
           { 
                                  
if(t.getText().trim().length()>0)
   {
     try
	{
	String url;    	 
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	url="jdbc:odbc:jdsn";
	Connection conn=DriverManager.getConnection(url);

       PreparedStatement st=conn.prepareStatement("Select sum(pqua) from prod where pname=?");
      st.setString(1,t.getText());
      ResultSet rs = st.executeQuery();
     
        if(rs.next())
{

               ta.setText("");				
ta.append("     product Name                                            Stock\n");  
		            ta.append("-------------------------------------------------------------------------------------------------------------------\n");    					
				   	
    int pid=rs.getInt(1);
//int sum=Integer.parseInt(pid);
ta.append("     "+t.getText()+"                                                                 ");
ta.append(pid+"                 ");
							
}
else
JOptionPane.showMessageDialog(null,"Product not Available");
}
		catch(Exception e)
		{
			System.out.println(e);
		}}
     else
  JOptionPane.showMessageDialog(null,"Enter Product Name");	
}
    
	}	
         
     
    public void display()
		{
			 
			try
				{
					
					Connection conn=UtilDatabase.connect();
					q = "select pno,pname,pqua,prate,purrate,mdate,edate,wname from prod where pname=?";
					PreparedStatement st=conn.prepareStatement(q);
					st.setString(1,txt.getText());
					ResultSet rs = st.executeQuery();
					//if(!rs.next())
					//{
                                         //JOptionPane.showMessageDialog(null,"Record not Found");
                                         //}
                                       //else{

                                       ta.setText("");				ta.append("  Batch no        prodName        quatity     Rate     purchase Rate     MFG.Date       ExpiryDate       WholesalerName\n");  
		            ta.append("------------------------------------------------------------------------------------------------------------------------------------------\n");    					
				   	while(rs.next())
						{
							String pid=rs.getString(1);
						
				            String lnm=rs.getString(2);
				            String fnm=rs.getString(3);
							String mnm=rs.getString(4);
				                        String esal=rs.getString(5);
							
                                                       String md=rs.getString(6);
                                                      String s1=md.substring(0,10);     
                                                      
                                
                                                      String stemp1=s1.substring(0,4);
                                                      String stemp2=s1.substring(5,7);
                                                      String stemp3=s1.substring(8,10);  
                                                       String temp=stemp3+"-"+stemp2+"-"+stemp1;
                        
    

                                                       String ed=rs.getString(7);
                                                       String s2=ed.substring(0,10);      
                                                       
                                                        String stemp11=s2.substring(0,4);
                                                       String stemp22=s2.substring(5,7);
                                                       String stemp33=s2.substring(8,10);  
                                                       String temp1=stemp33+"-"+stemp22+"-"+stemp11;
                        

                                                       String w=rs.getString(8);
                                                           
                                                        ta.append("   "+pid+"                  ");
							ta.append(lnm+"                      ");
							ta.append(fnm+"               ");
							ta.append(mnm+"              ");
							ta.append(esal+"             ");
                                                        ta.append(temp+"      ");
                                                         ta.append(temp1+"     ");
                                                         ta.append(w+"      ");
                                                         ta.append("\n");
						}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}//end

	      
              }
    
	
	public static void main(String args[])
	{
		 new Showstock();
	}	
	
	}
	
				