package files;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;

import grades.ClassData;

public class Login
{
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
		return ImportExport.importData(); // to be implemented later
	}
	
	public static boolean newUser(String username, String password)
	{
		BCrypt.hashpw(password, BCrypt.gensalt();
	}
}
