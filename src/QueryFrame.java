import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class QueryFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	Connection con =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryFrame frame = new QueryFrame();
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
	public QueryFrame() throws ClassNotFoundException {
		con = dbConnectionHelper.Connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Query 1");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(69, 79, 112, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblQueries = new JLabel("QUERIES");
		lblQueries.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQueries.setBounds(395, 0, 206, 58);
		contentPane.add(lblQueries);
		
		JLabel lblNewLabel = new JLabel("Retrieve the name and his customer name and dob whose location is \"DELHI\"");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(188, 83, 728, 16);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Query 2");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(69, 128, 106, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Retrieve the policies of all customers name and id who has \"HEALTH\" policies with maturity amount > 200000</html?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(189, 101, 703, 84);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Query 3");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_2.setBounds(69, 174, 112, 25);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("<html>\r\n Retrieve the Policy name,Policy no and name of the agent and Tensure Having Policy Type as 'HOME'.</html>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(188, 174, 704, 50);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Query 4");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_3.setBounds(69, 238, 112, 25);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("<html>For a Table \"POLICY\" retrieve the name of the policy and policy_no and count the number of Customer present in each policy.</html>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(188, 238, 747, 50);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Query 5");
		buttonGroup.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_4.setBounds(70, 302, 112, 25);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(188, 306, 185, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel sqlLabel = new JLabel("");
		sqlLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		sqlLabel.setBounds(52, 436, 428, 243);
		contentPane.add(sqlLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 435, 459, 251);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JButton btnSubmitQuery = new JButton("SUBMIT QUERY");
		btnSubmitQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query;
				if(rdbtnNewRadioButton.isSelected()) {
					query="SELECT AGENT_NAME,NAME,DOB FROM BRANCH B,AGENT A,CUSTOMER C	WHERE B.BRANCH_ID=A.BRANCH_ID AND  A.AGENT_ID=C.AGENT_ID AND B.LOCATION='Delhi'";
					sqlLabel.setText("<html>"+query+"</html>");
				
					try {
						PreparedStatement pt = con.prepareStatement(query);
						ResultSet rs = pt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						pt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					query="SELECT CUSTOMER_ID,NAME FROM CUSTOMER C, POLICY P, PAYMENT PA  WHERE P.POLICY_NO=C.POLICY_NO AND C.POLICY_NO=PA.POLICY_NO AND P.POLICY_TYPE='Health' AND  PA.MAT_AMOUNT > 200000";
					sqlLabel.setText("<html>"+query+"</html>");
				
					try {
						PreparedStatement pt = con.prepareStatement(query);
						ResultSet rs = pt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						pt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(rdbtnNewRadioButton_2.isSelected()) {
					query="SELECT DISTINCT P.POLICY_NO,NAME,AGENT_NAME FROM POLICY P, AGENT A, CUSTOMER C WHERE A.AGENT_ID=C.AGENT_ID AND P.POLICY_NO=C.POLICY_NO AND POLICY_TYPE='Home'";
					sqlLabel.setText("<html>"+query+"</html>");
				
					try {
						PreparedStatement pt = con.prepareStatement(query);
						ResultSet rs = pt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						pt.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}
				else if(rdbtnNewRadioButton_3.isSelected()) {
					query="SELECT P.POLICY_NO,POLICY_NAME,COUNT(*) AS NO_OF_CUSTOMER FROM POLICY P, AGENT A, CUSTOMER C WHERE C.POLICY_NO=P.POLICY_NO AND A.AGENT_ID=C.AGENT_ID GROUP BY P.POLICY_NO,POLICY_NAME";
					sqlLabel.setText("<html>"+query+"</html>");
				
					try {
						PreparedStatement pt = con.prepareStatement(query);
						ResultSet rs = pt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						pt.close();
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					
				}
				else if(rdbtnNewRadioButton_4.isSelected()) {
					query="select b.branch_id,a.agent_name,c.policy_no,c.name from branch b,agent a,customer c where (b.branch_id=a.branch_id and a.agent_id= c.agent_id) and (b.branch_id=1 and a.branch_id=1) and (a.agent_name='Alex' and c.policy_no=2001)";
					sqlLabel.setText("<html>"+query+"</html>");
				
					try {
						PreparedStatement pt = con.prepareStatement(query);
						ResultSet rs = pt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						pt.close();
					} catch (SQLException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					
				}
				else {
					
				}
				
				
			}
		});
		btnSubmitQuery.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmitQuery.setBounds(360, 347, 206, 25);
		contentPane.add(btnSubmitQuery);
		
		
		
		JLabel lblQueryInSql = new JLabel("Query in SQL");
		lblQueryInSql.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblQueryInSql.setBounds(47, 398, 147, 25);
		contentPane.add(lblQueryInSql);
		
		JLabel lblOutput = new JLabel("OUTPUT");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblOutput.setBounds(548, 406, 106, 16);
		contentPane.add(lblOutput);
	}
}
