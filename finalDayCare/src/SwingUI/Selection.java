package SwingUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import SubjectClass.DayCareRule;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.*;



public class Selection extends JFrame {

	private JPanel contentPane;
	private JTable studentTable;
	private JTable teacherTable;
	private DefaultTableModel studentModel;
	private DefaultTableModel teacherModel;
	private JTextField stuFilter;

	/**
	 * populate csv file into table
	 * @throws IOException 
	 */

	private void filter(String s) {

		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(studentModel);
		studentTable.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(s));

	}

	private void populateStu() throws IOException {
		//set columnInfo
		Vector<String> studentInfo = new Vector<>();
		studentInfo.add("ID");
		studentInfo.add("FirstName");
		studentInfo.add("LastName");
		studentInfo.add("Age");

		//import CSVData
		Vector<Vector<String>> studentData = new Vector<>();

		File sFile = new File("./Students.csv");

		FileReader sFR = new FileReader(sFile);
		BufferedReader sBR = new BufferedReader(sFR);
		String sString;
		while ((sString = sBR.readLine()) != null) {
			String[] line = sString.split(",");
			Vector<String> curline = new Vector<>(Arrays.asList(line));
			studentData.add(curline);
		}
		sBR.close();
		sFR.close();

		studentModel = new DefaultTableModel(studentData, studentInfo);
		studentTable.setModel(studentModel);
	}

	private void populateTea() throws IOException {
		//set columnInfo
		Vector<String> teacherInfo = new Vector<>();
		teacherInfo.add("ID");
		teacherInfo.add("FirstName");
		teacherInfo.add("LastName");
		teacherInfo.add("Age");

		//import CSVData
		Vector<Vector<String>> teacherData = new Vector<>();

		File tFile = new File("./Teachers.csv");

		FileReader tFR = new FileReader(tFile);
		BufferedReader tBR = new BufferedReader(tFR);
		String tString;
		while ((tString = tBR.readLine()) != null) {
			String[] line = tString.split(",");
			Vector<String> curline = new Vector<>(Arrays.asList(line));
			teacherData.add(curline);
		}
		tBR.close();
		tFR.close();

		teacherModel = new DefaultTableModel(teacherData, teacherInfo);
		teacherTable.setModel(teacherModel);
	}

	public Selection(DayCareRule dcr)  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 890,550);
		contentPane.add(panel);
		panel.setLayout(null);

		//Student table
		JLabel lblstable = new JLabel("Student Table");
		lblstable.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblstable.setBounds(10, 10, 150, 30);
		panel.add(lblstable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 641, 200);
		panel.add(scrollPane);

		//Teacher table
		JLabel lblTtable = new JLabel("Teacher Table");
		lblTtable.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblTtable.setBounds(10, 280, 150, 30);
		panel.add(lblTtable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 315, 641, 200);
		panel.add(scrollPane_1);

		//populate studentTable & teacherTable
		studentTable = new JTable();
		teacherTable = new JTable();
		try {
			populateStu();
			populateTea();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		scrollPane.setViewportView(studentTable);
		scrollPane_1.setViewportView(teacherTable);

// all the buttons
		//addClassroom button
		JButton btnAddClassroom = new JButton("Add Room");
		btnAddClassroom.setBounds(661, 42, 120, 30);
		panel.add(btnAddClassroom);
		btnAddClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassroomUI roomui = new ClassroomUI(dcr);
				roomui.setVisible(true);
			}
		});

		//addTeacher button
		JButton addTeacherBtn = new JButton("Add Teacher");
		addTeacherBtn.setBounds(661, 102, 120, 30);
		panel.add(addTeacherBtn);
		//		addTeacherBtn.setIcon(
		//			new ImageIcon(TeacherUI.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		addTeacherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherUI teaui;
				try {
					teaui = new TeacherUI(dcr);
					if(dcr.hasClassroom()) teaui.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		//addStudent button
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(661, 162, 120, 30);
		panel.add(btnAddStudent);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUI stuui;
				try {
					stuui = new StudentUI(dcr);
					if(dcr.hasTeacher()) stuui.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		//showImmuRecButton set Icon & ActionListener
		JButton btnShowImmuRec = new JButton("Immu Record");
		//		btnShowImmuRec.setIcon(new ImageIcon(Selection.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		btnShowImmuRec.setBounds(661, 230, 120, 30);
		panel.add(btnShowImmuRec);
		btnShowImmuRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = studentTable.getSelectedRow();

				if(selectedRow >= 0){
					String getid = studentTable.getValueAt(selectedRow, 0).toString();
					String getfirstname = studentTable.getValueAt(selectedRow,1).toString();
					String getlastname = studentTable.getValueAt(selectedRow, 2).toString();
					String getage = studentTable.getValueAt(selectedRow, 3).toString();
					StudentImmuRecUI addRec = new StudentImmuRecUI(getid, getfirstname, getlastname, getage);
					addRec.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "You need to choose a student");
				}
			}

		});

		//refresh button
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(661, 290, 120, 30);
		panel.add(refreshBtn);
		refreshBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					populateStu();
					populateTea();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				studentTable.setModel(studentModel);
				teacherTable.setModel(teacherModel);
			}
		});	


		//search student label:
		JLabel lblSearchStuByID = new JLabel("Search students by keyword");
		lblSearchStuByID.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		lblSearchStuByID.setBounds(20, 250, 200, 28);	//int x, int y, int width, int height
		panel.add(lblSearchStuByID);

		//search student textfield
		stuFilter = new JTextField(); 
		stuFilter.setColumns(10);
		stuFilter.setBounds(210, 250, 135, 28);
		panel.add(stuFilter);
		stuFilter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = stuFilter.getText();
				filter(s);				
			}
		});		

		//background
		JLabel label_2 = new JLabel("");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setIcon(new ImageIcon(Selection.class.getResource("/images/background2.jpg")));
		label_2.setBounds(0, 0, 890,550);
		panel.add(label_2);

	}
}

