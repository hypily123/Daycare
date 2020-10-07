package SubjectClass;

public class Person {
	
		private int id;
	    private String firstName;
	    private String lastName;
	    private int age;
	    
	    public Person() {
	    	
	    }
	    
		public Person(String firstName, String lastName, int age) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}
		public int getID() {
			return id;
		}
		public void setID(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

	    

}
