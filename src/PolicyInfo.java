import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class PolicyInfo extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	static Connection conn;
	HomeFrame home = new HomeFrame();

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		conn = dbConnectionHelper.Connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolicyInfo frame = new PolicyInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PolicyInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPolicyno = new JLabel("Policy_No");
		lblPolicyno.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPolicyno.setBounds(74, 129, 172, 59);
		contentPane.add(lblPolicyno);
		
		JLabel lblPolicyno_1 = new JLabel("Pol_Name");
		lblPolicyno_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPolicyno_1.setBounds(416, 129, 172, 59);
		contentPane.add(lblPolicyno_1);
		
		JLabel lblPoltype = new JLabel("Pol_Type");
		lblPoltype.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPoltype.setBounds(712, 129, 172, 59);
		contentPane.add(lblPoltype);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf1.setBounds(63, 201, 116, 49);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf2.setColumns(10);
		tf2.setBounds(373, 201, 199, 49);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf3.setColumns(10);
		tf3.setBounds(699, 201, 142, 49);
		contentPane.add(tf3);
		
		JButton b1 = new JButton("");
		b1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\insertBtnFrame.png"));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int p_no = Integer.parseInt(tf1.getText());
				String pname = tf2.getText();
				String ptype = tf3.getText();
				try {
					String sql = "insert into policy values("+p_no+",'"+pname+"','"+ptype+"')";
					PreparedStatement st = conn.prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					rs.close();
					st.close();
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		b1.setBounds(389, 375, 199, 72);
		contentPane.add(b1);
		
		JButton b2 = new JButton("");
		b2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\homeBtn.png"));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(true);
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		b2.setBounds(897, 617, 75, 67);
		contentPane.add(b2);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\backButton.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertFrame ins = new InsertFrame();
				ins.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(34, 617, 69, 67);
		contentPane.add(btnBack);
	}
}
