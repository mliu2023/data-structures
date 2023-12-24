import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
/**
* Class to read from a file and count frequencies of words.
* @author Max Liu
* @version 1.0
*/
public class ReadingFromFile{

	/**
	* Main method in the class.
	* @param args The command line arguments.
	*/
	public static void main(String[] args){
		ArrayList<String> inputs = new ArrayList<>();
		readFile("input.txt", inputs);
		System.out.println(inputs);
		ArrayList<String> inputs2 = new ArrayList<>();
		readFile("input2.txt", inputs2);
		frequencyCount(inputs);
		frequencyCount(inputs2);
	}
	/**
	* Counts the frequency of each word in the arraylist.
	* @param list The arraylist with words from a file.
	*/
	public static void frequencyCount(ArrayList<String> list){
		// 300=400*.75 words should be enough to cover most texts.
		HashMap<String, Integer> h = new HashMap<String, Integer>(400);
		for(int i = 0; i < list.size(); i++){
			String word = list.get(i);
			if(h.containsKey(word)){
				h.put(word, h.get(word)+1);
			}
			else{
				h.put(word, 1);
			}
		}
		System.out.println(h);
	}
  /**
  *This method reads the file with the specified name
  *and adds each String within the file to the specified ArrayList of Strings.
  *It achieves this through the following algorithm:
  *If the file with the specified name does not exist in the current directory,
  *the method throws a FileNotFoundException and prints " Cannot open " + the file name.
  *Otherwise, it initializes a Scanner object called input and passes the file name as a parameter to input's constructor.
  *Then, while hasNextLine() returns true for input, input.nextLine() is added to the ArrayList.
  *Precondition: file with specified name exists in current directory
  *@param name the name of the file that is supposed to be read
  *@param list the ArrayList of Strings to which each String within the file is added
  */
	public static void readFile(String name, ArrayList<String> list)
	{
		File file = new File(name);
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + name );
			System.exit(1);
		}

		while( input.hasNextLine() )
		{
			String s = input.nextLine();
				list.add(s);
		}
	}

}
