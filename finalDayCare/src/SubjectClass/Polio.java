package SubjectClass;

import java.util.Calendar;

public class Polio extends AbstractVaccine {

	@Override
	public void SetNextDate(int age) {
		// TODO Auto-generated method stub
		super.nextDatetoNull();
		int DoseNum = super.GetSize();
		Calendar perDose = Calendar.getInstance();
		
		if (DoseNum == 0)
		{
			Calendar perDose1 = Calendar.getInstance();
			perDose1.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
			perDose1.add(Calendar.MONTH, 2);
			super.SetDate(perDose1.get(Calendar.YEAR), perDose1.get(Calendar.MONTH));
			super.setnum(4);
		}
		else if (DoseNum == 1)
		{
			perDose.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
			perDose.add(Calendar.MONTH, 1);
			super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
		}
		else if (DoseNum == 2)
		{
			if (age < 48)
			{
				perDose.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
				perDose.add(Calendar.MONTH, 1);
				super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
			}
			else
			{
				perDose.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
				perDose.add(Calendar.MONTH, 6);
				super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
				super.setnum(3);
			}
		}
		else if (DoseNum == 3)
		{
			if (super.getnum() != 3)
			{
				perDose.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
				perDose.add(Calendar.MONTH, 6);
				int Dose4year = perDose.get(Calendar.YEAR);
				int Dose4month = perDose.get(Calendar.MONTH);
				
				Calendar FourYearsOld = Calendar.getInstance();
				FourYearsOld.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
				FourYearsOld.add(Calendar.MONTH, 48);
				int FourYear = FourYearsOld.get(Calendar.YEAR);
				int FourMonth = FourYearsOld.get(Calendar.MONTH);
				
				if (Dose4year > FourYear)
					super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
				else if (Dose4year < FourYear)
					super.SetDate(FourYearsOld.get(Calendar.YEAR), FourYearsOld.get(Calendar.MONTH));
				else
				{
					if (Dose4month > FourMonth)
						super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
					else
						super.SetDate(FourYearsOld.get(Calendar.YEAR), FourYearsOld.get(Calendar.MONTH));
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

}
