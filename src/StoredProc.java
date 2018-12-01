import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class StoredProc extends JFrame {

	private JPanel contentPane;
	private Connection conn =null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoredProc frame = new StoredProc();
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
	public StoredProc() throws ClassNotFoundException {
		conn = dbConnectionHelper.Connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStoredProcedure = new JLabel("Stored Procedure");
		lblStoredProcedure.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblStoredProcedure.setBounds(353, 32, 264, 46);
		contentPane.add(lblStoredProcedure);
		
		JLabel lblNewLabel = new JLabel("<html>This stored procedure calculates the discount of 1.7% on the Maturity amount and updates the same into a Discount collumn in the Payment Tables</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(119, 78, 819, 180);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Execute\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String qry = "begin discountP;end;";		
				try {
					
				String res;
				PreparedStatement pt1 = conn.prepareStatement(qry);
				pt1.executeQuery();
				pt1.close();
				JOptionPane.showMessageDialog(null,"Execution Succesful");
				
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"Execution Succesful");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(303, 272, 138, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Table\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				PreparedStatement pt = conn.prepareStatement("select * from payment");
				ResultSet rs = pt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				pt.close();
				}
				catch(Exception eee) {
					eee.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(518, 274, 140, 46);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 384, 720, 282);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeFrame home = new HomeFrame();
				home.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\homeBtn.png"));
		button.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button.setBounds(898, 614, 74, 80);
		contentPane.add(button);
		
		
	}
}
