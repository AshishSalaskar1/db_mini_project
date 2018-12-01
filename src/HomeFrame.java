import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class HomeFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
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
	public HomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 786);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseOperationTo = new JLabel("");
		lblChooseOperationTo.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\textHome.png"));
		lblChooseOperationTo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChooseOperationTo.setBounds(237, 36, 507, 49);
		contentPane.add(lblChooseOperationTo);
		
		JButton btnViewExistingTables = new JButton("");
		btnViewExistingTables.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnViewExistingTables.setBackground(SystemColor.menu);
		btnViewExistingTables.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\btn1.png"));
		btnViewExistingTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						contentPane.setVisible(false);
						try {
							ViewFrame vf = new ViewFrame();
							vf.setVisible(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
			}
		});
		btnViewExistingTables.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewExistingTables.setBounds(304, 243, 338, 41);
		contentPane.add(btnViewExistingTables);
		
		JButton btnInsertValues = new JButton("");
		btnInsertValues.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnInsertValues.setBackground(SystemColor.menu);
		btnInsertValues.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\btn2.png"));
		btnInsertValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				try {
					InsertFrame iFrame = new InsertFrame();
					iFrame.setVisible(true);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnInsertValues.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsertValues.setBounds(304, 348, 338, 41);
		contentPane.add(btnInsertValues);
		
		JButton btnQueries = new JButton("");
		btnQueries.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnQueries.setBackground(SystemColor.menu);
		btnQueries.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\executeQueries.png"));
		btnQueries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.setVisible(false);
				try {
					QueryFrame qFrame = new QueryFrame();
					qFrame.setVisible(true);
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
			}
		});
		btnQueries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnQueries.setBounds(304, 450, 338, 41);
		contentPane.add(btnQueries);
		
		JButton btnStoredProcedure = new JButton("");
		btnStoredProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				try {
					SP iFrame = new SP();
					iFrame.setVisible(true);
				} catch (Exception e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			}
		});
		btnStoredProcedure.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStoredProcedure.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnStoredProcedure.setBackground(SystemColor.menu);
		btnStoredProcedure.setBounds(304, 541, 338, 41);
		contentPane.add(btnStoredProcedure);
	}
}
