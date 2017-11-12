/**
 * Contains information about a class.
 */

package grades;

import java.util.ArrayList;

public class ClassData
{
	private String name;
	private ArrayList<AssignmentType> assignments;
	
	public ClassData(String name)
	{
		this.name = name;
		assignments = new ArrayList<AssignmentType>();
	}
	
	public ClassData(String name, ArrayList<AssignmentType> assignments)
	{
		this.name = name;
		this.assignments = assignments;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<AssignmentType> getAssignments()
	{
		return assignments;
	}

	public void setAssignments(ArrayList<AssignmentType> assignments)
	{
		this.assignments = assignments;
	}
}