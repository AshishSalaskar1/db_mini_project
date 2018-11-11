import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;

public class Login {

	private JFrame frame;
	private JLabel lblHello;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private Connection con=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public Login() throws ClassNotFoundException {
		initialize();
		con = dbConnectionHelper.Connect();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClickMe = new JButton("Login");
		btnClickMe.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnClickMe.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				String query = "select * from users where username=? and password=?";
				try {
					PreparedStatement pt = con.prepareStatement(query);
					pt.setString(1, userNameTxt.getText().toLowerCase());
					pt.setString(2, passwordTxt.getText().toLowerCase());
					ResultSet rs = pt.executeQuery();
					int count = 0;
					while(rs.next()) {
						count++;
					}
					
					if(count>0) {
						JOptionPane.showMessageDialog(null,"Connection Succesful");
						frame.dispose();
						HomeFrame hf= new HomeFrame();
						hf.setVisible(true);
						rs.close();
						pt.close();
					}
					else {
						JOptionPane.showMessageDialog(null,"Wrong Login Credentials. Please try again !");
						userNameTxt.setText("");
						passwordTxt.setText("");
					}
					
				} catch (SQLException e) {
					System.out.println("Error in config pass");
					e.printStackTrace();
				}
				
				
			}
		});
		btnClickMe.setBounds(242, 307, 163, 51);
		frame.getContentPane().add(btnClickMe);
		
		lblHello = new JLabel("LOGIN");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setFont(new Font("Trebuchet MS", Font.BOLD, 60));
		lblHello.setBounds(219, 13, 206, 71);
		frame.getContentPane().add(lblHello);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(131, 146, 124, 44);
		frame.getContentPane().add(lblNewLabel);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		userNameTxt.setBounds(319, 154, 196, 38);
		frame.getContentPane().add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(141, 203, 136, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setEchoChar('*');
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		passwordTxt.setBounds(319, 219, 196, 38);
		frame.getContentPane().add(passwordTxt);
	}
}
