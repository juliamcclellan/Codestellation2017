/***
 * Handles importing and exporting user data
 */

package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import grades.Assignment;
import grades.AssignmentType;
import grades.ClassData;
import grades.MultipleType;
import grades.SingleType;


public class ImportExport
{
	private static final String EXTENSION = ".grade";
	private static final String DIRECTORY = "data/";
	private static final String CLASS_FILE = "classNames";
	private static final String MAIN_FILE = "info";
	private static final String TAKEN = "T", NOT_TAKEN = "N";
	
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
	
	private static ClassData importClass(String name)
	{
		File classFile = new File(DIRECTORY + name + "/" + MAIN_FILE + EXTENSION);
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
		
		ArrayList<AssignmentType> assignments = new ArrayList<AssignmentType>();
		while(scan.hasNextLine())
		{
			String type = scan.nextLine();
			assignments.add(importAssignment(name, type));
		}
		scan.close();
		return new ClassData(name, assignments);
	}
	
	private static AssignmentType importAssignment(String className, String assignmentName)
	{
		File assignmentFile = new File(DIRECTORY + className + "/" + assignmentName + EXTENSION);
		Scanner scan;
		try
		{
			scan = new Scanner(assignmentFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		
		double percent = scan.nextDouble();
		int type = scan.nextInt();
		
		AssignmentType result;
		if(type == 1)
		{
			Assignment a = getAssignment(scan);
			result = new SingleType(assignmentName, percent, a);
		}
		else
		{
			ArrayList<Assignment> a = new ArrayList<Assignment>();
			while(scan.hasNext())
			{
				a.add(getAssignment(scan));
			}
			result = new MultipleType(assignmentName, percent, a);
		}
		
		scan.close();
		return result;
	}
	
	private static Assignment getAssignment(Scanner scan)
	{
		String name = scan.next();
		double score = scan.nextDouble();
		String taken = scan.next();
		
		if(taken.equals(TAKEN))
		{
			return new Assignment(name, score, true);
		}
		else
		{
			return new Assignment(name, score, false);
		}
	}
	
	public static void export(ArrayList<ClassData> classes)
	{
		Path p = Paths.get(DIRECTORY);
		try
		{
			Files.createDirectory(p);
		}
		catch(IOException e){}
		
		File classFile = new File(DIRECTORY + CLASS_FILE + EXTENSION);
		try
		{
			classFile.createNewFile();
		} catch (IOException e){e.printStackTrace();}
		
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(classFile);
		}
		catch(FileNotFoundException e){e.printStackTrace();}
		
		for(ClassData data: classes)
		{
			output.println(data.getName());
			exportClass(data);
		}
		
		output.close();
	}
	
	private static void exportClass(ClassData data)
	{
		Path p = Paths.get(DIRECTORY + data.getName());
		try
		{
			Files.createDirectory(p);
		}
		catch(IOException e1){} //thrown if the directory already exists
		
		File infoFile = new File(DIRECTORY + data.getName() + "/" + MAIN_FILE + EXTENSION);
		try
		{
			infoFile.createNewFile();
		} catch (IOException e){}
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(infoFile);
		}
		catch(FileNotFoundException e){}
		
		for(AssignmentType a: data.getAssignments())
		{
			output.println(a.getName());
			exportAssignment(a, data.getName());
		}
		output.close();
	}
	
	private static void exportAssignment(AssignmentType a, String className)
	{
		File file = new File(DIRECTORY + className + "/" + a.getName() + EXTENSION);
		try
		{
			file.createNewFile();
		} catch (IOException e){}
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(file);
		}
		catch(FileNotFoundException e){}
		
		output.println(a.getPercent());
		if(a instanceof SingleType)
		{
			output.println("1");
			printAssignment(((SingleType) a).getAssignment(), output);
		}
		else if(a instanceof MultipleType)
		{
			output.println("2");
			for(Assignment assignment: ((MultipleType) a).getAssignments())
			{
				printAssignment(assignment, output);
			}
		}
		output.close();
	}
	
	private static void printAssignment(Assignment a, PrintWriter output)
	{
		output.println(a.getName());
		output.println(a.getScore());
		if(a.getTaken()) output.println(TAKEN);
		else output.println(NOT_TAKEN);
	}
	
/*	public static void main(String[] args)
	{
		Assignment a1 = new Assignment("hw1", 90), a2 = new Assignment("hw2", 80, false), e = new Assignment("final", 85);
		SingleType exam = new SingleType("Final", 50, e);
		ArrayList<Assignment> alist = new ArrayList<Assignment>();
		alist.add(a1);
		alist.add(a2);
		MultipleType hw = new MultipleType("Homework", 50, alist);
		ArrayList<AssignmentType> list = new ArrayList<AssignmentType>();
		list.add(hw);
		list.add(exam);
		ClassData c = new ClassData("CS", list);
		ArrayList<ClassData> clist = new ArrayList<ClassData>();
		clist.add(c);
		export(clist);
		ArrayList<ClassData> clist = importData();
		System.out.println(clist);
	}*/
}