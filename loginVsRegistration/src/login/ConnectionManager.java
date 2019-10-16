package login;

    import java.sql.DriverManager;
	import java.sql.Connection;
	import java.sql.SQLException;
	import java.sql.Statement;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

import registration.RegistrationForm;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class ConnectionManager {
		
		public Connection connection()  throws SQLException,ClassNotFoundException {

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook","root","");  
			 
			return con;	
			
		}

		public static void main(String[] args) {
			
			
		
			//System.out.println("hai");
			
			
	        JFrame f=new JFrame("Login");
	        //f.setBackground(Color.blue);
			JButton b=new JButton("Login");
			b.setBounds(200,150,95,30); 
			JButton b1=new JButton("Create new account.");
			b1.setBounds(200,250,95,30); 
			f.add(b1);
			 JLabel l = new JLabel("Registration Form ");  
			 l.setBounds(100,15, 150,30);
			 f.add(l);
		        l.setForeground(Color.blue); 
			final JTextField tf1,tf2;
			tf1=new JTextField();
		    tf1.setBounds(200,50, 150,20);
		    f.add(tf1);
		    
		    tf2=new JTextField();
		    tf2.setBounds(200,100, 150,20);
		    f.add(tf2);
		    
		    JLabel l1,l2;
		    l1=new JLabel("User Name:");
		    l1.setBounds(50,50, 100,30); 
		    f.add(l1);
		    
		    l2=new JLabel("Password:");
		    l2.setBounds(50,100, 100,30);
		    f.add(l2);
		    f.add(b);
			
			
		    b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){ 
			Statement statement;
			ConnectionManager cm=new ConnectionManager();
			
			try {
				Connection c=cm.connection();
				statement = c.createStatement();
				String username = tf1.getText();
				String password = tf2.getText();
				statement.execute("select UNAME,PASS FROM registration where UNAME='"+username+"' and PASS='"+password+"'");
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("user not registered!!!");
				//e1.printStackTrace();
			}
			
		    	}
		    });
		    b1.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
		    		RegistrationForm rf = new RegistrationForm();
		    		rf.register();
		    		
		    	}
		    		
		    	});
		    
		    f.setSize(500,450);
			f.setLayout(null);
			f.setVisible(true);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	}
