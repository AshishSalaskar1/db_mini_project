import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class ViewFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con =null;
	private JScrollPane scrollPane;
	private JButton btnAgent;
	private JButton btnBranch;
	private JButton btnPayment;
	private JButton btnPoliciy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrame frame = new ViewFrame();
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
	 * @throws SQLException 
	 */
	public ViewFrame() throws ClassNotFoundException, SQLException {
		
		con = dbConnectionHelper.Connect();
		
		
	
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 786);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewTableData = new JLabel("View Existing Data");
		lblViewTableData.setForeground(new Color(255, 255, 255));
		lblViewTableData.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		lblViewTableData.setBounds(346, 13, 239, 52);
		contentPane.add(lblViewTableData);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 338, 883, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		scrollPane.setViewportView(table);
		
		JButton btnCustomer = new JButton("  Customer");
		btnCustomer.setBackground(new Color(240,240,240));
		btnCustomer.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\specialist-user.png"));
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					PreparedStatement pt = con.prepareStatement("select * from customer");
					ResultSet rs = pt.executeQuery();
					//To add query results into table
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCustomer.setBounds(49, 136, 161, 52);
		contentPane.add(btnCustomer);
		
		btnAgent = new JButton("  Agent");
		btnAgent.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\help-operator(1).png"));
		btnAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement pt = con.prepareStatement("select * from agent");
					ResultSet rs = pt.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAgent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgent.setBounds(257, 136, 150, 52);
		contentPane.add(btnAgent);
		
		btnBranch = new JButton("   Branch");
		btnBranch.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\home.png"));
		btnBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					PreparedStatement pt = con.prepareStatement("select * from branch");
					ResultSet rs = pt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pt.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnBranch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBranch.setBounds(445, 140, 151, 44);
		contentPane.add(btnBranch);
		
		btnPayment = new JButton("  Payment");
		btnPayment.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\icon.png"));
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement pt = con.prepareStatement("select * from payment");
					ResultSet rs = pt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pt.close();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});
		btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPayment.setBounds(622, 140, 161, 44);
		contentPane.add(btnPayment);
		
		btnPoliciy = new JButton("Policy");
		btnPoliciy.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\contract.png"));
		btnPoliciy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement pt = con.prepareStatement("select * from policy");
					ResultSet rs = pt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pt.close();
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			}
		});
		btnPoliciy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPoliciy.setBounds(807, 140, 144, 44);
		contentPane.add(btnPoliciy);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\backButton.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeFrame home = new HomeFrame();
				home.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(424, 653, 161, 73);
		contentPane.add(btnBack);
	}
}
