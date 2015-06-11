import java.util.HashMap;


public class HashMaps {

	public static void main(String[] args) {
		
	
	HashMap<String, String> bffs = new HashMap<String, String>();
	
	bffs.remove("June"); 
	
	bffs.put("June", "Captain Kirk");
	
	System.out.println(bffs.get("Uhura"));
	
	if(bffs.get("Captain Kirk") == null){
		
		System.out.println("Captain Kirk has no best friends!!");
		
	}
	
	}
	
}
