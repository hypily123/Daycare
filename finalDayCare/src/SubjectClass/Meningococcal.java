package SubjectClass;

import java.util.Calendar;

public class Meningococcal extends AbstractVaccine {

	@Override
	public void SetNextDate(int age) {
		// TODO Auto-generated method stub
		super.nextDatetoNull();
		int DoseNum = super.GetSize();
		
		if(DoseNum == 0)
		{
			Calendar perDose = Calendar.getInstance();
			perDose.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
			perDose.add(Calendar.MONTH, 13 * 12);
			super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
		}
		else if (DoseNum == 1)
		{
			Calendar sixteen = Calendar.getInstance();
			sixteen.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
			sixteen.add(Calendar.MONTH, 16 * 12);
			int sixteenyear = sixteen.get(Calendar.YEAR);
			int sixteenmonth = sixteen.get(Calendar.MONTH);
			
			Calendar Dose1 = Calendar.getInstance();
			Dose1.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
			Dose1.add(Calendar.MONTH, 2);
			int Dose1year = Dose1.get(Calendar.YEAR);
			int Dose1month = Dose1.get(Calendar.MONTH);
			
			if(sixteenyear > Dose1year)
				super.SetDate(sixteen.get(Calendar.YEAR), sixteen.get(Calendar.MONTH));
			else if(Dose1year > sixteenyear)
				super.SetDate(Dose1.get(Calendar.YEAR), Dose1.get(Calendar.MONTH));
			else
			{
				if(sixteenmonth > Dose1month)
					super.SetDate(sixteen.get(Calendar.YEAR), sixteen.get(Calendar.MONTH));
				else
					super.SetDate(Dose1.get(Calendar.YEAR), Dose1.get(Calendar.MONTH));
			}
		}
		else
		{
			super.noAdd();
		}
			
	}

}
