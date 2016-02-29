import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Yogesh
 *
 */
public class WordFrequency {
	
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreq;
	
	public WordFrequency(){
		myWords = new ArrayList<String>();
		myFreq = new ArrayList<Integer>();
	}
	
	private void findUnique()
	{
		myWords.clear();
		myFreq.clear();
		try {
			Scanner scr = new Scanner(new File("C:/Yogesh/y.txt"));
			while(scr.hasNextLine())
			{
				Scanner wscr = new Scanner(scr.nextLine());
				while(wscr.hasNext())
				{
					String word = wscr.next();
					if(!myWords.contains(word.toLowerCase()))
					{
						myWords.add(word.toLowerCase());
						myFreq.add(1);
					}
					else
					{
						int index = myWords.indexOf(word.toLowerCase());
						int count = myFreq.get(index);
						count++;
						myFreq.set(index,  count);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int findIndexOfMax()
	{
		int max = 0;
		int index = 0;
		for(int count : myFreq)
		{
			if(max < count)
			{
				index = myFreq.indexOf(count);
				max = count;
			}
		}
		return index;
	}
	
	public static void main(String args[]){
		WordFrequency wf = new WordFrequency();
		wf.findUnique();
		System.out.println("Number of Unique Words: "+ wf.myWords.size());
		for(String word : wf.myWords)
		{
			int index = wf.myWords.indexOf(word);
			System.out.println("Word: "+ word + ", Frequency: "+ wf.myFreq.get(index));
		}
		int index = wf.findIndexOfMax();
		System.out.println("Max Occuring Word: "+ wf.myWords.get(index) + ", Frequency: "+ wf.myFreq.get(index));
	}
	
	
}
