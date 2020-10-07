package SubjectClass;

import java.util.Calendar;

public class Hib extends AbstractVaccine {

	@Override
	public void SetNextDate(int age) {
		// TODO Auto-generated method stub
		super.nextDatetoNull();
		int DoseNum = super.GetSize();
		Calendar current = Calendar.getInstance();
		int currentYear = current.get(Calendar.YEAR);
		int currentMonth = current.get(Calendar.MONTH);
		
		if (DoseNum == 0)
		{
			Calendar perDose = Calendar.getInstance();
			perDose.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
			perDose.add(Calendar.MONTH, 2);
			super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
			super.setnum(4);
		}
		else if (DoseNum == 1)
		{
			int Dose1year = super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR);
			int Dose1month = super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH);
			int Dose1age = age - ((currentYear - Dose1year) * 12 + (currentMonth - Dose1month)); 
			
			if (Dose1age >= 15)
			{
				super.noAdd();
			}
			else if ((Dose1age >= 0) && (Dose1age <= 12))
			{
				Calendar preDose2 = Calendar.getInstance();
				preDose2.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
				preDose2.add(Calendar.MONTH, 1);
				super.SetDate(preDose2.get(Calendar.YEAR), preDose2.get(Calendar.MONTH));
			}
			else if ((Dose1age > 12) && (Dose1age <= 14))
			{
				Calendar preDose2 = Calendar.getInstance();
				preDose2.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
				preDose2.add(Calendar.MONTH, 2);
				super.SetDate(preDose2.get(Calendar.YEAR), preDose2.get(Calendar.MONTH));
				super.setnum(2);
			}
			else
				System.out.println("Dose1age wrong!!!");
		}
		else if (DoseNum == 2)
		{
			if(super.getnum() != 2)
			{
				int Dose2year = super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR);
				int Dose2month = super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH);
				int Dose2age = age - ((currentYear - Dose2year) * 12 + (currentMonth - Dose2month));
				
				int Dose1year = super.GetDoseDate(DoseNum - 2).get(Calendar.YEAR);
				int Dose1month = super.GetDoseDate(DoseNum - 2).get(Calendar.MONTH);
				int Dose1age = age - ((currentYear - Dose1year) * 12 + (currentMonth - Dose1month)); 
				
				if (Dose2age >= 15)
				{
					super.noAdd();
				}
				else if (age <= 12 && Dose1age <= 7)
				{
					Calendar preDose3 = Calendar.getInstance();
					preDose3.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
					preDose3.add(Calendar.MONTH, 1);
					super.SetDate(preDose3.get(Calendar.YEAR), preDose3.get(Calendar.MONTH));
				}
				else if ((age <= 12) && (Dose1age > 7) && (Dose1age <= 11))
				{
					Calendar preDose3 = Calendar.getInstance();
					preDose3.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
					preDose3.add(Calendar.MONTH, 2);
					super.SetDate(preDose3.get(Calendar.YEAR), preDose3.get(Calendar.MONTH));
				}
				else if ((age > 12) && (age <= 59) && (Dose1age <= 12) && (Dose2age <= 15))
				{
					Calendar preDose3 = Calendar.getInstance();
					preDose3.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
					preDose3.add(Calendar.MONTH, 2);
					super.SetDate(preDose3.get(Calendar.YEAR), preDose3.get(Calendar.MONTH));
					super.setnum(3);
				}
				else
					System.out.println("Dose1age && Dose2age wrong!!!");
			}
			else
			{
				super.noAdd();
			}
				
		}
		else if (DoseNum == 3)
		{
			if (super.getnum() != 3)
			{
				int Dose2year = super.GetDoseDate(DoseNum - 2).get(Calendar.YEAR);
				int Dose2month = super.GetDoseDate(DoseNum - 2).get(Calendar.MONTH);
				int Dose2age = age - ((currentYear - Dose2year) * 12 + (currentMonth - Dose2month));
				
				int Dose1year = super.GetDoseDate(DoseNum - 3).get(Calendar.YEAR);
				int Dose1month = super.GetDoseDate(DoseNum - 3).get(Calendar.MONTH);
				int Dose1age = age - ((currentYear - Dose1year) * 12 + (currentMonth - Dose1month)); 
				
				int Dose3year = super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR);
				int Dose3month = super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH);
				int Dose3age = age - ((currentYear - Dose3year) * 12 + (currentMonth - Dose3month)); 
				
				if ((age > 12) && (age <= 59) && (Dose1age <= 12) && (Dose2age <= 12) && (Dose3age <= 12))
				{
					Calendar preDose4 = Calendar.getInstance();
					preDose4.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
					preDose4.add(Calendar.MONTH, 2);
					super.SetDate(preDose4.get(Calendar.YEAR), preDose4.get(Calendar.MONTH));
				}
				else 
				{
					super.noAdd();
				}
					
			}
			else
			{
				super.noAdd();
			}
				
		}
		else 
		{
			super.noAdd();
		}
			
	}
	
	public static void demo() {
		Hib h = new Hib();
		
		h.add(2019, 11);
		h.SetNextDate(6);
		h.add(2020, 2);
		h.SetNextDate(6);
		h.add(2020, 3);
		System.out.println(h.ShowRecord());
		h.SetNextDate(6);
		System.out.println(h.ShownextDate());
	}

}
