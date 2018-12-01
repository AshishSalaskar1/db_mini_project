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
public class custInfo extends JFrame {
	

	private JPanel contentPane;
	private JTextField tf1;
	static Connection conn = null;
	JComboBox<Integer> cBoxAgent;
	JComboBox<Integer> cBoxPolicy; 
	HomeFrame home = new HomeFrame();
	private JTextField tf2;
	private JTextField tf3;
	
	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custInfo frame = new custInfo();
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
	public custInfo() throws ClassNotFoundException {
		
		conn = dbConnectionHelper.Connect();
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPolicyno = new JLabel("Customer Id");
		lblPolicyno.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPolicyno.setBounds(74, 129, 172, 59);
		contentPane.add(lblPolicyno);
		
		JLabel lblPolicyno_1 = new JLabel("Policy No");
		lblPolicyno_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPolicyno_1.setBounds(74, 201, 172, 59);
		contentPane.add(lblPolicyno_1);
		
//		lblPolicyno.setForeground();
		
		JLabel lblPoltype = new JLabel("Agent_id");
		lblPoltype.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPoltype.setBounds(74, 271, 172, 59);
		contentPane.add(lblPoltype);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf1.setBounds(228, 136, 116, 49);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton b1 = new JButton("");
		b1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\insertBtnFrame.png"));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int id = Integer.parseInt(tf1.getText());
				String name = tf2.getText().toString();
				String phone = tf3.getText().toString();
				try {
					String sql = "insert into customer values(?,?,?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setInt(1, id);
					st.setInt(3,(int) cBoxAgent.getSelectedItem());
					st.setInt(2, (int) cBoxPolicy.getSelectedItem());
					st.setString(5, "11-JAN-84");
					st.setString(4,name);
					st.setString(6,phone);
					ResultSet rs = st.executeQuery();
					rs.close();
					st.close();
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
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
		
		JLabel lblInsertValuesInto = new JLabel("Insert Values into CUSTOMER Table");
		lblInsertValuesInto.setFont(new Font("Constantia", Font.BOLD, 30));
		lblInsertValuesInto.setBounds(250, 13, 568, 59);
		contentPane.add(lblInsertValuesInto);
		
	cBoxAgent = new JComboBox<Integer>();
		cBoxAgent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cBoxAgent.setBounds(228, 281, 74, 43);
		contentPane.add(cBoxAgent);
		
		 cBoxPolicy = new JComboBox<Integer>();
		cBoxPolicy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cBoxPolicy.setBounds(228, 216, 74, 43);
		contentPane.add(cBoxPolicy);
		
		JLabel tf2sdf = new JLabel("Name");
		tf2sdf.setFont(new Font("Tahoma", Font.PLAIN, 22));
		tf2sdf.setBounds(74, 343, 172, 59);
		contentPane.add(tf2sdf);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf2.setColumns(10);
		tf2.setBounds(228, 350, 116, 49);
		contentPane.add(tf2);
		
		JLabel lblPhonesdf = new JLabel("Phone");
		lblPhonesdf.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPhonesdf.setBounds(74, 408, 172, 59);
		contentPane.add(lblPhonesdf);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tf3.setColumns(10);
		tf3.setBounds(228, 415, 116, 49);
		contentPane.add(tf3);
		
		System.out.println("Loaded");
		conn = dbConnectionHelper.Connect();
		try {
		PreparedStatement pr = conn.prepareStatement("select agent_id from agent");
		ResultSet rs1 = pr.executeQuery();
		while(rs1.next()) {
			System.out.println(rs1.getInt(1));
			cBoxAgent.addItem(rs1.getInt(1));
		}
		
		}
		catch (Exception ee) {
			
		}
		try {
			PreparedStatement pr = conn.prepareStatement("select policy_no from policy");
			ResultSet rs2 = pr.executeQuery();
			while(rs2.next()) {
				System.out.println(rs2.getInt(1));
				cBoxPolicy.addItem(rs2.getInt(1));
			}
			
			}
			catch (Exception ee2) {
				
			}
		
			
	}
}
