package SubjectClass;

import java.util.Calendar;

public class HepatitisB extends AbstractVaccine {

	@Override
	public void SetNextDate(int age) {
		// TODO Auto-generated method stub
		super.nextDatetoNull();
		int DoseNum = super.GetSize();
		if (DoseNum == 0)
		{
			super.SetDate(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH));
		}
		else if (DoseNum == 1)
		{
			Calendar cal1 = Calendar.getInstance();
			cal1.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
			cal1.add(Calendar.MONTH, 1);
			super.SetDate(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH));
		}
		else if (DoseNum == 2)
		{
			Calendar cal2 = Calendar.getInstance();
			cal2.set(super.GetDoseDate(DoseNum - 2).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 2).get(Calendar.MONTH), 1);
			cal2.add(Calendar.MONTH, 4);
			int Dose1year = cal2.get(Calendar.YEAR);
			int Dose1month = cal2.get(Calendar.MONTH);
			
			Calendar cal3 = Calendar.getInstance();
			cal3.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
			cal3.add(Calendar.MONTH, 2);
			int Dose2year = cal3.get(Calendar.YEAR);
			int Dose2month = cal3.get(Calendar.MONTH);
			
			Calendar cal4 = Calendar.getInstance();
			cal4.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
			cal4.add(Calendar.MONTH, 6);
			int Birthyear = cal4.get(Calendar.YEAR);
			int Birthmonth = cal4.get(Calendar.MONTH);
			
			if(Dose1year > Dose2year)
			{
				if (Dose1year > Birthyear)
					super.SetDate(Dose1year, Dose1month);
				else if (Birthyear > Dose1year)
					super.SetDate(Birthyear, Birthmonth);
				else
				{
					if (Dose1month > Birthmonth)
						super.SetDate(Dose1year, Dose1month);
					else
						super.SetDate(Birthyear, Birthmonth);
				}
			}
			else if (Dose1year < Dose2year)
			{
				if (Dose2year > Birthyear)
					super.SetDate(Dose2year, Dose2month);
				else if (Birthyear > Dose2year)
					super.SetDate(Birthyear, Birthmonth);
				else
				{
					if (Dose2month > Birthmonth)
						super.SetDate(Dose2year, Dose2month);
					else
						super.SetDate(Birthyear, Birthmonth);
				}
			}
			else
			{
				if (Dose1month > Dose2month)
				{
					if (Dose1year > Birthyear)
						super.SetDate(Dose1year, Dose1month);
					else if (Birthyear > Dose1year)
						super.SetDate(Birthyear, Birthmonth);
					else
					{
						if (Dose1month > Birthmonth)
							super.SetDate(Dose1year, Dose1month);
						else
							super.SetDate(Birthyear, Birthmonth);
					}
				}
				else
				{
					if (Dose2year > Birthyear)
						super.SetDate(Dose2year, Dose2month);
					else if (Birthyear > Dose2year)
						super.SetDate(Birthyear, Birthmonth);
					else
					{
						if (Dose2month > Birthmonth)
							super.SetDate(Dose2year, Dose2month);
						else
							super.SetDate(Birthyear, Birthmonth);
					}
				}
			}	
		}
		else 
		{
			super.noAdd();
		}
			
		
	}
	
	public static void demo() {
		HepatitisB h = new HepatitisB();
		
		h.add(2020, 1);
		h.SetNextDate(25);
		h.add(2020, 2);
		h.SetNextDate(25);
		h.add(2020, 10);
		System.out.println(h.ShowRecord());
		h.SetNextDate(25);
		System.out.println(h.ShownextDate());
	}

}
