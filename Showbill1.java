import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Showbill1 extends JFrame implements ActionListener
{
	JLabel hn,hn1,ser,plz;
	JButton b1,b3;
	JTextField txt;
	JTextArea ta;
	String str,q,s1;
	public Showbill1()
	{
		
		Container cont=new Container();
		getContentPane();
		setTitle("Bill Details");   
	  	this.setFocusable(true);
	
	
	  	b1=new JButton("Show");
	  	b1.setBounds(700,165,100,30);
	  	b1.setVisible(true);
	  	b1.setEnabled(true);
	  	b1.addActionListener(this);
	  	cont.add(b1);
	  	b1.setMnemonic('S');
	  	
	  	
	  	b3=new JButton("Back");
	  	b3.setBounds(490,480,100,30);
	  	b3.setVisible(true);
	  	b3.setEnabled(true);
	  	b3.addActionListener(this);
	  	cont.add(b3);
	  	b3.setMnemonic('B');	  	
   	    
	   	     
		plz = new JLabel("Enter Patient Name to see Bill details :");
		plz.setBounds(45,130,600,100);
		plz.setForeground(Color.darkGray);
		plz.setFont(new Font("Georgia",Font.BOLD,18));		
		cont.add(plz);
		
			
		//Textfield
	  
	  	txt = new JTextField(20);
	  	txt.setBounds(400,170,150,25);
	  	cont.add(txt);
		txt.requestFocus();
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
                                    JOptionPane.showMessageDialog(null,"Please Enter Patient Name");
                                }
			else if(ae.getActionCommand().equals("Back"))
				{
				     new Details();
				}
						
         }	
         
     
    public void display()
		{
			 
			try
				{
				  Connection  conn = UtilDatabase.connect();
				
					q = "select bno,bdate,ptname,tamt from bill where ptname=?";
					PreparedStatement st=conn.prepareStatement(q);
					st.setString(1,txt.getText());
					ResultSet rs = st.executeQuery();
					//if(!rs.next())
					//{
                                         //JOptionPane.showMessageDialog(null,"Record not Found");
                                         //}
                                       //else{

                                       ta.setText("");				ta.append("  Bill no                     Bill Date                                     Patient Name                                Total Amount     \n");  
		            ta.append("------------------------------------------------------------------------------------------------------------------------------------------\n");    					
				   	while(rs.next())
						{
							String pid=rs.getString(1);
						
				            String lnm=rs.getString(2);
				            String s1=lnm.substring(0,10);     
                                             String fnm=rs.getString(3);
							String mnm=rs.getString(4);
				                        
                                                         //String ed=rs.getString(7);
                                                       //String s2=ed.substring(0,10);      
                                                       
                                                        String stemp11=s1.substring(0,4);
                                                       String stemp22=s1.substring(5,7);
                                                       String stemp33=s1.substring(8,10);  
                                                       String temp1=stemp33+"-"+stemp22+"-"+stemp11;
 

   
                                                       ta.append("  " +pid+"                         ");
							ta.append(temp1+"                                  ");
							ta.append(fnm+"                                                 ");
							ta.append(mnm+"          ");  
							/*ta.append(esal+"            ");
                                                        ta.append(s1+"          ");
                                                         ta.append(s2+"             ");
                                                         ta.append(w+"      ");*/
                                                         ta.append("\n");
						}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
    
	
	public static void main(String args[])
	{
		 new Showbill1();
	}	
	
	}
	
				