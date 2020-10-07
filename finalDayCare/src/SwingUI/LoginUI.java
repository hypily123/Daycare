package SwingUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import SubjectClass.DayCareRule;


import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginUI {

	private JFrame frame;
	private JTextField usertxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 764, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		lblUsername.setBounds(254, 240, 101, 44);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		lblPassword.setBounds(254, 295, 101, 38);
		
		usertxt = new JTextField();
		usertxt.setBounds(375, 252, 86, 20);
		usertxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(375, 304, 86, 20);
		passwordtxt.setColumns(10);
		
		DayCareRule dcr = new DayCareRule();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(286, 354, 147, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] temp = "admin".toCharArray();
				char[] password = passwordtxt.getPassword();
				if(usertxt.getText().toString().equals("admin")&& Arrays.equals(temp, password)) {
					Selection homepage = new Selection(dcr);
					homepage.setVisible(true);
					frame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "User name or password is wrong! try again!");
				}

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblUsername);
		frame.getContentPane().add(lblPassword);
		frame.getContentPane().add(passwordtxt);
		frame.getContentPane().add(usertxt);
		frame.getContentPane().add(btnLogin);
		
//		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(LoginUI.class.getResource("/images/northeastern-university-logo.png")));
//		label.setBounds(44, 0, 700, 144);
//		frame.getContentPane().add(label);
		
//		JLabel label_2 = new JLabel("");
//		label_2.setIcon(new ImageIcon(LoginUI.class.getResource("/images/Daycare.png")));
//		label_2.setBounds(54, 93, 653, 184);
//		frame.getContentPane().add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setIcon(new ImageIcon(LoginUI.class.getResource("/images/cover.jpg")));
		label_1.setBounds(0, 0, 764, 470);
		frame.getContentPane().add(label_1);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
