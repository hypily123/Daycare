package SwingUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import SubjectClass.DayCareRule;

import SubjectClass.Student;

import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class StudentUI extends JFrame{

	private JFrame frame;

	private JTextField StuID;
	private JTextField StuFirstName;
	private JTextField StuLastName;
	private JTextField StuAge;
	private JComboBox teacherChooseCbb;

	/**
	 * Initialize the contents of the frame.
	 */
	public StudentUI(DayCareRule dcr) throws IOException{
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 725, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setTitle("Create a new student");
		setBounds(100, 100, 725, 500);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 725, 500);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblStudentImmunizationRecord = new JLabel("Student ");
		lblStudentImmunizationRecord.setBounds(273, 22, 201, 31);
		panel.add(lblStudentImmunizationRecord);
		lblStudentImmunizationRecord.setForeground(Color.DARK_GRAY);
		lblStudentImmunizationRecord.setFont(new Font("Sitka Banner", Font.BOLD, 24));

		JLabel lblFirst = new JLabel("FirstName :");
		lblFirst.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblFirst.setBounds(273, 132, 120, 30);
		panel.add(lblFirst);

		JLabel lblLast = new JLabel("LastName");
		lblLast.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblLast.setBounds(273, 173, 120, 30);
		panel.add(lblLast);

		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblAge.setBounds(273, 223, 120, 30);
		panel.add(lblAge);

		//set textfields
		StuFirstName = new JTextField();
		StuFirstName.setColumns(10);
		StuFirstName.setBounds(415, 132, 120, 30);
		panel.add(StuFirstName);

		StuLastName = new JTextField();
		StuLastName.setColumns(10);
		StuLastName.setBounds(415, 173, 120, 30);
		panel.add(StuLastName);

		StuAge = new JTextField();
		StuAge.setColumns(10);
		StuAge.setBounds(415, 223, 120, 30);
		panel.add(StuAge);

		StuAge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sAge = StuAge.getText().toString();
				try {
					int age = Integer.parseInt(sAge);
					dcr.showTeachersWith(age, teacherChooseCbb);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		//teacher comboBox
		JLabel lblTeacherchoose = new JLabel("Teacher :");
		lblTeacherchoose.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblTeacherchoose.setBounds(273, 273, 120, 30);
		panel.add(lblTeacherchoose);
		teacherChooseCbb = new JComboBox<String>();
		teacherChooseCbb.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		teacherChooseCbb.setBounds(415, 273, 120, 30);
		panel.add(teacherChooseCbb);
		teacherChooseCbb.setEditable(false);
		panel.add(teacherChooseCbb, BorderLayout.SOUTH);

		panel.add(StuAge, BorderLayout.SOUTH);

		//add student button
		JButton addStudentBtn = new JButton("Add Student");
		addStudentBtn.setBounds(263, 350, 130, 30);
		addStudentBtn.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		panel.add(addStudentBtn);

		addStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addValueActionPerformed(e, dcr);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//background Icon
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(StudentUI.class.getResource("/images/background.jpg")));
		label_2.setBounds(0, 0, 725, 500);
		panel.add(label_2);
	}

	private void addValueActionPerformed(ActionEvent e, DayCareRule dcr) throws IOException {

		//add student to student csv file
		if ( StuFirstName.getText().isEmpty() || StuLastName.getText().isEmpty() || StuAge.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Student information missing!!!");
		}else {
			//create student obj
			//String sid = StuID.getText();
			String sfn = StuFirstName.getText();
			String sln = StuLastName.getText();
			int sage =  Integer.parseInt(StuAge.getText());
			String teacherid = teacherChooseCbb.getSelectedItem().toString();
			int tid = teacherid.charAt(teacherid.length() - 1) - '0';
			Student student =  new Student(sfn, sln, sage, tid);

			// rewrite student.csv file & teacher.csv file
			dcr.addStudentToStudentFile(student);
			dcr.addStudentToTeacher(student);

			dispose();
		}
	}


}
