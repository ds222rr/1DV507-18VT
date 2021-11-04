package ds222rr_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {

	public static void main(String[] args) {
		File file = new File(args[0]);	// Create new File object
		HashWordSet hashWordSet = new HashWordSet();	// Create new HashWordSet object
		TreeWordSet treeWordSet = new TreeWordSet();	// Create new TreeWordSet object
		String str = "";
		try {
			str = readFile(file);	// read text
		}
		catch(Exception e) {
			System.out.print("Exception: "+e.getMessage());
		}
		String[] words = str.split(" ");	// Create new String object for words in 'str'
		// Iterative statement to add content of 'words' to both sets
		for (int i = 0; i < words.length; i++) {
			hashWordSet.add(new Word(words[i]));
			treeWordSet.add(new Word(words[i]));
		}
		System.out.println("HashSet: "+hashWordSet.size());
		System.out.println("TreeSet: "+treeWordSet.size());
		
		// Iterate over all elements in 'treeWordSet'
		Iterator<Word> it = treeWordSet.iterator();
		System.out.println("TreeSet Iterator: ");
		int a = 0;
		while (it.hasNext()) {
			Object n = it.next();
			System.out.print(n+" ");
			a++;
			if (a%10 == 0) {
				System.out.print("\n");
			}
		}
	}
	//Method for reading a textfile
	public static String readFile(File f) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();	// Create new StringBuilder object
		Scanner sc = new Scanner(f);			// Create new Scanner object connected to 'f'
		// Iterative statement to append all lines in 'f' to StringBuilder sb
		while (sc.hasNextLine()) {
			String temp = sc.nextLine();
			sb.append(temp);
			// To avoid merging two words after a line break
			if (!temp.endsWith(" ")) {
				sb.append(" ");
			}
		}
		sc.close();
		return sb.toString();
	}
}
