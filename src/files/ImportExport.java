/***
 * Handles importing and exporting user data
 */

package files;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

import grades.ClassData;


public class ImportExport
{
	private static final String EXTENSION = ".grade";
	private static final String DIRECTORY = "data/";
	private static final String CLASS_FILE = "classNames";
	
	public static ArrayList<ClassData> importData()
	{
		File classesFile = new File(DIRECTORY + CLASS_FILE + EXTENSION);
		Scanner scan;
		try
		{
			scan = new Scanner(classesFile);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		
		ArrayList<ClassData> classes = new ArrayList<ClassData>();
		while(scan.hasNextLine())
		{
			String className = scan.nextLine();
			ClassData newClass = importClass(className);
			classes.add(newClass);
		}
		
		scan.close();
		return classes;
	}
	
	public static ClassData importClass(String name)
	{
		File classFile = new File(DIRECTORY + name + EXTENSION);
		Scanner scan;
		try
		{
			scan = new Scanner(classFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}