import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tName;
	private JTextField tQuota;
	private JTextField tReceipt;
	private JTextField tAmount;
	Connection con = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertFrame frame = new InsertFrame();
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
	public InsertFrame() throws ClassNotFoundException {
		
		con = dbConnectionHelper.Connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1290,798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admission Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(91, 79, 234, 42);
		contentPane.add(lblNewLabel);
		
		tName = new JTextField();
		tName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tName.setBounds(88, 121, 116, 35);
		contentPane.add(tName);
		tName.setColumns(10);
		
		tQuota = new JTextField();
		tQuota.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tQuota.setBounds(308, 121, 116, 35);
		contentPane.add(tQuota);
		tQuota.setColumns(10);
		
		tReceipt = new JTextField();
		tReceipt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tReceipt.setBounds(489, 121, 116, 35);
		contentPane.add(tReceipt);
		tReceipt.setColumns(10);
		
		tAmount = new JTextField();
		tAmount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tAmount.setBounds(673, 121, 116, 35);
		contentPane.add(tAmount);
		tAmount.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(91, 169, 154, 16);
		contentPane.add(lblName);
		
		JLabel lblQuota = new JLabel("Quota");
		lblQuota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuota.setBounds(308, 169, 154, 16);
		contentPane.add(lblQuota);
		
		JLabel lblReciptNo = new JLabel("Recipt no");
		lblReciptNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReciptNo.setBounds(487, 169, 154, 16);
		contentPane.add(lblReciptNo);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmount.setBounds(672, 169, 154, 16);
		contentPane.add(lblAmount);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String query = "insert into admission values(?,?,?,?)";
				PreparedStatement pt = con.prepareStatement(query);
				pt.setString(1, tName.getText().toString());
				pt.setString(2, tQuota.getText().toString());
				pt.setInt(3, Integer.parseInt(tReceipt.getText().toString()));
				pt.setInt(4, Integer.parseInt(tAmount.getText().toString()));
				ResultSet rs = pt.executeQuery();
				rs.close();
				pt.close();
				tName.setText("");
				tQuota.setText("");
				tReceipt.setText("");
				tAmount.setText(" ");
				JOptionPane.showMessageDialog(null,"Insertion Succesful");
				}
				catch(Exception e) {
					
				}
				
				
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnInsert.setBounds(866, 133, 97, 25);
		contentPane.add(btnInsert);
	}
}
