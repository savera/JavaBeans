import java.util.Stack;

public class towerOfHanoi {
	public static void main(String[] args) {
		
		Stack<String> brackets = new Stack<String>(); 
		
		brackets.push("{[()]}"); 
		
		brackets.push("{ab]");
		
		brackets.push("{[}]");
		
		for (int i = 0; i < 7; i++) {
			
			if (brackets.contains(brackets.subList(i, i++))) {
				
				brackets.push(brackets.subList(i, i++));
				
			}
			
		}
	}
}
