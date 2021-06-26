import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Showemp extends JFrame implements ActionListener
{
	JLabel hn,hn1,ser,plz;
	JButton b1,b3;
	JTextField txt;
	JTextArea ta;
	String str,q;
	public Showemp()
	{
		
		Container cont=new Container();
		getContentPane();
		setTitle("Search");   
	  	this.setFocusable(true);
	
	
	  	b1=new JButton("Search");
	  	b1.setBounds(550,165,100,30);
	  	b1.setVisible(true);
	  	b1.setEnabled(true);
	  	b1.addActionListener(this);
	  	cont.add(b1);
	  	b1.setMnemonic('S');
	  	
	  	
	  	b3=new JButton("Exit");
	  	b3.setBounds(490,480,100,30);
	  	b3.setVisible(true);
	  	b3.setEnabled(true);
	  	b3.addActionListener(this);
	  	cont.add(b3);
	  	b3.setMnemonic('E');	  	
   	    
	   	     
		plz = new JLabel("Enter Emplyoe Name:");
		plz.setBounds(45,130,600,100);
		plz.setForeground(Color.darkGray);
		plz.setFont(new Font("Georgia",Font.BOLD,18));		
		cont.add(plz);
		
			
		//Textfield
	  
	  	txt = new JTextField(20);
	  	txt.setBounds(300,170,150,25);
	  	cont.add(txt);
		
		//TextArea
		
		ta = new JTextArea(100,50);
	  	ta.setBounds(50,250,800,200);
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
		
			if(ae.getActionCommand().equals("Search"))
				{
                                  if(txt.getText().trim().length()>0)
					display();
				else
                                    JOptionPane.showMessageDialog(null,"Please Enter Employe Name");
                                }
			else if(ae.getActionCommand().equals("Exit"))
				{
				     new Details();
				}
						
         }	
         
     
    public void display()
		{
			String str = txt.getText();
			char ch;
			for(int i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(Character.isDigit(ch))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Correct Surname","Eroor",JOptionPane.ERROR_MESSAGE);		
					txt.setText("");
					return;
				}
			} 
			try
				{
					String url;    	 
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					url="jdbc:odbc:jdsn";
					Connection conn=DriverManager.getConnection(url);
					q = "select eid,ename,eadd,eph,esal from emp where ename=?";
					PreparedStatement st=conn.prepareStatement(q);
					st.setString(1,txt.getText());
					ResultSet rs = st.executeQuery();
					//if(!rs.next())
					//{
                                         //JOptionPane.showMessageDialog(null,"Record not Found");
                                         //}
                                       //else{

                                       ta.setText("");
					ta.append("  Emp id                  Emp Name                 Emp Add                  ph.No.                Salary\n");  
		            ta.append("--------------------------------------------------------------------------------------------------------------------\n");    					
				   	while(rs.next())
						{
							String pid=rs.getString(1);
						
				            String lnm=rs.getString(2);
				            String fnm=rs.getString(3);
							String mnm=rs.getString(4);
				                        String esal=rs.getString(5);
							ta.append(pid+"                              ");
							ta.append(lnm+"                        ");
							ta.append(fnm+"                ");
							ta.append(mnm+"            ");
							ta.append(esal+"      ");
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
		Showemp f = new Showemp();
	}	
	
	}
	
				