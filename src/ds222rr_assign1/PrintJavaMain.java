package ds222rr_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintJavaMain {
	
	private static int dirNumber = 0;		// Directory number
	private static int subDirectory = 1;	// Increase number of tabs to indent sub-directories
	
	public static void main(String[] args)  throws FileNotFoundException {
		File dir = new File (args[0]);		// Create new File object
		printAllJavaFiles(dir);
	}
	
	private static void printAllJavaFiles(File file) throws FileNotFoundException {
		if (file.isDirectory ()) {					// In case File is a directory
			printDir(file);						
			subDirectory++;							// Enter sub-directory
			File [] allFiles = file.listFiles();	// Create new array object to store all files
			// Iterative statement to print all sub-directories and java-files recursively
			for (int i = 0; i < allFiles.length; i++) {
				printAllJavaFiles(allFiles[i]);
			}
			subDirectory--;							// Leave sub-directory
		}
		
		else if (file.getName().endsWith("java")) {	// In case of a java-file
			printJavaFile(file);
		}		
	}
		
	private static void printDir(File directory) {	// Print directory name
		StringBuilder indent = new StringBuilder();	// Create new StringBuilder object
		StringBuilder dashes = new StringBuilder();	// Create new StringBuilder object
		// Iterative statement to indent sub-directories
		for (int i = 0; i < subDirectory; i++) {
			indent.append("\t");
		}
		// Iterative statement to create a dash string for the directories
		String string = (++dirNumber) + indent.toString() + directory.getName();
		for (int i = 0; i < directory.getName().length(); i++) {
			dashes.append('-');
		}
		System.out.println (string);
		System.out.println (indent.toString() + dashes.toString());
	}
	
	// Print Java file and its size in rows
	private static void printJavaFile(File javaFile) throws FileNotFoundException {
		StringBuilder indent = new StringBuilder();	// Create new StringBuilder object
		int rows = 0;								// Size of the Java file
		// Iterative statement to indent sub-directories
		for (int i = 0; i < subDirectory-1; i++) {
			indent.append("\t");
		}
		Scanner sc = new Scanner(javaFile);			// Create new Scanner object connected to javaFile
		while (sc.hasNextLine()) {	// Iterative statement to count the rows of the file
			sc.nextLine();
			rows++;
		}
		System.out.println(indent.toString() + javaFile.getName() + "("+rows+")");
		sc.close();	// Close Scanner
	}
}