/**
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
/**
 * @author Yogesh
 *
 */
public class CharactersInPlay {

	/**
	 * @param args
	 */
	
	private ArrayList<String> speaker;
	private ArrayList<Integer> count;
	
	public CharactersInPlay()
	{
		speaker = new ArrayList<String>();
		count = new ArrayList<Integer>();
	}
	
	private void update(String person) {
		if(! speaker.contains(person))
		{
			speaker.add(person);
			count.add(1);
		}
		else
		{
			int index = speaker.indexOf(person);
			int value = count.get(index);
			count.set(index, ++value);
		}
	}
	
	private void findAllCharacters(String path) {
		try
		{
			speaker.clear();
			count.clear();
			Scanner scr = new Scanner(new File(path));
			while(scr.hasNextLine())
			{
				String str = scr.nextLine();
				System.out.println(str);
				if(str.contains("."))
				{
					Scanner wscr = new Scanner(str);
					String line = "";
					while(wscr.hasNext())
					{
						if(line.contains("."))
						{
							update(line.substring(0, line.length()-1));
							break;
						}
						line = line + " " + wscr.next();
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharactersInPlay cip = new CharactersInPlay();
		cip.findAllCharacters("C:/Yogesh/Study/Coursera/Java Programming/Java Programs/macbethSmall.txt");
		System.out.println("------------Frequency of Speakers------------");
		for(int i=0; i<cip.speaker.size(); i++)
		{
			System.out.println("Speaker Name: "+ cip.speaker.get(i) + ", Frequency: "+cip.count.get(i));
		}		
	}

}
