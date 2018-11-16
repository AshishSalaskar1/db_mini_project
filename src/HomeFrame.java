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
import java.awt.Color;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseOperationTo = new JLabel("Choose Operation to Perform");
		lblChooseOperationTo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChooseOperationTo.setBounds(224, 13, 365, 49);
		contentPane.add(lblChooseOperationTo);
		
		JButton btnViewExistingTables = new JButton("VIEW EXISTING TABLES");
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
		btnViewExistingTables.setBounds(211, 121, 338, 41);
		contentPane.add(btnViewExistingTables);
		
		JButton btnInsertValues = new JButton("Insert Values");
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
		btnInsertValues.setBounds(211, 217, 338, 41);
		contentPane.add(btnInsertValues);
		
		JButton btnQueries = new JButton("Queries");
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
		btnQueries.setBounds(211, 301, 338, 41);
		contentPane.add(btnQueries);
	}
}
