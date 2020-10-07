package SubjectClass;

import java.util.Calendar;

public class Tdap extends AbstractVaccine {

	@Override
	public void SetNextDate(int age) {
		// TODO Auto-generated method stub
		super.nextDatetoNull();
		int DoseNum = super.GetSize();
		
		if(DoseNum == 0)
		{
			Calendar perDose = Calendar.getInstance();
			perDose.set(super.GetBirthday(age).get(Calendar.YEAR), super.GetBirthday(age).get(Calendar.MONTH), 1);
			perDose.add(Calendar.MONTH, 11 * 12);
			super.SetDate(perDose.get(Calendar.YEAR), perDose.get(Calendar.MONTH));
		}
		else
		{
			super.noAdd();
		}
			
	}
	
	public static void demo() {
		Tdap h = new Tdap();
		
		h.SetNextDate(3);
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
