package SubjectClass;

import java.util.*;

public abstract class AbstractVaccine {
	
	private Calendar nextDate;
	private List<Calendar> record = new ArrayList<>();
	private boolean cannotAdd = false;
	private int num = 0;
	
	public AbstractVaccine() {
		
	}
	
	public int getnum() {
		return num;
	}
	public void setnum(int i) {
		num = i;
	}
	
	
	public boolean getState() {
		return cannotAdd;
	}
	public void noAdd() {
		cannotAdd = true;
	}
	
	public void add(int year, int month) {
		if (cannotAdd == false)
		{
			month -= 1;
			Calendar cal = Calendar.getInstance();
			cal.set(year,month, 1);
			record.add(cal);
		}
		else
			System.out.println("Cannot add element into List");
	}
	
	public int GetSize() {
		return record.size();
	}
	
	public void nextDatetoNull() {
		nextDate = null;
	}
	
	public String ShownextDate() {
		StringBuilder sb = new StringBuilder();
		if(nextDate == null)
			sb.append("x");
		else
			sb.append(nextDate.get(Calendar.YEAR)).append("-").append(nextDate.get(Calendar.MONTH)+1);
		return sb.toString();
		
	}
	
	public Calendar GetDoseDate(int index) {
		Calendar cal = Calendar.getInstance();
		cal.set(record.get(index).get(Calendar.YEAR), record.get(index).get(Calendar.MONTH), 1);
		return cal;
	}
	
	public Calendar SetDate(int year, int month){
		nextDate = Calendar.getInstance();
		nextDate.set(year,month, 1);
		return nextDate;
	}
	
	public Calendar GetBirthday(int age) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, age*(-1)+1);
		return cal;
	}
	
	public String ShowRecord() {
		StringBuilder sb = new StringBuilder();
		if(record.size() == 0)
			sb.append("");
		else
		{
			for(Calendar i : record)
			{
				sb.append(i.get(Calendar.YEAR)).append("-").append(i.get(Calendar.MONTH)+1).append(",");
			}
			//sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	public abstract void SetNextDate(int age);
}
