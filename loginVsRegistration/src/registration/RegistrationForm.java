package registration;
 
    import login.ConnectionManager;
    import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
    import java.sql.Statement;

	public class RegistrationForm {
		
		
         
		public void register()
		{
			
			
			JFrame f=new JFrame("Registration");
			
			JButton b=new JButton("Submit");
			b.setBounds(200,400,95,30); 
			
			
			final JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
			
			JLabel ldisp;
			
			ldisp=new JLabel();
			
			
			tf1=new JTextField();
		    tf1.setBounds(200,50, 150,20);
		    f.add(tf1);
		    
		    tf2=new JTextField();
		    tf2.setBounds(200,100, 150,20);
		    f.add(tf2);
		    
		    tf3=new JTextField();
		    tf3.setBounds(200,150, 150,20);
		    f.add(tf3);
		    
		    tf4=new JTextField();
		    tf4.setBounds(200,200, 150,20);
		    f.add(tf4);
		    
		    tf5=new JTextField();
		    tf5.setBounds(200,250, 150,20);
		    f.add(tf5);
		    
		    tf6=new JTextField();
		    tf6.setBounds(200,300, 150,20);
		    f.add(tf6);
		    
		    tf7=new JTextField();
		    tf7.setBounds(200,350, 150,20);
		    f.add(tf7);
		    
			JLabel l1,l2,l3,l4,l5,l6,l7;
		    l1=new JLabel("First Name:");
		    l1.setBounds(50,50, 100,30); 
		    f.add(l1);
		    
		    l2=new JLabel("Last Name:");
		    l2.setBounds(50,100, 100,30);
		    f.add(l2);
		    
		    l3=new JLabel("User Name:");
		    l3.setBounds(50,150, 100,30);
		    f.add(l3);
		    
		    l4=new JLabel("Password:");
		    l4.setBounds(50,200, 100,30); 
		    f.add(l4);
		    
		    l5=new JLabel("Retype Password:");
		    l5.setBounds(50,250, 150,30);
		    f.add(l5);
		    
		    l6=new JLabel("Mobile:");
		    l6.setBounds(50,300, 100,30);
		    f.add(l6);
		    
		    l7=new JLabel("email:");
		    l7.setBounds(50,350, 100,30);
		    f.add(l7);
		    
		    
		    f.add(b);
		    
		    b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){ 
		    		
		    		ldisp.setBounds(50,430, 350,20);
		    		f.add(ldisp);
		    		ldisp.setText("Registartion completed!!!"); 
		    		ConnectionManager cm1=new ConnectionManager();
		    		
		    		Statement statement;
		    		try {
		    			Connection c1=cm1.connection();
						statement = c1.createStatement();
		    			//System.out.println("hai");
		    			String fname = tf1.getText();
		    			String lname = tf2.getText();
		    			String uname = tf3.getText();
		    			String password =tf4.getText();
		    			String retype_pass = tf5.getText();
		    			String mobile = tf6.getText();
		    			String email = tf7.getText();
		    			
		    			statement.executeUpdate("INSERT INTO registration VALUES ('"+fname+"','"+lname+"','"+uname+"','"+password+"','"+retype_pass+"','"+mobile+"','"+email+"')");
		    		} catch (SQLException | ClassNotFoundException e1) {
		    			// TODO Auto-generated catch block
		    			System.out.println("Already registered");
		    			//e1.printStackTrace();
		    		}
		    		
		    	    
				        }  
				    });  
		    
			f.setSize(500,450);
			f.setLayout(null);
			f.setVisible(true);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

	}
