import javax.swing.JOptionPane;

public class Person {

	int age;

	private String superpower;

	public static void main(String[] args) {

		Person person = new Person();

		person.setAge(21);

		// JOptionPane.showMessageDialog(null, person.getAge());

		person.setSuperpower("Unlimated strength!");

		// JOptionPane.showMessageDialog(null, person.getSuperpower());

	}

	public void setAge(int age) {

		this.age = age;
	}

	public int getAge() {

		return this.age;
	}

	public void setSuperpower(String superpower) {

		this.superpower = superpower;
	}

	public String getSuperpower() {

		return this.superpower;
	}

	public String toString() {

		return age + ", " + superpower;

	}

}
