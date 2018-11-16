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
		setBounds(100, 100,1290,798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Query 1");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(105, 75, 112, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblQueries = new JLabel("QUERIES");
		lblQueries.setFont(new Font("Georgia", Font.BOLD, 24));
		lblQueries.setBounds(395, 0, 206, 58);
		contentPane.add(lblQueries);
		
		JLabel lblNewLabel = new JLabel("<html>Get the student name and usn who passed in the examination and scored above 500 marks</html>\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(281, 70, 849, 35);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Query 2");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(105, 128, 106, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Retreive the student deatails who scored highest in the examnation</html?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(281, 97, 908, 84);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Query 3");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_2.setBounds(105, 183, 112, 25);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("<html>\r\nRetreive the student usn,name,department_id,sem and quota  who belongs to department number  5.</html>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(280, 170, 909, 50);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Query 4");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_3.setBounds(105, 234, 112, 25);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("<html>.Get the student name, usn,address,department _id,sem,result  who passed in the examination . </html>\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(278, 221, 966, 50);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Query 5");
		buttonGroup.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_4.setBounds(105, 298, 112, 25);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("<html>Get Student department name and corresponding department id ,name usn and sem who are localite (Haliyal)</html>\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(281, 273, 711, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel sqlLabel = new JLabel("");
		sqlLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		sqlLabel.setBounds(52, 436, 490, 302);
		contentPane.add(sqlLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(623, 431, 589, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JButton btnSubmitQuery = new JButton("SUBMIT QUERY");
		btnSubmitQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query;
				if(rdbtnNewRadioButton.isSelected()) {
					query="select e.name ,e.usn from exam e\r\n" + 
							"where e.result='pass' and e.marks>500";
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
					query="select name,marks,result from exam\r\n" + 
							"where marks=(select Max(marks) from exam)";
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
					query="select c.usn,s.name,c.d_id,c.sem,a.quota\r\n" + 
							" from student s, class c,admission a\r\n" + 
							"where  a.name=s.name and s.usn=c.usn and d_id=2";
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
					query="select s.name ,s.usn,s.address,c.d_id,c.sem,e.result\r\n" + 
							"from student s,exam e,class c\r\n" + 
							"where s.usn=c.usn and s.name=e.name and e.result='pass'";
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
					query="select d.d_name,d.d_id,s.name,c.usn,c.sem\r\n" + 
							"from department d, student s, class c \r\n" + 
							"where c.d_id=d.d_id and s.usn=c.usn and s.address='haliyal'";
					sqlLabel.setText("<html>"+"SELECT B.BRANCH_ID,A.AGENT_NAME,C.POLICY_NO,C.NAME FROM BRANCH B,AGENT A,CUSTOMER C WHERE (B.BRANCH_ID=A.BRANCH_ID AND A.AGENT_ID= C.AGENT_ID) AND (B.BRANCH_ID=1 AND A.BRANCH_ID=1) AND (A.AGENT_NAME='ALEX' AND C.POLICY_NO=2001)"+"</html>");
				
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
		btnSubmitQuery.setFont(new Font("Georgia", Font.BOLD, 15));
		btnSubmitQuery.setBounds(488, 335, 206, 50);
		contentPane.add(btnSubmitQuery);
		
		JLabel lblOutput = new JLabel("OUTPUT");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblOutput.setBounds(615, 398, 106, 20);
		contentPane.add(lblOutput);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeFrame hf = new HomeFrame();
				hf.setVisible(true);
			}
		});
		btnGoBack.setBounds(335, 348, 97, 25);
		contentPane.add(btnGoBack);
	}
}
