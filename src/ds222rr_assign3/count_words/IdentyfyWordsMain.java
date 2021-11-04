package ds222rr_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class IdentyfyWordsMain {
	
	private static Scanner scan;	// Create Scanner object
	
	public static void main(String[] args) throws MalformedURLException {
		// Create new URL object connected to the link of HistoryOfProgramming.txt
		URL url  = new URL("http://homepage.lnu.se/staff/jlnmsi/java1/HistoryOfProgramming.txt");
		
		try {
			// Connect Scanner object to url to get an input stream
			scan = new Scanner(url.openStream());	
		}
		catch (IOException e) {
			System.out.print("Exception: "+e.getMessage());
		}

		StringBuilder sb = new StringBuilder();		// Create new StringBuilder object
		
		// Iterative statement to append all lines of HistoryOfProgramming.txt to sb
		while (scan.hasNextLine()) {
			String temp = scan.nextLine();
			sb.append(temp);
			// To avoid merging two words after a line break
			if (!temp.endsWith(" ")) {
				sb.append(" ");
			}
		}
		scan.close();					// Close Scanner
		String text = sb.toString();	// StringBuilder to String
		StringBuilder sbNew = new StringBuilder();	// Create new StringBuilder object
		// Iterative statement to append 'file' to StringBuilder sbNew
		for (int i = 0; i < text.length(); i++) {
			// Append only if current character is a letter or whitepace
			if (Character.isLetter(text.charAt(i)) || Character.isWhitespace(text.charAt(i))) {
				sbNew.append((text.charAt(i)));
			}
		}
		String strNew = sbNew.toString();			// Create String object
		// Create new File object for output (C:\Temp\IdentyfyWordsMain)
		File out = new File(args[0]);
		try {
			writeFile(out, strNew);	// write file
		}
		catch(IOException e) {
			System.out.print("Exception: "+e.getMessage());
		}
	}
	
	//Method for writing a textfile
	public static void writeFile(File f, String str) throws FileNotFoundException {
		// Create new PrintWriter object connected to 'f'
		PrintWriter printer = new PrintWriter(f);
		Scanner sc = new Scanner(str);	// Create new Scanner object connected to 'str'
		// Iterative statement to append all words in 'f' to StringBuilder sb
		while (sc.hasNext()) {
			StringBuilder sb = new StringBuilder();
			sb.append(sc.next()+" ");
			String tmp = sb.toString();
			printer.print(tmp);
		}
		sc.close();
		printer.close();
	}
}