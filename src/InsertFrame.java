import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class InsertFrame extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	 */
	public InsertFrame() {
		getContentPane().setForeground(Color.GRAY);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(null);
		
		JLabel lblChooseTheTable = new JLabel("Choose The Table to Insert The Values");
		lblChooseTheTable.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
		lblChooseTheTable.setBounds(275, 40, 475, 62);
		getContentPane().add(lblChooseTheTable);
		
		JButton b1 = new JButton("");
		b1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\INSERTBTNaGENT.png"));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgentInfo ag;
				try {
					ag = new AgentInfo();
					ag.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		b1.setForeground(Color.GRAY);
		b1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		b1.setBounds(378, 142, 272, 62);
		getContentPane().add(b1);
		
		JButton b2 = new JButton("");
		b2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\INSERT BTNcUDTYOMER.png"));
		b2.setForeground(Color.GRAY);
		b2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PolicyInfo pol = new PolicyInfo();
				pol.setVisible(true);
			}
		});
		b2.setBounds(378, 239, 274, 62);
		getContentPane().add(b2);
		
		JButton btnBranch = new JButton("");
		btnBranch.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\brachBTN.png"));
		btnBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BranchInfo bf;
				
				try {
					bf = new BranchInfo();
					bf.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnBranch.setForeground(Color.GRAY);
		btnBranch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBranch.setBounds(378, 333, 274, 62);
		getContentPane().add(btnBranch);
		
		JButton btnCustomer = new JButton("");
		btnCustomer.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\CUSTBtn.png"));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				custInfo cf;
				
				try {
					cf = new custInfo();
					cf.setVisible(true);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnCustomer.setForeground(Color.GRAY);
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCustomer.setBounds(376, 429, 274, 62);
		getContentPane().add(btnCustomer);
		
		JButton btnPayment = new JButton("");
		btnPayment.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java Images\\PAYbtn.png"));
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentInfo cf;
				
				try {
					cf = new PaymentInfo();
					cf.setVisible(true);
				} catch (ClassNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});
		btnPayment.setForeground(Color.GRAY);
		btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPayment.setBounds(378, 518, 274, 62);
		getContentPane().add(btnPayment);
		
		JButton btnExecuteStoredn = new JButton("<html>Stored Procedure</html>");
		btnExecuteStoredn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StoredProc sp;
				try {
					sp = new StoredProc();
					sp.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnExecuteStoredn.setForeground(Color.BLACK);
		btnExecuteStoredn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnExecuteStoredn.setBounds(376, 604, 274, 62);
		getContentPane().add(btnExecuteStoredn);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
