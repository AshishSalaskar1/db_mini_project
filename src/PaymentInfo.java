import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JComboBox;

@SuppressWarnings({ "serial", "unused" })
public class PaymentInfo extends JFrame {
	

	private JPanel contentPane;
	private JTextField tf1;
	JComboBox<Integer> cBox;
	private JTextField tf2;
	static Connection conn = null;
	HomeFrame home = new HomeFrame();
	private JTextField tf3;
	
	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentInfo frame = new PaymentInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public PaymentInfo() throws ClassNotFoundException {
		
		conn = dbConnectionHelper.Connect();
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPolicyno = new JLabel("Payment ID");
		lblPolicyno.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPolicyno.setBounds(63, 129, 172, 59);
		contentPane.add(lblPolicyno);
		
		JLabel lblPolicyno_1 = new JLabel("Policy No");
		lblPolicyno_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPolicyno_1.setBounds(273, 129, 172, 59);
		contentPane.add(lblPolicyno_1);
		
//		lblPolicyno.setForeground();
		
		JLabel lblPoltype = new JLabel("Tenure");
		lblPoltype.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPoltype.setBounds(467, 129, 172, 59);
		contentPane.add(lblPoltype);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf1.setBounds(63, 201, 116, 49);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf2.setColumns(10);
		tf2.setBounds(467, 201, 199, 49);
		contentPane.add(tf2);
		
		JButton b1 = new JButton("");
		b1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\insertBtnFrame.png"));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int id = Integer.parseInt(tf1.getText().toString());
				String tenure = tf2.getText().toString();
				int maxAmt = Integer.parseInt(tf3.getText().toString());
				try {
					String sql = "insert into payment(payment_id,policy_no,tenure,mat_amount) values(?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setInt(1, id);
					st.setInt(2, (int)cBox.getSelectedItem());
					st.setString(3,tenure);
					st.setInt(4,maxAmt);
					ResultSet rs = st.executeQuery();
					rs.close();
					st.close();
					tf1.setText("");
					tf2.setText("");
					tf2.setText("");
					JOptionPane.showMessageDialog(null,"Insertion Succesful");
					
				} catch (SQLException ex) {
					ex.printStackTrace();
				}}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		b1.setBounds(402, 512, 192, 66);
		contentPane.add(b1);
		
		JButton b2 = new JButton("");
		b2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\homeBtn.png"));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				home.setVisible(true);
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		b2.setBounds(908, 603, 74, 80);
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
		btnBack.setBounds(35, 603, 74, 80);
		contentPane.add(btnBack);
		
		JLabel lblInsertValuesInto = new JLabel("Insert Values into BRANCH Table");
		lblInsertValuesInto.setFont(new Font("Constantia", Font.BOLD, 30));
		lblInsertValuesInto.setBounds(250, 13, 588, 59);
		contentPane.add(lblInsertValuesInto);
		
		JLabel lblMatAmount = new JLabel("Mat Amount");
		lblMatAmount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMatAmount.setBounds(693, 129, 172, 59);
		contentPane.add(lblMatAmount);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf3.setColumns(10);
		tf3.setBounds(693, 201, 199, 49);
		contentPane.add(tf3);
		
	cBox = new JComboBox<Integer>();
		cBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cBox.setBounds(283, 204, 74, 43);
		contentPane.add(cBox);
		
		try {
			PreparedStatement pr = conn.prepareStatement("select policy_no from policy");
			ResultSet rs2 = pr.executeQuery();
			while(rs2.next()) {
				System.out.println(rs2.getInt(1));
				cBox.addItem(rs2.getInt(1));
			}
			
			}
			catch (Exception ee2) {
				
			}
		
		
		
			
	}
}
