package SubjectClass;

import java.util.Calendar;

public class Varicella extends AbstractVaccine {

	@Override
	public void SetNextDate(int age) {
		// TODO Auto-generated method stub
		super.nextDatetoNull();
		int DoseNum = super.GetSize();
		Calendar perDose = Calendar.getInstance();
		
		if (DoseNum == 0)
		{
			perDose.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
			perDose.add(Calendar.MONTH, 12);
			super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
		}
		else if (DoseNum == 1)
		{
			if(age < 13 * 12)
			{
				perDose.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
				perDose.add(Calendar.MONTH, 3);
				super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
			}
			else
			{
				perDose.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
				perDose.add(Calendar.MONTH, 1);
				super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
			}
		}
		else 
		{
			super.noAdd();
		}
			
	}

}
