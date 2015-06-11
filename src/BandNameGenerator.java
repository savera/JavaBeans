import java.util.ArrayList;
import java.util.Random;

public class BandNameGenerator {
	
	static int adjIndex;
	
	static int nIndex; 

public static void main(String[] args) {
	
	ArrayList<String> adjective = new ArrayList<String>();
	
	ArrayList<String> noun = new ArrayList<String>();
	
	adjective.add("Creepy"); 
	
	adjective.add("Sparkly"); 
	
	adjective.add("Fluffy"); 
	
	adjective.add("Slimy"); 

	noun.add("Turtles"); 
	
	noun.add("Creeps"); 
	
	noun.add("Pumkins"); 
	
	noun.add("Dorks");

	Random rand = new Random(); 
	
	adjIndex = rand.nextInt(adjective.size());
	
	nIndex = rand.nextInt(noun.size());
	
	System.out.println(adjective.get(adjIndex));
	
	System.out.println(noun.get(nIndex));
	
}	
	
}
