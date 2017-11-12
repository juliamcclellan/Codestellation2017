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
	
	public double getCurrentGrade()
	{
		double total = 0, outOf = 0;
		for(AssignmentType a: assignments)
		{
			double avg = a.getCurrentAverage();
			if(avg != Integer.MIN_VALUE)
			{
				total += avg * a.getPercent();
				outOf += a.getPercent();
			}
		}
		if(outOf == 0) return Integer.MIN_VALUE;
		else return total / outOf;
	}
	
	public double getExpectedGrade()
	{
		double total = 0, outOf = 0;
		for(AssignmentType a: assignments)
		{
			double avg = a.getExpectedAverage();
			if(avg != Integer.MIN_VALUE)
			{
				total += avg * a.getPercent();
				outOf += a.getPercent();
			}
		}
		if(outOf == 0) return Integer.MIN_VALUE;
		else return total / outOf;
	}
}