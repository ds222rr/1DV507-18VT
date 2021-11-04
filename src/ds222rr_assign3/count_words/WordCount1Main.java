package ds222rr_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {

	public static void main(String[] args) {
		File file = new File(args[0]);	// Create new File object
		HashSet<Word> hashSet = new HashSet<Word>();	// Create new HasSet object
		TreeSet<Word> treeSet = new TreeSet<Word>();	// Create new TreeSet object
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
			hashSet.add(new Word(words[i]));
			treeSet.add(new Word(words[i]));
		}
		System.out.println("HasSet: "+hashSet.size());
		System.out.println("TreeSet: "+treeSet.size());
		
		// Iterate over all elements in 'treeSet'
		Iterator<Word> it = treeSet.iterator();
		System.out.println("TreeSet Iterator: ");
		int a = 0;
		while (it.hasNext()) {
			Word n = it.next();
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
