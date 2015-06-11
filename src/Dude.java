public class Dude {

	String name;
	String lastName;
	String firstname;
	int age;

	
	Dude(String firstname, String lastname, int age){
		
		name = firstname + " " + lastname;
		
		this.age = age;
		
	}

	public void setName(String firstname, String lastName) {

		this.lastName = lastName;
		
		this.firstname = firstname; 
		
		this.name = firstname + " " + lastName;  

	}

	public String getName() {

		return this.name;

	}
	public void setAge(int age) {

		this.age = age;

	}

	public int getAge() {

		return this.age;

	}
	
}
