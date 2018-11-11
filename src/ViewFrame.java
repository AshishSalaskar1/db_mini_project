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
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewTableData = new JLabel("View Existing Data");
		lblViewTableData.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblViewTableData.setBounds(346, 13, 183, 36);
		contentPane.add(lblViewTableData);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 320, 883, 337);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					PreparedStatement pt = con.prepareStatement("select * from customer");
					ResultSet rs = pt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCustomer.setBounds(49, 136, 129, 36);
		contentPane.add(btnCustomer);
		
		btnAgent = new JButton("Agent");
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
		btnAgent.setBounds(257, 136, 129, 36);
		contentPane.add(btnAgent);
		
		btnBranch = new JButton("Branch");
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
		btnBranch.setBounds(456, 136, 129, 36);
		contentPane.add(btnBranch);
		
		btnPayment = new JButton("Payment");
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
		btnPayment.setBounds(641, 136, 129, 36);
		contentPane.add(btnPayment);
		
		btnPoliciy = new JButton("Policy");
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
		btnPoliciy.setBounds(821, 136, 129, 36);
		contentPane.add(btnPoliciy);
	}
}
