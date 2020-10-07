package SubjectClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import SubjectClass.Dtap;
import SubjectClass.HepatitisB;
import SubjectClass.Hib;
import SubjectClass.MMR;
import SubjectClass.Meningococcal;
import SubjectClass.Polio;
import SubjectClass.Tdap;
import SubjectClass.Varicella;

public class Student extends Person {
	private int teacherID;
	
	public HepatitisB hb = null;
	public Dtap dtap = null;
	public Hib hib = null;
	public Polio polio = null;
	public MMR mmr = null;
	public Varicella varicella = null;
	public Tdap tdap = null;
	public Meningococcal me = null;
	
	public Student() {

	}
	
	public Student(int id, String firstname, String lastname, int age) {
		this.setID(id);
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setAge(age);
		hb = new HepatitisB();
		dtap = new Dtap();
		hib = new Hib();
		polio =  new Polio();
		mmr = new MMR ();
		varicella = new Varicella();
		tdap = new Tdap();
		me = new Meningococcal();
	}

	public Student(String firstName, String lastName, int age, int teacherID) throws IOException {
		// id, firstname, lastname, age, teacherid, vaccine??
		//vaccine(filename = studentid)  
		List<Integer> a = new ArrayList<>();
		File sFile = 
				new File("./Students.csv");

		FileReader sFR = new FileReader(sFile);
		BufferedReader sBR = new BufferedReader(sFR);
		String sString;
		while ((sString = sBR.readLine()) != null) {
			String[] line = sString.split(",");
			a.add(Integer.parseInt(line[0]));
		}
		sBR.close();
		sFR.close();

		int j = 0;
		while (a.contains(++j)) {
			
		}
		this.setID(j);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.teacherID = teacherID;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

}
