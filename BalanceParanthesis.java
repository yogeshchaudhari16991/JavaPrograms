import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author Yogesh
 *
 */

/*
 * Java program to check if parenthesis are balanced in given string or not
 * Also ignores characters which are not a parenthesis to check balance
 * And prints if parenthesis are balanced or not in given string
 * 
 * On Executing Java Program:
 * 
 * Enter String to check for Paranthesis Balance: 
 * {({()}{}{}{()})}{({{}})(){}}   <--- Input String 
 * String entered: {({()}{}{}{()})}{({{}})(){}}
 * Parenthesis are balanced       <--- Resulting output
 * 
 */
public class BalanceParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to check for Paranthesis Balance: ");
		String str = sc.nextLine();
		System.out.println("String entered: " + str);
		System.out.println(checkParenthesisBalance(str));	
		sc.close();
	}

	public static String checkParenthesisBalance(String str) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<Character>();
		if(checkParenthesis(str, st)){
			return "Parenthesis are balanced";
		} 
		return "Parenthesis are unbalanced";
	}

	private static boolean checkParenthesis(String str, Stack<Character> st){	
		if(str.isEmpty()){
			return true;
		} else {
			if(str.charAt(0) == '('){
				st.push(')');
			} else if(str.charAt(0) == '{') {
				st.push('}');
			} else if(str.charAt(0) == '['){
				st.push(']');
			} else if(str.charAt(0)=='}' || str.charAt(0)==')' || str.charAt(0)==']'){ 
					if(str.charAt(0) != st.pop()) {
					return false;
				}
			}
			return checkParenthesis(str.substring(1), st);
		}
	}
	
}
