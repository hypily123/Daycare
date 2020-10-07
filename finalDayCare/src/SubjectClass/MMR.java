package SubjectClass;

import java.util.Calendar;

public class MMR extends AbstractVaccine {

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
			perDose.set(super.GetDoseDate(DoseNum - 1).get(Calendar.YEAR), super.GetDoseDate(DoseNum - 1).get(Calendar.MONTH), 1);
			perDose.add(Calendar.MONTH, 1);
			super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
		}
		else
		{
			super.noAdd();
		}
			//super.noAdd();
	}

	public static void demo() {
		MMR h = new MMR();
		
		h.add(2020, 3);
		h.SetNextDate(15);
		System.out.println(h.ShownextDate());
		/*h.add(2020, 4);
		h.SetNextDate(15);
		System.out.println(h.ShownextDate());
		h.add(2020, 5);
		System.out.println(h.ShowRecord());
		h.SetNextDate(15);
		System.out.println(h.ShownextDate());*/
	}
}
