/**
 * 
 */


/**
 * @author Yogesh
 *
 */
public class VigenereCipher extends CeaserCipher {

	/**
	 * @param args
	 */
	
	private CeaserCipher[] vCipher;
	private String lowerCaseString = "abcdefghijklmnopqrstuvwxyz";
	private String upperCaseString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public VigenereCipher(int keyLength)
	{
		vCipher = new CeaserCipher[keyLength];
		for(int i=0; i<keyLength; i++)
		{
			vCipher[i] = new CeaserCipher();
		}
	}
	
	private String encrypt(String message, String key)
	{
		String encMessage = "";
		for(char c : message.toCharArray())
		{
			int temp = message.indexOf(c)%key.length();
			char keyChar = key.charAt(temp);
			int keyValue = getKeyIndex(keyChar);
			if(keyValue != -1)
				encMessage += vCipher[temp].encrypt(""+c, keyValue);
		}
		return encMessage;
	}
	
	private int getKeyIndex(char key) {
		// TODO Auto-generated method stub		
		if(lowerCaseString.indexOf(key) != -1)
		{
			return lowerCaseString.indexOf(key)+1;
		}
		else 
			if(upperCaseString.indexOf(key) != -1)
			{
				return upperCaseString.indexOf(key)+1;
			}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Vigenere Cipher------------------");
		String message = "Hi Yogesh";
		String key = "AaB";
		VigenereCipher vc = new VigenereCipher(key.length());
		String encMessage = vc.encrypt(message, key);	
		System.out.println("Original Message: " + message);
		System.out.println("Encoded Message: " + encMessage);
	}
}
