/**
 * 
 */

/**
 * @author Yogesh
 *
 */
public class CeaserCipher {

	/**
	 * @param args
	 */
	
	private String lowerCaseString, upperCaseString;
	private String shiftedLowerCaseString, shiftedUpperCaseString, shiftedLowerCaseString1, shiftedUpperCaseString1;
	
	public CeaserCipher()
	{
		lowerCaseString = "abcdefghijklmnopqrstuvwxyz";
		upperCaseString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	
	public static void main(String[] args) {
		CeaserCipher cs = new CeaserCipher();
		String str = "First Legion #123";
		int key = 23;
		System.out.println("\n-----------Encrypt with one key----------\n");
		System.out.println("Original String: " + str + ", Key: " + key);
		str = cs.encrypt(cs, str, key);
		System.out.println("Modified String: "+ str);
		int key1 = key;
		int key2 = 17;
		str = "First Legion #123";
		System.out.println("\n------------Encrypt with two keys----------\n");
		System.out.println("Original String: " + str + ", Key1: " + key1 + ", Key2: " + key2);
		str = cs.encrypt(cs, str, key1, key2);
		System.out.println("Modified String: "+ str);
		//System.out.println(cs.encrypt(cs, "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
		//System.out.println(cs.encrypt(cs, "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
	}
	
	private String encrypt(CeaserCipher cs, String str, int key)
	{
		StringBuilder sb = new StringBuilder(str);
		if(key < 0)
			return null;
		cs.stringShift(key);
		for(int i=0; i<sb.length(); i++)
		{
			char ch = sb.charAt(i);
			if(Character.isAlphabetic(ch))
			{
				if(Character.isLowerCase(ch))
				{
					sb.setCharAt(i, shiftedLowerCaseString.charAt(lowerCaseString.indexOf(ch)));
				}
				else
				{
					sb.setCharAt(i, shiftedUpperCaseString.charAt(upperCaseString.indexOf(ch)));
				}
			}
		}
		return sb.toString();
	}
	
	protected String encrypt(String str, int key)
	{
		StringBuilder sb = new StringBuilder(str);
		if(key <= 0)
			return null;
		this.stringShift(key);
		for(int i=0; i<sb.length(); i++)
		{
			char ch = sb.charAt(i);
			if(Character.isAlphabetic(ch))
			{
				if(Character.isLowerCase(ch))
				{
					sb.setCharAt(i, shiftedLowerCaseString.charAt(lowerCaseString.indexOf(ch)));
				}
				else
				{
					sb.setCharAt(i, shiftedUpperCaseString.charAt(upperCaseString.indexOf(ch)));
				}
			}
		}
		return sb.toString();
	}
	
	private String encrypt(CeaserCipher cs, String str, int key1, int key2)
	{
		StringBuilder sb = new StringBuilder(str);
		if(key1 < 0 || key2 < 0)
			return null;
		cs.stringShift(key1, key2);
		for(int i=0; i<sb.length(); i++)
		{
			char ch = sb.charAt(i);
			if(Character.isAlphabetic(ch))
			{
				if(i%2 == 0){
					if(Character.isLowerCase(ch))
					{
						sb.setCharAt(i, shiftedLowerCaseString.charAt(lowerCaseString.indexOf(ch)));
					}
					else
					{
						sb.setCharAt(i, shiftedUpperCaseString.charAt(upperCaseString.indexOf(ch)));
					}
				}
				else
				{
					if(Character.isLowerCase(ch))
					{
						sb.setCharAt(i, shiftedLowerCaseString1.charAt(lowerCaseString.indexOf(ch)));
					}
					else
					{
						sb.setCharAt(i, shiftedUpperCaseString1.charAt(upperCaseString.indexOf(ch)));
					}
				}
			}
		}
		return sb.toString();
	}
	
	private void stringShift(int key){
		if(lowerCaseString != null)
			shiftedLowerCaseString = lowerCaseString.substring(key) + lowerCaseString.substring(0, key);
		if(upperCaseString != null)
			shiftedUpperCaseString = upperCaseString.substring(key) + upperCaseString.substring(0, key);
	}
	
	private void stringShift(int key1, int key2){
		if(lowerCaseString != null)
		{
			shiftedLowerCaseString = lowerCaseString.substring(key1) + lowerCaseString.substring(0, key1);
			shiftedLowerCaseString1 = lowerCaseString.substring(key2) + lowerCaseString.substring(0, key2);
		}
		if(upperCaseString != null)
		{
			shiftedUpperCaseString = upperCaseString.substring(key1) + upperCaseString.substring(0, key1);
			shiftedUpperCaseString1 = upperCaseString.substring(key2) + upperCaseString.substring(0, key2);
		}
	}
}
