package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Scanner;

import grades.ClassData;

public class Login
{
	private static final String PASSWORD = "pw";
	
	/**
	 * Attempts to log in a user
	 * @param username The user's entered username
	 * @param password The user's entered password
	 * @return The user's class data if login was successful (an empty arraylist if 
	 * there is no data for the user), or null if the user does not exist or entered
	 *  an incorrect password
	 */
	public static ArrayList<ClassData> login(String username, String password)
	{
		File f = new File(ImportExport.DIRECTORY + username);
		if(!f.exists()) return null;
		
		File pwFile = new File(ImportExport.DIRECTORY + username + "/" + PASSWORD + ImportExport.EXTENSION);
		Scanner scan;
		try
		{
			scan = new Scanner(pwFile);
		} catch (FileNotFoundException e)
		{
			return null;
		}
		String pw = scan.nextLine();
		scan.close();
		
		if(BCrypt.checkpw(password, pw)) return ImportExport.importData(username);
		else return null;
	}
	
	public static boolean newUser(String username, String password)
	{
		File root = new File(ImportExport.DIRECTORY);
		if(!root.exists()) root.mkdir();
		
		File dir = new File(ImportExport.DIRECTORY + username);
		if(dir.exists()) return false;
		else dir.mkdir();
		File pw = new File(ImportExport.DIRECTORY + username + "/" + PASSWORD + ImportExport.EXTENSION);
		try
		{
			pw.createNewFile();
		} catch (IOException e1) {}
		
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(pw);
		} catch (FileNotFoundException e){} 
		output.print(BCrypt.hashpw(password, BCrypt.gensalt()));
		output.close();
		return true;
	}
}
