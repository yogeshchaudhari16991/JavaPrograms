/**
 * 
 */

/**
 * @author Yogesh
 *
 */
public class WordPlay {

	/**
	 * @param args
	 */
	
	private String vowelList = "aeiou";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("------------WordPlay.java--------------");
			WordPlay wp = new WordPlay();
			System.out.println("--------------Vowel Test---------------");
			isVowelTest("CIci", wp);
			System.out.println("------------Replace Vowel--------------");
			replaceVowelsTest(wp, "Hello Yogesh Chaudhari", '#');
			System.out.println("-------------Emphasize-----------------");
			emphasizeTest(wp, "My name is Yogesh Chaudhari. How are you?",'a');
	}
	
	public static void isVowelTest(String str, WordPlay wp){
		char ch;
		StringBuilder sb = new StringBuilder("CIci");
		for(int i = 0; i<sb.length(); i++)
		{
			ch = sb.charAt(i);
			if(wp.isVowel(ch))
			{
				System.out.println("Character " + ch + " is Vowel");
			}
			else 
			{
				System.out.println("Character " + ch + " is Consonant");
			}
		}	
	}
	
	private boolean isVowel(char ch) {
		if(vowelList.contains(""+Character.toLowerCase(ch)))
		{
			return true;
		}
		return false;
	}
	
	public static void replaceVowelsTest(WordPlay wp, String str, char ch){
		System.out.println("Original String :"+str);
		str = wp.replaceVowels(str, ch);
		System.out.println("Modified String :"+str);
	}
	
	private String replaceVowels(String str, char ch){
		StringBuilder sb = new StringBuilder(str);
		for(int i=0; i<sb.length(); i++)
		{
			if(isVowel(sb.charAt(i))){
				sb.setCharAt(i, ch);
			}
		}
		return sb.toString();
	}
	
	public static void emphasizeTest(WordPlay wp, String str, char ch){
		System.out.println("Original String: "+ str);
		str = wp.emphasize(str, ch);
		System.out.println("Modified String: "+ str);
	}
	
	private String emphasize(String str, char ch){
		StringBuilder sb = new StringBuilder(str);
		for(int i=0; i<sb.length(); i++)
		{
			if(sb.charAt(i) == ch)
			{
				if((i%2) == 0)
				{
					sb.setCharAt(i, '*');
				}
				else
				{
					sb.setCharAt(i, '+');
				}
			}
		}
		return sb.toString();
	}
}
