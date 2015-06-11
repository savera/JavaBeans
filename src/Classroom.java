import javax.swing.JOptionPane;


public class Classroom {

	public static void main(String[] args) {
		
		Person oscar = new Person();
		
		Person william = new Person();
		
		Person savera = new Person(); 
		
		oscar.setAge(17);
		
		william.setAge(13);
		
		savera.setAge(13);
		
		oscar.setSuperpower("growing");
		
		william.setSuperpower("samrtness");
		
		savera.setSuperpower("writing");
		
		/* JOptionPane.showMessageDialog(null, oscar.getAge());
		
		JOptionPane.showMessageDialog(null, william.getAge());
		
		JOptionPane.showMessageDialog(null, savera.getAge());
		
		JOptionPane.showMessageDialog(null, oscar.getSuperpower());
		
		JOptionPane.showMessageDialog(null, william.getSuperpower());
		
		JOptionPane.showMessageDialog(null, savera.getSuperpower());*/
		
		//String s = savera.superpower;
		
		System.out.println(oscar);
		
		System.out.println(william);

		System.out.println(savera.toString());
		
	}
	
}
