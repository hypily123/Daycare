package SubjectClass;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
//import java.util.Vector;

public class Classroom {
	private int classroomID;
	private int capacity;		//group number 2,3
	private List<Integer> teachers;		//List of teachers ID
	
	public Classroom(int groupNum) throws IOException {
		//classroomID, groupNum, groups, teachers
		this.setAutoID();
		this.capacity = groupNum;
		teachers = new ArrayList<>();
	}
	
	public int getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
		
	}

	public List<Integer> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Integer> teachers) {
		this.teachers = teachers;
	}
	
	private void setAutoID() throws IOException {
		List<Integer> idList = new ArrayList<>();
		File sFile = 
				new File("./Classrooms.csv");

		FileReader sFR = new FileReader(sFile);
		BufferedReader sBR = new BufferedReader(sFR);
		String sString;
		while ((sString = sBR.readLine()) != null) {
			String[] line = sString.split(",");
			idList.add(Integer.parseInt(line[0]));
		}
		sBR.close();
		sFR.close();

		int id = 0;
		while (idList.contains(++id)) {
		}
		this.classroomID = id;
	}
}
